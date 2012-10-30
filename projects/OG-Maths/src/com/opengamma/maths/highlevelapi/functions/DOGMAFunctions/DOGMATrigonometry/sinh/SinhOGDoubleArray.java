/**
 * Copyright (C) 2012 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.sinh;

import com.opengamma.maths.highlevelapi.datatypes.primitive.OGDoubleArray;
import com.opengamma.maths.lowlevelapi.functions.checkers.Catchers;

/**
 * 
 */
public final class SinhOGDoubleArray implements SinhAbstract<OGDoubleArray> {
  private static SinhOGDoubleArray s_instance = new SinhOGDoubleArray();

  public static SinhOGDoubleArray getInstance() {
    return s_instance;
  }

  private SinhOGDoubleArray() {
  }

  @Override
  public OGDoubleArray sinh(OGDoubleArray array1) {
    Catchers.catchNullFromArgList(array1, 1);

    final int rowsArray1 = array1.getNumberOfRows();
    final int columnsArray1 = array1.getNumberOfColumns();
    final double[] dataArray1 = array1.getData();
    final int n = dataArray1.length;

    double[] tmp = new double[n];
    for (int i = 0; i < n; i++) {
      tmp[i] = Math.sinh(dataArray1[i]);
    }
    return new OGDoubleArray(tmp, rowsArray1, columnsArray1);
  }

}
