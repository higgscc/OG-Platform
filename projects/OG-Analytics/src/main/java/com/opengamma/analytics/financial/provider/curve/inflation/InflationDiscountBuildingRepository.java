/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.analytics.financial.provider.curve.inflation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.opengamma.analytics.financial.curve.inflation.generator.GeneratorPriceIndexCurve;
import com.opengamma.analytics.financial.instrument.index.IndexPrice;
import com.opengamma.analytics.financial.interestrate.InstrumentDerivative;
import com.opengamma.analytics.financial.interestrate.InstrumentDerivativeVisitor;
import com.opengamma.analytics.financial.provider.curve.CurveBuildingBlock;
import com.opengamma.analytics.financial.provider.curve.CurveBuildingBlockBundle;
import com.opengamma.analytics.financial.provider.description.inflation.InflationProviderDiscount;
import com.opengamma.analytics.financial.provider.description.inflation.InflationProviderInterface;
import com.opengamma.analytics.financial.provider.sensitivity.inflation.InflationSensitivity;
import com.opengamma.analytics.financial.provider.sensitivity.inflation.ParameterSensitivityInflationMatrixCalculator;
import com.opengamma.analytics.math.function.Function1D;
import com.opengamma.analytics.math.linearalgebra.DecompositionFactory;
import com.opengamma.analytics.math.matrix.CommonsMatrixAlgebra;
import com.opengamma.analytics.math.matrix.DoubleMatrix1D;
import com.opengamma.analytics.math.matrix.DoubleMatrix2D;
import com.opengamma.analytics.math.matrix.MatrixAlgebra;
import com.opengamma.analytics.math.rootfinding.newton.BroydenVectorRootFinder;
import com.opengamma.util.tuple.ObjectsPair;
import com.opengamma.util.tuple.Pair;

/**
 * Functions to build curves.
 * TODO: REVIEW: Embed in a better object.
 */
public class InflationDiscountBuildingRepository {

  /**
   * The absolute tolerance for the root finder.
   */
  private final double _toleranceAbs;
  /**
   * The relative tolerance for the root finder.
   */
  private final double _toleranceRel;
  /**
   * The mximum number of steps for the root finder.
   */
  private final int _stepMaximum;

  /**
   * The root finder used for curve calibration.
   */
  private final BroydenVectorRootFinder _rootFinder;
  /**
   * The matrix algebra used for matrix inversion.
   */
  private static final MatrixAlgebra MATRIX_ALGEBRA = new CommonsMatrixAlgebra();

  /**.+-
   * Constructor.
   * @param toleranceAbs The absolute tolerance for the root finder.
   * @param toleranceRel The relative tolerance for the root finder.
   * @param stepMaximum The maximum number of step for the root finder.
   */
  public InflationDiscountBuildingRepository(double toleranceAbs, double toleranceRel, int stepMaximum) {
    _toleranceAbs = toleranceAbs;
    _toleranceRel = toleranceRel;
    _stepMaximum = stepMaximum;
    _rootFinder = new BroydenVectorRootFinder(_toleranceAbs, _toleranceRel, _stepMaximum, DecompositionFactory.getDecomposition(DecompositionFactory.SV_COLT_NAME));
    // TODO: make the root finder flexible. 
    // TODO: create a way to select the SensitivityMatrixMulticurve calculator (with underlying curve or not)
  }

  /**
   * Build a unit of curves.
   * @param instruments The instruments used for the unit calibration.
   * @param initGuess The initial parameters guess.
   * @param knownData The known data (fx rates, other curves, model parameters, ...)
   * @param discountingMap The discounting curves names map.
   * @param forwardIborMap The forward curves names map.
   * @param forwardONMap The forward curves names map.
   * @param generatorsMap The generators map.
   * @param calculator The calculator of the value on which the calibration is done (usually ParSpreadMarketQuoteCalculator (recommended) or converted present value).
   * @param sensitivityCalculator The parameter sensitivity calculator.
   * @return The new curves and the calibrated parameters.
   */
  private Pair<InflationProviderDiscount, Double[]> makeUnit(InstrumentDerivative[] instruments, double[] initGuess, final InflationProviderDiscount knownData,
      final LinkedHashMap<String, IndexPrice[]> inflationMap, final LinkedHashMap<String, GeneratorPriceIndexCurve> generatorsMap,
      final InstrumentDerivativeVisitor<InflationProviderInterface, Double> calculator, final InstrumentDerivativeVisitor<InflationProviderInterface, InflationSensitivity> sensitivityCalculator)
  {
    final GeneratorInflationProviderDiscount generator = new GeneratorInflationProviderDiscount(knownData, inflationMap, generatorsMap);
    final InflationDiscountBuildingData data = new InflationDiscountBuildingData(instruments, generator);
    final Function1D<DoubleMatrix1D, DoubleMatrix1D> curveCalculator = new InflationDiscountFinderFunction(calculator, data);
    final Function1D<DoubleMatrix1D, DoubleMatrix2D> jacobianCalculator = new InflationDiscountFinderJacobian(new ParameterSensitivityInflationMatrixCalculator(sensitivityCalculator),
        data);
    //    final Function1D<DoubleMatrix1D, DoubleMatrix2D> jacobianCalculator = new MulticurveDiscountFinderJacobian(
    //                new ParameterSensitivityMatrixMulticurveCalculator(sensitivityCalculator), data); // TODO
    final double[] parameters = _rootFinder.getRoot(curveCalculator, new DoubleMatrix1D(initGuess)).getData();
    final InflationProviderDiscount newCurves = data.getGeneratorMarket().evaluate(new DoubleMatrix1D(parameters));
    return new ObjectsPair<InflationProviderDiscount, Double[]>(newCurves, ArrayUtils.toObject(parameters));
  }

