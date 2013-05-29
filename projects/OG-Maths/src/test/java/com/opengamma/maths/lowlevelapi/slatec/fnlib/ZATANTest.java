/**
 * Copyright (C) 2012 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.maths.lowlevelapi.slatec.fnlib;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.opengamma.maths.commonapi.MathsConstants;
import com.opengamma.maths.commonapi.exceptions.MathsExceptionIllegalArgument;
import com.opengamma.maths.commonapi.numbers.ComplexType;
import com.opengamma.maths.highlevelapi.datatypes.primitive.OGComplexMatrix;
import com.opengamma.maths.lowlevelapi.linearalgebra.blas.referenceblas.D1mach;

/**
 * Tests ZATAN
 */
@Test
public class ZATANTest {

  public static double[][] realP = {
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 },
      {-6.2831853071795862, -5.4977871437821380, -4.7123889803846897, -3.9269908169872414, -3.1415926535897931, -2.3561944901923448, -1.5707963267948966, -0.7853981633974483, 0.00,
          0.7853981633974483, 1.5707963267948966, 2.3561944901923439, 3.1415926535897931, 3.9269908169872423, 4.7123889803846897, 5.4977871437821371, 6.2831853071795862 } };

  public static double[][] imagP = {
      {-6.2831853071795862, -6.2831853071795862, -6.2831853071795862, -6.2831853071795862, -6.2831853071795862, -6.2831853071795862, -6.2831853071795862, -6.2831853071795862, -6.2831853071795862,
          -6.2831853071795862, -6.2831853071795862, -6.2831853071795862, -6.2831853071795862, -6.2831853071795862, -6.2831853071795862, -6.2831853071795862, -6.2831853071795862 },
      {-5.4977871437821380, -5.4977871437821380, -5.4977871437821380, -5.4977871437821380, -5.4977871437821380, -5.4977871437821380, -5.4977871437821380, -5.4977871437821380, -5.4977871437821380,
          -5.4977871437821380, -5.4977871437821380, -5.4977871437821380, -5.4977871437821380, -5.4977871437821380, -5.4977871437821380, -5.4977871437821380, -5.4977871437821380 },
      {-4.7123889803846897, -4.7123889803846897, -4.7123889803846897, -4.7123889803846897, -4.7123889803846897, -4.7123889803846897, -4.7123889803846897, -4.7123889803846897, -4.7123889803846897,
          -4.7123889803846897, -4.7123889803846897, -4.7123889803846897, -4.7123889803846897, -4.7123889803846897, -4.7123889803846897, -4.7123889803846897, -4.7123889803846897 },
      {-3.9269908169872414, -3.9269908169872414, -3.9269908169872414, -3.9269908169872414, -3.9269908169872414, -3.9269908169872414, -3.9269908169872414, -3.9269908169872414, -3.9269908169872414,
          -3.9269908169872414, -3.9269908169872414, -3.9269908169872414, -3.9269908169872414, -3.9269908169872414, -3.9269908169872414, -3.9269908169872414, -3.9269908169872414 },
      {-3.1415926535897931, -3.1415926535897931, -3.1415926535897931, -3.1415926535897931, -3.1415926535897931, -3.1415926535897931, -3.1415926535897931, -3.1415926535897931, -3.1415926535897931,
          -3.1415926535897931, -3.1415926535897931, -3.1415926535897931, -3.1415926535897931, -3.1415926535897931, -3.1415926535897931, -3.1415926535897931, -3.1415926535897931 },
      {-2.3561944901923448, -2.3561944901923448, -2.3561944901923448, -2.3561944901923448, -2.3561944901923448, -2.3561944901923448, -2.3561944901923448, -2.3561944901923448, -2.3561944901923448,
          -2.3561944901923448, -2.3561944901923448, -2.3561944901923448, -2.3561944901923448, -2.3561944901923448, -2.3561944901923448, -2.3561944901923448, -2.3561944901923448 },
      {-1.5707963267948966, -1.5707963267948966, -1.5707963267948966, -1.5707963267948966, -1.5707963267948966, -1.5707963267948966, -1.5707963267948966, -1.5707963267948966, -1.5707963267948966,
          -1.5707963267948966, -1.5707963267948966, -1.5707963267948966, -1.5707963267948966, -1.5707963267948966, -1.5707963267948966, -1.5707963267948966, -1.5707963267948966 },
      {-0.7853981633974483, -0.7853981633974483, -0.7853981633974483, -0.7853981633974483, -0.7853981633974483, -0.7853981633974483, -0.7853981633974483, -0.7853981633974483, -0.7853981633974483,
          -0.7853981633974483, -0.7853981633974483, -0.7853981633974483, -0.7853981633974483, -0.7853981633974483, -0.7853981633974483, -0.7853981633974483, -0.7853981633974483 },
      {0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00 },
      {0.7853981633974483, 0.7853981633974483, 0.7853981633974483, 0.7853981633974483, 0.7853981633974483, 0.7853981633974483, 0.7853981633974483, 0.7853981633974483, 0.7853981633974483,
          0.7853981633974483, 0.7853981633974483, 0.7853981633974483, 0.7853981633974483, 0.7853981633974483, 0.7853981633974483, 0.7853981633974483, 0.7853981633974483 },
      {1.5707963267948966, 1.5707963267948966, 1.5707963267948966, 1.5707963267948966, 1.5707963267948966, 1.5707963267948966, 1.5707963267948966, 1.5707963267948966, 1.5707963267948966,
          1.5707963267948966, 1.5707963267948966, 1.5707963267948966, 1.5707963267948966, 1.5707963267948966, 1.5707963267948966, 1.5707963267948966, 1.5707963267948966 },
      {2.3561944901923439, 2.3561944901923439, 2.3561944901923439, 2.3561944901923439, 2.3561944901923439, 2.3561944901923439, 2.3561944901923439, 2.3561944901923439, 2.3561944901923439,
          2.3561944901923439, 2.3561944901923439, 2.3561944901923439, 2.3561944901923439, 2.3561944901923439, 2.3561944901923439, 2.3561944901923439, 2.3561944901923439 },
      {3.1415926535897931, 3.1415926535897931, 3.1415926535897931, 3.1415926535897931, 3.1415926535897931, 3.1415926535897931, 3.1415926535897931, 3.1415926535897931, 3.1415926535897931,
          3.1415926535897931, 3.1415926535897931, 3.1415926535897931, 3.1415926535897931, 3.1415926535897931, 3.1415926535897931, 3.1415926535897931, 3.1415926535897931 },
      {3.9269908169872423, 3.9269908169872423, 3.9269908169872423, 3.9269908169872423, 3.9269908169872423, 3.9269908169872423, 3.9269908169872423, 3.9269908169872423, 3.9269908169872423,
          3.9269908169872423, 3.9269908169872423, 3.9269908169872423, 3.9269908169872423, 3.9269908169872423, 3.9269908169872423, 3.9269908169872423, 3.9269908169872423 },
      {4.7123889803846897, 4.7123889803846897, 4.7123889803846897, 4.7123889803846897, 4.7123889803846897, 4.7123889803846897, 4.7123889803846897, 4.7123889803846897, 4.7123889803846897,
          4.7123889803846897, 4.7123889803846897, 4.7123889803846897, 4.7123889803846897, 4.7123889803846897, 4.7123889803846897, 4.7123889803846897, 4.7123889803846897 },
      {5.4977871437821371, 5.4977871437821371, 5.4977871437821371, 5.4977871437821371, 5.4977871437821371, 5.4977871437821371, 5.4977871437821371, 5.4977871437821371, 5.4977871437821371,
          5.4977871437821371, 5.4977871437821371, 5.4977871437821371, 5.4977871437821371, 5.4977871437821371, 5.4977871437821371, 5.4977871437821371, 5.4977871437821371 },
      {6.2831853071795862, 6.2831853071795862, 6.2831853071795862, 6.2831853071795862, 6.2831853071795862, 6.2831853071795862, 6.2831853071795862, 6.2831853071795862, 6.2831853071795862,
          6.2831853071795862, 6.2831853071795862, 6.2831853071795862, 6.2831853071795862, 6.2831853071795862, 6.2831853071795862, 6.2831853071795862, 6.2831853071795862 } };

  public static double[][] answerReal = {
      {-1.4908854775710425, -1.4914479663907891, -1.4937585392996204, -1.4984480988918887, -1.5061797498230647, -1.5174859568645749, -1.5325085385158854, -1.5507177857033474, 1.5707963267948966,
          1.5507177857033474, 1.5325085385158854, 1.5174859568645749, 1.5061797498230647, 1.4984480988918887, 1.4937585392996204, 1.4914479663907891, 1.4908854775710425 },
      {-1.4803433009149694, -1.4793541988638821, -1.4801785026722896, -1.4837305410478565, -1.4911202912188779, -1.5034555690582190, -1.5213949309009192, -1.5445024951150228, 1.5707963267948966,
          1.5445024951150228, 1.5213949309009192, 1.5034555690582190, 1.4911202912188779, 1.4837305410478565, 1.4801785026722896, 1.4793541988638821, 1.4803433009149694 },
      {-1.4687016319532396, -1.4654878817787007, -1.4639076252207759, -1.4651824072162432, -1.4710478763661157, -1.4836352430588968, -1.5048306551359127, -1.5348695745445793, 1.5707963267948966,
          1.5348695745445793, 1.5048306551359127, 1.4836352430588968, 1.4710478763661157, 1.4651824072162432, 1.4639076252207759, 1.4654878817787007, 1.4687016319532396 },
      {-1.4562702754222376, -1.4500598411766028, -1.4448721677098597, -1.4421236802937325, -1.4442379339106339, -1.4549454938360296, -1.4788384268678048, -1.5187578427902970, 1.5707963267948966,
          1.5187578427902970, 1.4788384268678048, 1.4549454938360296, 1.4442379339106339, 1.4421236802937325, 1.4448721677098597, 1.4500598411766028, 1.4562702754222376 },
      {-1.4436521607833530, -1.4337122433532261, -1.4235649443362834, -1.4144356512204082, -1.4090382850237617, -1.4128817556794167, -1.4356331286908641, -1.4887492337198345, 1.5707963267948966,
          1.4887492337198345, 1.4356331286908641, 1.4128817556794164, 1.4090382850237617, 1.4144356512204082, 1.4235649443362834, 1.4337122433532261, 1.4436521607833530 },
      {-1.4317898118217780, -1.4176835038558198, -1.4014710244266069, -1.3834672887507851, -1.3653515698115759, -1.3525838108871340, -1.3603762352582205, -1.4232730410763976, 1.5707963267948966,
          1.4232730410763976, 1.3603762352582205, 1.3525838108871340, 1.3653515698115759, 1.3834672887507851, 1.4014710244266069, 1.4176835038558198, 1.4317898118217780 },
      {-1.4219077302225243, -1.4038234913542778, -1.3813598290919711, -1.3531490958492238, -1.3177579803350350, -1.2751701375480511, -1.2339104269394181, -1.2478797747714210, 1.5707963267948966,
          1.2478797747714210, 1.2339104269394181, 1.2751701375480511, 1.3177579803350350, 1.3531490958492238, 1.3813598290919711, 1.4038234913542778, 1.4219077302225243 },
      {-1.4152967864609287, -1.3942869125008177, -1.3669610503310314, -1.3301433233732685, -1.2782983869977942, -1.2011614697311168, -1.0782801205859678, -0.8592456666147530, -0.00,
          0.8592456666147530, 1.0782801205859678, 1.2011614697311166, 1.2782983869977942, 1.3301433233732685, 1.3669610503310314, 1.3942869125008177, 1.4152967864609287 },
      {-1.4129651365067377, -1.3908719880144220, -1.3616916829711636, -1.3214479677837223, -1.2626272556789118, -1.1694228248157563, -1.0038848218538872, -0.6657737500283538, 0.00,
          0.6657737500283538, 1.0038848218538872, 1.1694228248157561, 1.2626272556789118, 1.3214479677837223, 1.3616916829711636, 1.3908719880144220, 1.4129651365067377 },
      {-1.4152967864609287, -1.3942869125008177, -1.3669610503310314, -1.3301433233732685, -1.2782983869977942, -1.2011614697311168, -1.0782801205859676, -0.8592456666147530, 0.00,
          0.8592456666147530, 1.0782801205859676, 1.2011614697311166, 1.2782983869977942, 1.3301433233732685, 1.3669610503310314, 1.3942869125008177, 1.4152967864609287 },
      {-1.4219077302225243, -1.4038234913542778, -1.3813598290919711, -1.3531490958492238, -1.3177579803350350, -1.2751701375480511, -1.2339104269394181, -1.2478797747714210, -1.5707963267948966,
          1.2478797747714210, 1.2339104269394181, 1.2751701375480511, 1.3177579803350350, 1.3531490958492238, 1.3813598290919711, 1.4038234913542778, 1.4219077302225243 },
      {-1.4317898118217780, -1.4176835038558198, -1.4014710244266069, -1.3834672887507851, -1.3653515698115759, -1.3525838108871340, -1.3603762352582205, -1.4232730410763974, -1.5707963267948966,
          1.4232730410763974, 1.3603762352582205, 1.3525838108871338, 1.3653515698115759, 1.3834672887507851, 1.4014710244266069, 1.4176835038558198, 1.4317898118217780 },
      {-1.4436521607833530, -1.4337122433532261, -1.4235649443362834, -1.4144356512204082, -1.4090382850237617, -1.4128817556794164, -1.4356331286908641, -1.4887492337198345, -1.5707963267948966,
          1.4887492337198345, 1.4356331286908641, 1.4128817556794167, 1.4090382850237617, 1.4144356512204082, 1.4235649443362834, 1.4337122433532261, 1.4436521607833530 },
      {-1.4562702754222376, -1.4500598411766028, -1.4448721677098597, -1.4421236802937325, -1.4442379339106339, -1.4549454938360298, -1.4788384268678050, -1.5187578427902970, -1.5707963267948966,
          1.5187578427902970, 1.4788384268678050, 1.4549454938360298, 1.4442379339106339, 1.4421236802937325, 1.4448721677098597, 1.4500598411766028, 1.4562702754222376 },
      {-1.4687016319532396, -1.4654878817787007, -1.4639076252207759, -1.4651824072162432, -1.4710478763661157, -1.4836352430588968, -1.5048306551359127, -1.5348695745445793, -1.5707963267948966,
          1.5348695745445793, 1.5048306551359127, 1.4836352430588968, 1.4710478763661157, 1.4651824072162432, 1.4639076252207759, 1.4654878817787007, 1.4687016319532396 },
      {-1.4803433009149691, -1.4793541988638821, -1.4801785026722896, -1.4837305410478565, -1.4911202912188779, -1.5034555690582190, -1.5213949309009192, -1.5445024951150228, -1.5707963267948966,
          1.5445024951150228, 1.5213949309009192, 1.5034555690582190, 1.4911202912188779, 1.4837305410478565, 1.4801785026722896, 1.4793541988638821, 1.4803433009149691 },
      {-1.4908854775710425, -1.4914479663907891, -1.4937585392996204, -1.4984480988918889, -1.5061797498230647, -1.5174859568645749, -1.5325085385158854, -1.5507177857033474, -1.5707963267948966,
          1.5507177857033474, 1.5325085385158854, 1.5174859568645749, 1.5061797498230647, 1.4984480988918889, 1.4937585392996204, 1.4914479663907891, 1.4908854775710425 } };

  public static double[][] answerImag = {
      {-0.0792389884423060, -0.0898198124986345, -0.1016102878267710, -0.1143541121366413, -0.1274878457940760, -0.1400531756152298, -0.1507090734703985, -0.1579452166384639, -0.1605195575078855,
          -0.1579452166384639, -0.1507090734703985, -0.1400531756152299, -0.1274878457940760, -0.1143541121366412, -0.1016102878267710, -0.0898198124986345, -0.0792389884423060 },
      {-0.0783938202486389, -0.0904392823647584, -0.1043831060834314, -0.1201182864764820, -0.1371185417831334, -0.1541979436996924, -0.1693662366843421, -0.1800551162732110, -0.1839380747586762,
          -0.1800551162732110, -0.1693662366843421, -0.1541979436996924, -0.1371185417831334, -0.1201182864764820, -0.1043831060834314, -0.0904392823647584, -0.0783938202486389 },
      {-0.0757499418504590, -0.0891257880152329, -0.1052963791336596, -0.1245056725459716, -0.1465258941625107, -0.1701382275763886, -0.1925302292920761, -0.2092162719267709, -0.2154808610586581,
          -0.2092162719267709, -0.1925302292920761, -0.1701382275763887, -0.1465258941625107, -0.1245056725459716, -0.1052963791336596, -0.0891257880152329, -0.0757499418504590 },
      {-0.0707185101995184, -0.0849947533619487, -0.1030988585630864, -0.1259217546514900, -0.1540646436709128, -0.1869735200364115, -0.2213041428778356, -0.2492683817619871, -0.2603767746936848,
          -0.2492683817619871, -0.2213041428778356, -0.1869735200364115, -0.1540646436709128, -0.1259217546514901, -0.1030988585630864, -0.0849947533619487, -0.0707185101995184 },
      {-0.0627245221484599, -0.0770507560891022, -0.0961482691673302, -0.1218499639562531, -0.1563886887812963, -0.2015656991765792, -0.2557474594289725, -0.3070510573335478, -0.3297653149566991,
          -0.3070510573335478, -0.2557474594289725, -0.2015656991765793, -0.1563886887812963, -0.1218499639562531, -0.0961482691673302, -0.0770507560891022, -0.0627245221484599 },
      {-0.0513681236984326, -0.0644206268603938, -0.0826763946159908, -0.1089227388254285, -0.1476299665718524, -0.2055152345819229, -0.2898811378755249, -0.3940877600081344, -0.4530625656623109,
          -0.3940877600081344, -0.2898811378755249, -0.2055152345819230, -0.1476299665718524, -0.1089227388254285, -0.0826763946159908, -0.0644206268603938, -0.0513681236984326 },
      {-0.0366416878453277, -0.0467565773226886, -0.0614904865745057, -0.0839406295744515, -0.1200311397803179, -0.1817700415705530, -0.2946214403408572, -0.5091787541466822, -0.7524692671419272,
          -0.5091787541466822, -0.2946214403408572, -0.1817700415705530, -0.1200311397803179, -0.0839406295744515, -0.0614904865745057, -0.0467565773226886, -0.0366416878453277 },
      {-0.0191209604828426, -0.0246851169125376, -0.0330153253759203, -0.0462278324918961, -0.0688071131935815, -0.1113682606709972, -0.2027225562352350, -0.4368271286232356, -1.0593061708232432,
          -0.4368271286232356, -0.2027225562352350, -0.1113682606709973, -0.0688071131935815, -0.0462278324918961, -0.0330153253759203, -0.0246851169125376, -0.0191209604828426 },
      {0.0000000000000000, 0.0000000000000000, 0.0000000000000000, -0.0000000000000001, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000,
          0.0000000000000000, 0.0000000000000000, -0.0000000000000001, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000 },
      {0.0191209604828426, 0.0246851169125376, 0.0330153253759202, 0.0462278324918961, 0.0688071131935814, 0.1113682606709971, 0.2027225562352351, 0.4368271286232355, 1.0593061708232430,
          0.4368271286232355, 0.2027225562352351, 0.1113682606709972, 0.0688071131935814, 0.0462278324918961, 0.0330153253759202, 0.0246851169125376, 0.0191209604828426 },
      {0.0366416878453275, 0.0467565773226886, 0.0614904865745057, 0.0839406295744515, 0.1200311397803181, 0.1817700415705530, 0.2946214403408572, 0.5091787541466822, 0.7524692671419272,
          0.5091787541466822, 0.2946214403408572, 0.1817700415705531, 0.1200311397803181, 0.0839406295744515, 0.0614904865745057, 0.0467565773226886, 0.0366416878453275 },
      {0.0513681236984325, 0.0644206268603938, 0.0826763946159909, 0.1089227388254285, 0.1476299665718523, 0.2055152345819230, 0.2898811378755249, 0.3940877600081347, 0.4530625656623111,
          0.3940877600081347, 0.2898811378755249, 0.2055152345819230, 0.1476299665718523, 0.1089227388254284, 0.0826763946159909, 0.0644206268603938, 0.0513681236984325 },
      {0.0627245221484599, 0.0770507560891023, 0.0961482691673300, 0.1218499639562531, 0.1563886887812962, 0.2015656991765792, 0.2557474594289726, 0.3070510573335478, 0.3297653149566991,
          0.3070510573335478, 0.2557474594289726, 0.2015656991765793, 0.1563886887812962, 0.1218499639562531, 0.0961482691673300, 0.0770507560891022, 0.0627245221484599 },
      {0.0707185101995184, 0.0849947533619489, 0.1030988585630863, 0.1259217546514901, 0.1540646436709127, 0.1869735200364115, 0.2213041428778355, 0.2492683817619870, 0.2603767746936847,
          0.2492683817619870, 0.2213041428778355, 0.1869735200364116, 0.1540646436709127, 0.1259217546514901, 0.1030988585630863, 0.0849947533619487, 0.0707185101995184 },
      {0.0757499418504590, 0.0891257880152328, 0.1052963791336595, 0.1245056725459717, 0.1465258941625107, 0.1701382275763886, 0.1925302292920761, 0.2092162719267709, 0.2154808610586581,
          0.2092162719267709, 0.1925302292920761, 0.1701382275763886, 0.1465258941625107, 0.1245056725459717, 0.1052963791336595, 0.0891257880152328, 0.0757499418504590 },
      {0.0783938202486389, 0.0904392823647584, 0.1043831060834315, 0.1201182864764821, 0.1371185417831334, 0.1541979436996924, 0.1693662366843421, 0.1800551162732111, 0.1839380747586763,
          0.1800551162732111, 0.1693662366843421, 0.1541979436996924, 0.1371185417831334, 0.1201182864764821, 0.1043831060834315, 0.0904392823647584, 0.0783938202486389 },
      {0.0792389884423061, 0.0898198124986345, 0.1016102878267710, 0.1143541121366413, 0.1274878457940760, 0.1400531756152298, 0.1507090734703986, 0.1579452166384639, 0.1605195575078854,
          0.1579452166384639, 0.1507090734703986, 0.1400531756152298, 0.1274878457940760, 0.1143541121366413, 0.1016102878267710, 0.0898198124986345, 0.0792389884423061 } };

  @Test
  public void correctnessTest() {
    OGComplexMatrix c = new OGComplexMatrix(realP, imagP);
    ComplexType ans, tabans;
    final int rows = c.getNumberOfRows();
    final int cols = c.getNumberOfColumns();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        ans = new ComplexType(ZATAN.zatan(new double[] {c.getEntry(i, j).getReal(), c.getEntry(i, j).getImag() }));
        tabans = new ComplexType(answerReal[i][j], answerImag[i][j]);

        // try seeing if they are the same, if they aren't then try again seeing if they are out by pi

        try {
          assertTrue(Math.abs(ans.getReal() - tabans.getReal()) < 100 * D1mach.four());
        } catch (AssertionError e) {
          assertTrue(MathsConstants.pi - (ans.getReal() > tabans.getReal() ? ans.getReal() - tabans.getReal() : tabans.getReal() - ans.getReal()) < 100 * D1mach.four());
        }

        try {
          assertTrue(Math.abs(ans.getImag() - tabans.getImag()) < 100 * D1mach.four());
        } catch (AssertionError e) {
          assertTrue(MathsConstants.pi - (ans.getImag() > tabans.getImag() ? ans.getImag() - tabans.getImag() : tabans.getImag() - ans.getImag()) < 100 * D1mach.four());
        }
      }
    }
  }

  @Test(expectedExceptions = MathsExceptionIllegalArgument.class)
  public void argIsPlusI() {
    ZATAN.zatan(new double[] {0, 1 });
  }

  @Test(expectedExceptions = MathsExceptionIllegalArgument.class)
  public void argIsMinusI() {
    ZATAN.zatan(new double[] {0, -1 });
  }

  @Test
  public void argIsPlusMinusIBranchCoverage() {
    ZATAN.zatan(new double[] {D1mach.four(), 1 });
  }
  
  
  @Test
  public void angleIsTiny() {
    ZATAN.zatan(new double[] {0, 1 + D1mach.four() });
  }

  @Test
  public void branchOne() {
    double[] tmp = ZATAN.zatan(new double[] {0.05, 0.05 });
    assertTrue(Math.abs(tmp[0] - 0.0500830824439626) < 100 * D1mach.four());
    assertTrue(Math.abs(tmp[1] - 0.0499164175629818) < 100 * D1mach.four());
  }

  @Test
  public void branchOneEscape1() {
    double[] tmp = ZATAN.zatan(new double[] {1e-9, 1e-9 });
    assertTrue(Math.abs(tmp[0] - 1e-9) < 100 * D1mach.four());
    assertTrue(Math.abs(tmp[1] - 1e-9) < 100 * D1mach.four());
  }
  
  @Test
  public void branchTwoEscape1() {
    double[] tmp = ZATAN.zatan(new double[] {1e16, 1e16 });
    assertTrue(Math.abs(tmp[0] - MathsConstants.halfpi) < 100 * D1mach.four());
    assertTrue(Math.abs(tmp[1] - 0) < 100 * D1mach.four());
  }
  
  @Test
  public void branchTwoEscape2() {
    double[] tmp = ZATAN.zatan(new double[] {-1e16, 1e16 });
    assertTrue(Math.abs(tmp[0] - -MathsConstants.halfpi) < 100 * D1mach.four());
    assertTrue(Math.abs(tmp[1] - 0) < 100 * D1mach.four());
  }
}
