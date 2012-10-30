/**
 * Copyright (C) 2012 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.maths.highlevelapi.functions.DOGMAFunctionCollection;

import com.opengamma.maths.highlevelapi.datatypes.primitive.OGArraySuper;
import com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.Acos;
import com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.Asin;
import com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.Atan;
import com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.Cos;
import com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.Cosh;
import com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.Sin;
import com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.Sinh;
import com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.Tan;
import com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.Tanh;
import com.opengamma.maths.highlevelapi.functions.DOGMAinterfaces.DOGMATrigonometaryAPI;

/**
 * Provides trigonometric functions to DOGMA
 */
public class DOGMATrigonometry implements DOGMATrigonometaryAPI {
  private static final Sin SIN = new Sin();
  private static final Cos COS = new Cos();
  private static final Tan TAN = new Tan();
  private static final Asin ASIN = new Asin();
  private static final Acos ACOS = new Acos();
  private static final Atan ATAN = new Atan();
  private static final Sinh SINH = new Sinh();
  private static final Cosh COSH = new Cosh();
  private static final Tanh TANH = new Tanh();

  @Override
  public OGArraySuper<? extends Number> sin(OGArraySuper<? extends Number> array1) {
    return SIN.sin(array1);
  }

  @Override
  public OGArraySuper<? extends Number> cos(OGArraySuper<? extends Number> array1) {
    return COS.cos(array1);
  }

  @Override
  public OGArraySuper<? extends Number> tan(OGArraySuper<? extends Number> array1) {
    return TAN.tan(array1);
  }

  @Override
  public OGArraySuper<? extends Number> asin(OGArraySuper<? extends Number> array1) {
    return ASIN.asin(array1);
  }

  @Override
  public OGArraySuper<? extends Number> acos(OGArraySuper<? extends Number> array1) {
    return ACOS.acos(array1);
  }

  @Override
  public OGArraySuper<? extends Number> atan(OGArraySuper<? extends Number> array1) {
    return ATAN.atan(array1);
  }

  @Override
  public OGArraySuper<? extends Number> sinh(OGArraySuper<? extends Number> array1) {
    return SINH.sinh(array1);
  }

  @Override
  public OGArraySuper<? extends Number> cosh(OGArraySuper<? extends Number> array1) {
    return COSH.cosh(array1);
  }

  @Override
  public OGArraySuper<? extends Number> tanh(OGArraySuper<? extends Number> array1) {
    return TANH.tanh(array1);
  }

}