  /**
   * Build the Jacobian matrixes associated to a unit of curves.
   * @param instruments The instruments used for the block calibration.
   * @param startBlock The index of the first parameter of the unit in the block.
   * @param nbParameters The number of parameters for each curve in the unit.
   * @param parameters The parameters used to build each curve in the block.
   * @param knownData The known data (FX rates, other curves, model parameters, ...) for the block calibration.
   * @param discountingMap The discounting curves names map.
   * @param forwardIborMap The forward curves names map.
   * @param forwardONMap The forward curves names map.
   * @param generatorsMap The generators map.
   * @param sensitivityCalculator The parameter sensitivity calculator for the value on which the calibration is done 
  (usually ParSpreadMarketQuoteDiscountingProviderCalculator (recommended) or converted present value).
   * @return The part of the inverse Jacobian matrix associated to each curve. 
   * The Jacobian matrix is the transition matrix between the curve parameters and the par spread.
   * TODO: Currently only for the ParSpreadMarketQuoteDiscountingProviderCalculator.
   */
  private DoubleMatrix2D[] makeCurveMatrix(InstrumentDerivative[] instruments, int startBlock, int[] nbParameters, Double[] parameters, final InflationProviderDiscount knownData,
      final LinkedHashMap<String, IndexPrice[]> inflationMap, final LinkedHashMap<String, GeneratorPriceIndexCurve> generatorsMap,
      final InstrumentDerivativeVisitor<InflationProviderInterface, InflationSensitivity> sensitivityCalculator) {
    final GeneratorInflationProviderDiscount generator = new GeneratorInflationProviderDiscount(knownData, inflationMap, generatorsMap);
    final InflationDiscountBuildingData data = new InflationDiscountBuildingData(instruments, generator);
    final Function1D<DoubleMatrix1D, DoubleMatrix2D> jacobianCalculator = new InflationDiscountFinderJacobian(new ParameterSensitivityInflationMatrixCalculator(sensitivityCalculator),
        data);
    //    final Function1D<DoubleMatrix1D, DoubleMatrix2D> jacobianCalculator =
    //                new MulticurveDiscountFinderJacobian(new ParameterSensitivityMatrixMulticurveCalculator(sensitivityCalculator), data); // TODO
    final DoubleMatrix2D jacobian = jacobianCalculator.evaluate(new DoubleMatrix1D(parameters));
    final DoubleMatrix2D inverseJacobian = MATRIX_ALGEBRA.getInverse(jacobian);
    double[][] matrixTotal = inverseJacobian.getData();
    DoubleMatrix2D[] result = new DoubleMatrix2D[nbParameters.length];
    int startCurve = 0;
    for (int loopmat = 0; loopmat < nbParameters.length; loopmat++) {
      double[][] matrixCurve = new double[nbParameters[loopmat]][matrixTotal.length];
      for (int loopparam = 0; loopparam < nbParameters[loopmat]; loopparam++) {
        matrixCurve[loopparam] = matrixTotal[startBlock + startCurve + loopparam].clone();
      }
      result[loopmat] = new DoubleMatrix2D(matrixCurve);
      startCurve += nbParameters[loopmat];
    }
    return result;
  }

