/**
 * Copyright (C) 2012 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry;

import java.util.Map;

import com.google.common.collect.Maps;
import com.opengamma.maths.commonapi.exceptions.MathsExceptionNotImplemented;
import com.opengamma.maths.highlevelapi.datatypes.primitive.OGArraySuper;
import com.opengamma.maths.highlevelapi.datatypes.primitive.OGDoubleArray;
import com.opengamma.maths.highlevelapi.datatypes.primitive.OGSparseArray;
import com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.cosh.CoshAbstract;
import com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.cosh.CoshOGDoubleArray;
import com.opengamma.maths.highlevelapi.functions.DOGMAFunctions.DOGMATrigonometry.cosh.CoshOGSparseArray;
import com.opengamma.maths.lowlevelapi.functions.checkers.Catchers;

/**
 * Overloaded Cosh
 */
public class Cosh {

  /**
   * hashmapped function pointers
   */
  private static Map<Class<?>, CoshAbstract<?>> s_functionPointers = Maps.newHashMap();
  static {
    s_functionPointers.put(OGDoubleArray.class, CoshOGDoubleArray.getInstance());
    s_functionPointers.put(OGSparseArray.class, CoshOGSparseArray.getInstance());    
  }

  @SuppressWarnings("unchecked")
  public <T extends OGArraySuper<? extends Number>> OGArraySuper<? extends Number> cosh(T array1) {
    Catchers.catchNullFromArgList(array1, 1);
    CoshAbstract<T> use = (CoshAbstract<T>) s_functionPointers.get(array1.getClass());
    if (use == null) {
      throw new MathsExceptionNotImplemented("Cosh() on array class " + array1.getClass().toString() + " is not yet implemented");
    }
    return use.cosh(array1);
  }
  
}
