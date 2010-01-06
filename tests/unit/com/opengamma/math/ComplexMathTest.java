package com.opengamma.math;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.opengamma.math.number.ComplexNumber;

/**
 * 
 * @author emcleod
 * 
 */

public class ComplexMathTest {
  private static final double X = 0.62;
  private static final double Y = -4.5;
  private static final ComplexNumber COMPLEX_X = new ComplexNumber(X, 0);
  private static final ComplexNumber A = new ComplexNumber(0.46, -0.3);
  private static final ComplexNumber B = new ComplexNumber(-3.5, -1.4);
  private static final double EPS = 1e-9;

  @Test
  public void testWrapping() throws Exception {
    final Class<java.lang.Math> javaMathClass = java.lang.Math.class;
    final Class<com.opengamma.math.ComplexMath> mathClass = com.opengamma.math.ComplexMath.class;
    final List<Method> javaMathClassMethods = Arrays.asList(javaMathClass.getDeclaredMethods());
    final Class<?>[] oneParameter = new Class<?>[] { Number.class };
    final Class<?>[] twoParameters = new Class<?>[] { Number.class, Number.class };
    Method mathMethod;
    int length;
    Object primitive1, primitive2, javaMathResult, mathResult;
    for (final Method method : javaMathClassMethods) {
      if (method.isAccessible()) {
        final Class<?>[] parameters = method.getParameterTypes();
        length = parameters.length;
        if (length == 1) {
          mathMethod = mathClass.getMethod(method.getName(), oneParameter);
          primitive1 = getAppropriatePrimitive(parameters[0], X);
          javaMathResult = method.invoke(null, new Object[] { primitive1 });
          mathResult = mathMethod.invoke(null, new Object[] { getAppropriateNumber(primitive1, X) });
          assertEquals(javaMathResult, mathResult);
        } else if (length == 2) {
          mathMethod = mathClass.getMethod(method.getName(), twoParameters);
          primitive1 = getAppropriatePrimitive(parameters[0], X);
          primitive2 = getAppropriatePrimitive(parameters[1], Y);
          javaMathResult = method.invoke(null, new Object[] { primitive1, primitive2 });
          mathResult = mathMethod.invoke(null, new Object[] { getAppropriateNumber(primitive1, X), getAppropriateNumber(primitive2, Y) });
          assertEquals(javaMathResult, mathResult);
        } else {
          if (length == 0) {
            /*
             * Obviously, there is no point in checking the result of two calls
             * to random() for equality
             */
            if (!method.getName().equals("random"))
              throw new NoSuchMethodException("java.lang.Math now has a new method that takes no parameters: it must be wrapped");
          } else {
            throw new NoSuchMethodException("java.lang.Math now has a new method that takes more than two parameters: it must be wrapped");
          }
        }
      }
    }
  }

  @Test
  public void testArithmetic() {
    assertEquals(ComplexMath.asinh(ComplexMath.sinh(X)).doubleValue(), X, EPS);
    assertEquals(ComplexMath.acosh(ComplexMath.cosh(X)).doubleValue(), X, EPS);
    assertEquals(ComplexMath.acosh(ComplexMath.cosh(Y)).doubleValue(), ComplexMath.abs(Y).doubleValue(), EPS);
    assertEquals(ComplexMath.subtract(ComplexMath.add(X, Y), Y).doubleValue(), X, EPS);
    assertEquals(ComplexMath.atanh(ComplexMath.tanh(Y)).doubleValue(), Y, EPS);
  }

  @Test
  public void testComplexArithmetic() {
    // assertComplexEquals((ComplexNumber) Math.cos(Math.acos(A)), A, EPS);
    // assertComplexEquals((ComplexNumber) Math.cosh(Math.acosh(A)), A, EPS);
    // assertComplexEquals((ComplexNumber) Math.subtract(Math.add(X, A), A),
    // COMPLEX_X, EPS);
    // assertComplexEquals((ComplexNumber) Math.subtract(Math.add(A, X), X), A,
    // EPS);
    // assertComplexEquals((ComplexNumber) Math.subtract(Math.add(A, B), B), A,
    // EPS);
    // assertComplexEquals((ComplexNumber) Math.sin(Math.asin(A)), A, EPS);
    // assertComplexEquals((ComplexNumber) Math.sinh(Math.asinh(A)), A, EPS);
    // assertComplexEquals((ComplexNumber) Math.tan(Math.atan(A)), A, EPS);
    // assertComplexEquals((ComplexNumber) Math.tanh(Math.atanh(A)), A, EPS);
    // assertComplexEquals((ComplexNumber) Math.cbrt(Math.pow(A, 3)), A, EPS);
  }

  private void assertComplexEquals(final ComplexNumber actual, final ComplexNumber expected, final double eps) {
    assertEquals(actual.getReal(), expected.getReal(), eps);
    assertEquals(actual.getImaginary(), expected.getImaginary(), eps);
  }

  private Object getAppropriatePrimitive(final Class<?> type, final Double x) {
    final String name = type.getName();
    if (name.equals("double"))
      return x.doubleValue();
    if (name.equals("float"))
      return x.floatValue();
    if (name.equals("long"))
      return x.longValue();
    if (name.equals("int"))
      return x.intValue();
    throw new IllegalArgumentException("Not a primitive number type");
  }

  private Number getAppropriateNumber(final Object primitive, final Double x) {
    final String name = primitive.getClass().getName();
    if (name.equals("java.lang.Double"))
      return x;
    if (name.equals("java.lang.Float"))
      return Float.valueOf(x.floatValue());
    if (name.equals("java.lang.Long"))
      return Long.valueOf(x.longValue());
    if (name.equals("java.lang.Integer"))
      return Integer.valueOf(x.intValue());
    throw new IllegalArgumentException("Not an allowed name for a Number");
  }
}