  /**
   * Build a block of curves.
   * @param instruments The instruments used for the block calibration.
   * @param curveGenerators The curve generators (final version). As an array of arrays, representing the units and the curves within the units.
   * @param curveNames The names of the different curves. As an array of arrays, representing the units and the curves within the units.
   * @param parametersGuess The initial guess for the parameters. As an array of arrays, representing the units and the parameters for one unit (all the curves of the unit concatenated).
   * @param knownData The known data (fx rates, other curves, model parameters, ...)
   * @param inflationMap The inflation curves names map.
   * @param calculator The calculator of the value on which the calibration is done (usually ParSpreadMarketQuoteCalculator (recommended) or converted present value).
   * @param sensitivityCalculator The parameter sensitivity calculator.
   * @return A pair with the calibrated yield curve bundle (including the known data) and the CurveBuildingBlckBundle with the relevant inverse Jacobian Matrix.
   */
  public Pair<InflationProviderDiscount, CurveBuildingBlockBundle> makeCurvesFromDerivatives(final InstrumentDerivative[][][] instruments, GeneratorPriceIndexCurve[][] curveGenerators,
      String[][] curveNames,
      double[][] parametersGuess, InflationProviderDiscount knownData, final LinkedHashMap<String, IndexPrice[]> inflationMap,
      final InstrumentDerivativeVisitor<InflationProviderInterface, Double> calculator,
      final InstrumentDerivativeVisitor<InflationProviderInterface, InflationSensitivity> sensitivityCalculator)

  {
    int nbUnits = curveGenerators.length;
    InflationProviderDiscount knownSoFarData = knownData.copy();
    List<InstrumentDerivative> instrumentsSoFar = new ArrayList<InstrumentDerivative>();
    LinkedHashMap<String, GeneratorPriceIndexCurve> generatorsSoFar = new LinkedHashMap<String, GeneratorPriceIndexCurve>();
    LinkedHashMap<String, Pair<CurveBuildingBlock, DoubleMatrix2D>> unitBundleSoFar = new LinkedHashMap<String, Pair<CurveBuildingBlock, DoubleMatrix2D>>();
    List<Double> parametersSoFar = new ArrayList<Double>();
    LinkedHashMap<String, Pair<Integer, Integer>> unitMap = new LinkedHashMap<String, Pair<Integer, Integer>>();
    int startUnit = 0;
    for (int loopunit = 0; loopunit < nbUnits; loopunit++) {
      int nbCurve = curveGenerators[loopunit].length;
      int[] startCurve = new int[nbCurve]; // First parameter index of the curve in the unit. 
      LinkedHashMap<String, GeneratorPriceIndexCurve> gen = new LinkedHashMap<String, GeneratorPriceIndexCurve>();
      int[] nbIns = new int[curveGenerators[loopunit].length];
      int nbInsUnit = 0; // Number of instruments in the unit.
      for (int loopcurve = 0; loopcurve < nbCurve; loopcurve++) {
        startCurve[loopcurve] = nbInsUnit;
        nbIns[loopcurve] = instruments[loopunit][loopcurve].length;
        nbInsUnit += nbIns[loopcurve];
        instrumentsSoFar.addAll(Arrays.asList(instruments[loopunit][loopcurve]));
      }
      InstrumentDerivative[] instrumentsUnit = new InstrumentDerivative[nbInsUnit];
      InstrumentDerivative[] instrumentsSoFarArray = instrumentsSoFar.toArray(new InstrumentDerivative[0]);
      for (int loopcurve = 0; loopcurve < nbCurve; loopcurve++) {
        System.arraycopy(instruments[loopunit][loopcurve], 0, instrumentsUnit, startCurve[loopcurve], nbIns[loopcurve]);
      }
      for (int loopcurve = 0; loopcurve < nbCurve; loopcurve++) {
        GeneratorPriceIndexCurve tmp = curveGenerators[loopunit][loopcurve].finalGenerator(instruments[loopunit][loopcurve]);
        gen.put(curveNames[loopunit][loopcurve], tmp);
        generatorsSoFar.put(curveNames[loopunit][loopcurve], tmp);
        unitMap.put(curveNames[loopunit][loopcurve], new ObjectsPair<Integer, Integer>(startUnit + startCurve[loopcurve], nbIns[loopcurve]));
      }
      Pair<InflationProviderDiscount, Double[]> unitCal = makeUnit(instrumentsUnit, parametersGuess[loopunit], knownSoFarData, inflationMap, gen, calculator,
          sensitivityCalculator);

      parametersSoFar.addAll(Arrays.asList(unitCal.getSecond()));
      DoubleMatrix2D[] mat = makeCurveMatrix(instrumentsSoFarArray, startUnit, nbIns, parametersSoFar.toArray(new Double[0]), knownData, inflationMap, generatorsSoFar,
          sensitivityCalculator);

      for (int loopcurve = 0; loopcurve < curveGenerators[loopunit].length; loopcurve++) {
        unitBundleSoFar.put(curveNames[loopunit][loopcurve], new ObjectsPair<CurveBuildingBlock, DoubleMatrix2D>(new CurveBuildingBlock(unitMap), mat[loopcurve]));
      }
      knownSoFarData.setAll(unitCal.getFirst());
      startUnit = startUnit + nbInsUnit;
    }
    return new ObjectsPair<InflationProviderDiscount, CurveBuildingBlockBundle>(knownSoFarData, new CurveBuildingBlockBundle(unitBundleSoFar));
  }

}
