/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.maths.lowlevelapi.slatec.fnlib;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.opengamma.maths.commonapi.numbers.ComplexType;
import com.opengamma.maths.highlevelapi.datatypes.primitive.OGComplexMatrix;
import com.opengamma.maths.lowlevelapi.linearalgebra.blas.referenceblas.D1mach;

/**
 * Tests complex square root
 */
@Test
public class ZSQRTTest {
  private static double[][] realP = { {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 },
      {-10.00, -9.00, -8.00, -7.00, -6.00, -5.00, -4.00, -3.00, -2.00, -1.00, 0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00, 10.00 } };

  private static double[][] imagP = {
      {-10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00, -10.00 },
      {-9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00, -9.00 },
      {-8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00, -8.00 },
      {-7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00, -7.00 },
      {-6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00, -6.00 },
      {-5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00, -5.00 },
      {-4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00, -4.00 },
      {-3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00, -3.00 },
      {-2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00, -2.00 },
      {-1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00 },
      {0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00 },
      {1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00 },
      {2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00 },
      {3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00 },
      {4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00, 4.00 },
      {5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00, 5.00 },
      {6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00, 6.00 },
      {7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00 },
      {8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00 },
      {9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00 },
      {10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00 } };

  private static double[][] answerReal = {
      {1.4391204994250741, 1.4922506570736884, 1.5502013538353168, 1.6134676345891947, 1.6825432817153028, 1.7578879212707146, 1.8398817372685952, 1.9287698811561929, 2.0246035447940876,
          2.1271901209248893, 2.2360679774997898, 2.3505186258697131, 2.4696193053976527, 2.5923258387894212, 2.7175659710731042, 2.8443224050289158, 2.9716917563645966, 3.0989155857923674,
          3.2253874553970796, 3.3506435237931318, 3.4743442276011565 },
      {1.3140821981660262, 1.3652695816866820, 1.4215474981146945, 1.4835353468979733, 1.5518785110942104, 1.6272108254597804, 1.7100961671491028, 1.8009487750218129, 1.8999400592246176,
          2.0069112010920431, 2.1213203435596424, 2.2422516738913831, 2.3684957734069201, 2.4986829511269670, 2.6314309606938298, 2.7654683275158840, 2.8997115224097700, 3.0332947640306389,
          3.1655642924123573, 3.2960523404034299, 3.4244433158597989 },
      {1.1845354521637792, 1.2332061017511013, 1.2871885058111652, 1.3472464163497799, 1.4142135623730949, 1.4889562001712144, 1.5723027555148466, 1.6649329934441104, 1.7672310617510267,
          1.8791298183332825, 2.0000000000000000, 2.1286448445312041, 2.2634278485557386, 2.4024990890026920, 2.5440392990281380, 2.6864457124662509, 2.8284271247461903, 2.9690188457413544,
          3.1075479480600747, 3.2435778531424444, 3.3768512311668171 },
      {1.0503703193954270, 1.0958453930622194, 1.1467662823641636, 1.2040545952347146, 1.2687679963832803, 1.3420740044875741, 1.4251767869809258, 1.5191729832155236, 1.6248245888834461,
          1.7422783663733927, 1.8708286933869707, 2.0088638345922645, 2.1540786765204882, 2.3038850997677716, 2.4558356773508430, 2.6079038773546301, 2.7585815609922508, 2.9068449336532960,
          3.0520604362245720, 3.1938812009052073, 3.3321581306815036 },
      {0.9115656283808097, 0.9530618622083163, 1.0000000000000000, 1.0534572742387058, 1.1147379454918027, 1.1853796176555962, 1.2671034983236331, 1.3616541287161306, 1.4704685172312866,
          1.5941710275717313, 1.7320508075688772, 1.8818558034953448, 2.0401660864175692, 2.2032026611843234, 2.3676045437243083, 2.5308348104831588, 2.6912154664982300, 2.8477661822288787,
          3.0000000000000000, 3.1477494997531150, 3.2910411566623261 },
      {0.7682251907803299, 0.8048695984403313, 0.8467529545435918, 0.8950768869328005, 0.9513804906310237, 1.0176118640880409, 1.0961578895015189, 1.1897377641407580, 1.3009928530039094,
          1.4316108957382214, 1.5811388300841898, 1.7462845577958914, 1.9216093264675971, 2.1013033925215678, 2.2806933416652981, 2.4567323635131153, 2.6277604224802014, 2.7930561457874981,
          2.9524550066052320, 3.1060932166458719, 3.2542541301732220 },
      {0.6206164734636875, 0.6514820802585842, 0.6871214994450249, 0.7287858904707711, 0.7781717519057019, 0.8375930507808814, 0.9101797211244547, 1.0000000000000000, 1.1117859405028423,
          1.2496210676876531, 1.4142135623730951, 1.6004851804402409, 1.7989074399478673, 2.0000000000000000, 2.1973682269356201, 2.3877944046161983, 2.5701267041653781, 2.7442902313985078,
          2.9106933804507098, 3.0699232728030927, 3.2226021794715067 },
      {0.4692049173391888, 0.4933725673895631, 0.5215379877427584, 0.5548752588933427, 0.5950646740058466, 0.6445742373246469, 0.7071067811865476, 0.7882387605032136, 0.8959774761298381,
          1.0397782600555705, 1.2247448713915889, 1.4426152744526830, 1.6741492280355401, 1.9029767059950162, 2.1213203435596424, 2.3271175190399496, 2.5207344100975186, 2.7033102953475310,
          2.8761088075138543, 3.0402987501646233, 3.1968974419670202 },
      {0.3146736620576702, 0.3313189228620117, 0.3508641127525877, 0.3742391543388521, 0.4028370143971123, 0.4388421169022545, 0.4858682717566457, 0.5502505227003375, 0.6435942529055826,
          0.7861513777574233, 1.0000000000000000, 1.2720196495140690, 1.5537739740300374, 1.8173540210239707, 2.0581710272714924, 2.2787238541708499, 2.4823935345082537, 2.6720881244151098,
          2.8501062481278940, 3.0182399223134073, 3.1778954535341128 },
      {0.1579171002787385, 0.1664108442040612, 0.1764337670324896, 0.1885043923433553, 0.2034238558997195, 0.2225078803017826, 0.2480983934023561, 0.2848487845931411, 0.3435607497225124,
          0.4550898605622273, 0.7071067811865476, 1.0986841134678100, 1.4553466902253549, 1.7553173018244279, 2.0153294551533829, 2.2471114250958699, 2.4579221438339149, 2.6524580874978474,
          2.8339246415791077, 3.0046118832669069, 3.1662182190367809 },
      {0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000,
          0.0000000000000000, 0.0000000000000000, 1.0000000000000000, 1.4142135623730951, 1.7320508075688772, 2.0000000000000000, 2.2360679774997898, 2.4494897427831779, 2.6457513110645907,
          2.8284271247461903, 3.0000000000000000, 3.1622776601683795 },
      {0.1579171002787385, 0.1664108442040612, 0.1764337670324896, 0.1885043923433553, 0.2034238558997195, 0.2225078803017826, 0.2480983934023561, 0.2848487845931411, 0.3435607497225124,
          0.4550898605622273, 0.7071067811865476, 1.0986841134678100, 1.4553466902253549, 1.7553173018244279, 2.0153294551533829, 2.2471114250958699, 2.4579221438339149, 2.6524580874978474,
          2.8339246415791077, 3.0046118832669069, 3.1662182190367809 },
      {0.3146736620576702, 0.3313189228620117, 0.3508641127525877, 0.3742391543388521, 0.4028370143971123, 0.4388421169022545, 0.4858682717566457, 0.5502505227003375, 0.6435942529055826,
          0.7861513777574233, 1.0000000000000000, 1.2720196495140690, 1.5537739740300374, 1.8173540210239707, 2.0581710272714924, 2.2787238541708499, 2.4823935345082537, 2.6720881244151098,
          2.8501062481278940, 3.0182399223134073, 3.1778954535341128 },
      {0.4692049173391888, 0.4933725673895631, 0.5215379877427584, 0.5548752588933427, 0.5950646740058466, 0.6445742373246469, 0.7071067811865476, 0.7882387605032136, 0.8959774761298381,
          1.0397782600555705, 1.2247448713915889, 1.4426152744526830, 1.6741492280355401, 1.9029767059950162, 2.1213203435596424, 2.3271175190399496, 2.5207344100975186, 2.7033102953475310,
          2.8761088075138543, 3.0402987501646233, 3.1968974419670202 },
      {0.6206164734636875, 0.6514820802585842, 0.6871214994450249, 0.7287858904707711, 0.7781717519057019, 0.8375930507808814, 0.9101797211244547, 1.0000000000000000, 1.1117859405028423,
          1.2496210676876531, 1.4142135623730951, 1.6004851804402409, 1.7989074399478673, 2.0000000000000000, 2.1973682269356201, 2.3877944046161983, 2.5701267041653781, 2.7442902313985078,
          2.9106933804507098, 3.0699232728030927, 3.2226021794715067 },
      {0.7682251907803299, 0.8048695984403313, 0.8467529545435918, 0.8950768869328005, 0.9513804906310237, 1.0176118640880409, 1.0961578895015189, 1.1897377641407580, 1.3009928530039094,
          1.4316108957382214, 1.5811388300841898, 1.7462845577958914, 1.9216093264675971, 2.1013033925215678, 2.2806933416652981, 2.4567323635131153, 2.6277604224802014, 2.7930561457874981,
          2.9524550066052320, 3.1060932166458719, 3.2542541301732220 },
      {0.9115656283808097, 0.9530618622083163, 1.0000000000000000, 1.0534572742387058, 1.1147379454918027, 1.1853796176555962, 1.2671034983236331, 1.3616541287161306, 1.4704685172312866,
          1.5941710275717313, 1.7320508075688772, 1.8818558034953448, 2.0401660864175692, 2.2032026611843234, 2.3676045437243083, 2.5308348104831588, 2.6912154664982300, 2.8477661822288787,
          3.0000000000000000, 3.1477494997531150, 3.2910411566623261 },
      {1.0503703193954270, 1.0958453930622194, 1.1467662823641636, 1.2040545952347146, 1.2687679963832803, 1.3420740044875741, 1.4251767869809258, 1.5191729832155236, 1.6248245888834461,
          1.7422783663733927, 1.8708286933869707, 2.0088638345922645, 2.1540786765204882, 2.3038850997677716, 2.4558356773508430, 2.6079038773546301, 2.7585815609922508, 2.9068449336532960,
          3.0520604362245720, 3.1938812009052073, 3.3321581306815036 },
      {1.1845354521637792, 1.2332061017511013, 1.2871885058111652, 1.3472464163497799, 1.4142135623730949, 1.4889562001712144, 1.5723027555148466, 1.6649329934441104, 1.7672310617510267,
          1.8791298183332825, 2.0000000000000000, 2.1286448445312041, 2.2634278485557386, 2.4024990890026920, 2.5440392990281380, 2.6864457124662509, 2.8284271247461903, 2.9690188457413544,
          3.1075479480600747, 3.2435778531424444, 3.3768512311668171 },
      {1.3140821981660262, 1.3652695816866820, 1.4215474981146945, 1.4835353468979733, 1.5518785110942104, 1.6272108254597804, 1.7100961671491028, 1.8009487750218129, 1.8999400592246176,
          2.0069112010920431, 2.1213203435596424, 2.2422516738913831, 2.3684957734069201, 2.4986829511269670, 2.6314309606938298, 2.7654683275158840, 2.8997115224097700, 3.0332947640306389,
          3.1655642924123573, 3.2960523404034299, 3.4244433158597989 },
      {1.4391204994250741, 1.4922506570736884, 1.5502013538353168, 1.6134676345891947, 1.6825432817153028, 1.7578879212707146, 1.8398817372685952, 1.9287698811561929, 2.0246035447940876,
          2.1271901209248893, 2.2360679774997898, 2.3505186258697131, 2.4696193053976527, 2.5923258387894212, 2.7175659710731042, 2.8443224050289158, 2.9716917563645966, 3.0989155857923674,
          3.2253874553970796, 3.3506435237931318, 3.4743442276011565 } };

  private static double[][] answerImag = {
      {-3.4743442276011565, -3.3506435237931318, -3.2253874553970796, -3.0989155857923674, -2.9716917563645966, -2.8443224050289158, -2.7175659710731042, -2.5923258387894212, -2.4696193053976527,
          -2.3505186258697131, -2.2360679774997898, -2.1271901209248893, -2.0246035447940876, -1.9287698811561929, -1.8398817372685952, -1.7578879212707146, -1.6825432817153028, -1.6134676345891947,
          -1.5502013538353168, -1.4922506570736884, -1.4391204994250741 },
      {-3.4244433158597989, -3.2960523404034299, -3.1655642924123573, -3.0332947640306389, -2.8997115224097700, -2.7654683275158840, -2.6314309606938298, -2.4986829511269670, -2.3684957734069201,
          -2.2422516738913831, -2.1213203435596424, -2.0069112010920431, -1.8999400592246176, -1.8009487750218129, -1.7100961671491028, -1.6272108254597804, -1.5518785110942104, -1.4835353468979733,
          -1.4215474981146945, -1.3652695816866820, -1.3140821981660262 },
      {-3.3768512311668171, -3.2435778531424444, -3.1075479480600747, -2.9690188457413544, -2.8284271247461903, -2.6864457124662509, -2.5440392990281380, -2.4024990890026920, -2.2634278485557386,
          -2.1286448445312041, -2.0000000000000000, -1.8791298183332825, -1.7672310617510267, -1.6649329934441104, -1.5723027555148466, -1.4889562001712144, -1.4142135623730949, -1.3472464163497799,
          -1.2871885058111652, -1.2332061017511013, -1.1845354521637792 },
      {-3.3321581306815036, -3.1938812009052073, -3.0520604362245720, -2.9068449336532960, -2.7585815609922508, -2.6079038773546301, -2.4558356773508430, -2.3038850997677716, -2.1540786765204882,
          -2.0088638345922645, -1.8708286933869707, -1.7422783663733927, -1.6248245888834461, -1.5191729832155236, -1.4251767869809258, -1.3420740044875741, -1.2687679963832803, -1.2040545952347146,
          -1.1467662823641636, -1.0958453930622194, -1.0503703193954270 },
      {-3.2910411566623261, -3.1477494997531150, -3.0000000000000000, -2.8477661822288787, -2.6912154664982300, -2.5308348104831588, -2.3676045437243083, -2.2032026611843234, -2.0401660864175692,
          -1.8818558034953448, -1.7320508075688772, -1.5941710275717313, -1.4704685172312866, -1.3616541287161306, -1.2671034983236331, -1.1853796176555962, -1.1147379454918027, -1.0534572742387058,
          -1.0000000000000000, -0.9530618622083163, -0.9115656283808097 },
      {-3.2542541301732220, -3.1060932166458719, -2.9524550066052320, -2.7930561457874981, -2.6277604224802014, -2.4567323635131153, -2.2806933416652981, -2.1013033925215678, -1.9216093264675971,
          -1.7462845577958914, -1.5811388300841898, -1.4316108957382214, -1.3009928530039094, -1.1897377641407580, -1.0961578895015189, -1.0176118640880409, -0.9513804906310237, -0.8950768869328005,
          -0.8467529545435918, -0.8048695984403313, -0.7682251907803299 },
      {-3.2226021794715067, -3.0699232728030927, -2.9106933804507098, -2.7442902313985078, -2.5701267041653781, -2.3877944046161983, -2.1973682269356201, -2.0000000000000000, -1.7989074399478673,
          -1.6004851804402409, -1.4142135623730951, -1.2496210676876531, -1.1117859405028423, -1.0000000000000000, -0.9101797211244547, -0.8375930507808814, -0.7781717519057019, -0.7287858904707711,
          -0.6871214994450249, -0.6514820802585842, -0.6206164734636875 },
      {-3.1968974419670202, -3.0402987501646233, -2.8761088075138543, -2.7033102953475310, -2.5207344100975186, -2.3271175190399496, -2.1213203435596424, -1.9029767059950162, -1.6741492280355401,
          -1.4426152744526830, -1.2247448713915889, -1.0397782600555705, -0.8959774761298381, -0.7882387605032136, -0.7071067811865476, -0.6445742373246469, -0.5950646740058466, -0.5548752588933427,
          -0.5215379877427584, -0.4933725673895631, -0.4692049173391888 },
      {-3.1778954535341128, -3.0182399223134073, -2.8501062481278940, -2.6720881244151098, -2.4823935345082537, -2.2787238541708499, -2.0581710272714924, -1.8173540210239707, -1.5537739740300374,
          -1.2720196495140690, -1.0000000000000000, -0.7861513777574233, -0.6435942529055826, -0.5502505227003375, -0.4858682717566457, -0.4388421169022545, -0.4028370143971123, -0.3742391543388521,
          -0.3508641127525877, -0.3313189228620117, -0.3146736620576702 },
      {-3.1662182190367809, -3.0046118832669069, -2.8339246415791077, -2.6524580874978474, -2.4579221438339149, -2.2471114250958699, -2.0153294551533829, -1.7553173018244279, -1.4553466902253549,
          -1.0986841134678100, -0.7071067811865476, -0.4550898605622273, -0.3435607497225124, -0.2848487845931411, -0.2480983934023561, -0.2225078803017826, -0.2034238558997195, -0.1885043923433553,
          -0.1764337670324896, -0.1664108442040612, -0.1579171002787385 },
      {3.1622776601683795, 3.0000000000000000, 2.8284271247461903, 2.6457513110645907, 2.4494897427831779, 2.2360679774997898, 2.0000000000000000, 1.7320508075688772, 1.4142135623730951,
          1.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000, 0.0000000000000000,
          0.0000000000000000, 0.0000000000000000, 0.0000000000000000 },
      {3.1662182190367809, 3.0046118832669069, 2.8339246415791077, 2.6524580874978474, 2.4579221438339149, 2.2471114250958699, 2.0153294551533829, 1.7553173018244279, 1.4553466902253549,
          1.0986841134678100, 0.7071067811865476, 0.4550898605622273, 0.3435607497225124, 0.2848487845931411, 0.2480983934023561, 0.2225078803017826, 0.2034238558997195, 0.1885043923433553,
          0.1764337670324896, 0.1664108442040612, 0.1579171002787385 },
      {3.1778954535341128, 3.0182399223134073, 2.8501062481278940, 2.6720881244151098, 2.4823935345082537, 2.2787238541708499, 2.0581710272714924, 1.8173540210239707, 1.5537739740300374,
          1.2720196495140690, 1.0000000000000000, 0.7861513777574233, 0.6435942529055826, 0.5502505227003375, 0.4858682717566457, 0.4388421169022545, 0.4028370143971123, 0.3742391543388521,
          0.3508641127525877, 0.3313189228620117, 0.3146736620576702 },
      {3.1968974419670202, 3.0402987501646233, 2.8761088075138543, 2.7033102953475310, 2.5207344100975186, 2.3271175190399496, 2.1213203435596424, 1.9029767059950162, 1.6741492280355401,
          1.4426152744526830, 1.2247448713915889, 1.0397782600555705, 0.8959774761298381, 0.7882387605032136, 0.7071067811865476, 0.6445742373246469, 0.5950646740058466, 0.5548752588933427,
          0.5215379877427584, 0.4933725673895631, 0.4692049173391888 },
      {3.2226021794715067, 3.0699232728030927, 2.9106933804507098, 2.7442902313985078, 2.5701267041653781, 2.3877944046161983, 2.1973682269356201, 2.0000000000000000, 1.7989074399478673,
          1.6004851804402409, 1.4142135623730951, 1.2496210676876531, 1.1117859405028423, 1.0000000000000000, 0.9101797211244547, 0.8375930507808814, 0.7781717519057019, 0.7287858904707711,
          0.6871214994450249, 0.6514820802585842, 0.6206164734636875 },
      {3.2542541301732220, 3.1060932166458719, 2.9524550066052320, 2.7930561457874981, 2.6277604224802014, 2.4567323635131153, 2.2806933416652981, 2.1013033925215678, 1.9216093264675971,
          1.7462845577958914, 1.5811388300841898, 1.4316108957382214, 1.3009928530039094, 1.1897377641407580, 1.0961578895015189, 1.0176118640880409, 0.9513804906310237, 0.8950768869328005,
          0.8467529545435918, 0.8048695984403313, 0.7682251907803299 },
      {3.2910411566623261, 3.1477494997531150, 3.0000000000000000, 2.8477661822288787, 2.6912154664982300, 2.5308348104831588, 2.3676045437243083, 2.2032026611843234, 2.0401660864175692,
          1.8818558034953448, 1.7320508075688772, 1.5941710275717313, 1.4704685172312866, 1.3616541287161306, 1.2671034983236331, 1.1853796176555962, 1.1147379454918027, 1.0534572742387058,
          1.0000000000000000, 0.9530618622083163, 0.9115656283808097 },
      {3.3321581306815036, 3.1938812009052073, 3.0520604362245720, 2.9068449336532960, 2.7585815609922508, 2.6079038773546301, 2.4558356773508430, 2.3038850997677716, 2.1540786765204882,
          2.0088638345922645, 1.8708286933869707, 1.7422783663733927, 1.6248245888834461, 1.5191729832155236, 1.4251767869809258, 1.3420740044875741, 1.2687679963832803, 1.2040545952347146,
          1.1467662823641636, 1.0958453930622194, 1.0503703193954270 },
      {3.3768512311668171, 3.2435778531424444, 3.1075479480600747, 2.9690188457413544, 2.8284271247461903, 2.6864457124662509, 2.5440392990281380, 2.4024990890026920, 2.2634278485557386,
          2.1286448445312041, 2.0000000000000000, 1.8791298183332825, 1.7672310617510267, 1.6649329934441104, 1.5723027555148466, 1.4889562001712144, 1.4142135623730949, 1.3472464163497799,
          1.2871885058111652, 1.2332061017511013, 1.1845354521637792 },
      {3.4244433158597989, 3.2960523404034299, 3.1655642924123573, 3.0332947640306389, 2.8997115224097700, 2.7654683275158840, 2.6314309606938298, 2.4986829511269670, 2.3684957734069201,
          2.2422516738913831, 2.1213203435596424, 2.0069112010920431, 1.8999400592246176, 1.8009487750218129, 1.7100961671491028, 1.6272108254597804, 1.5518785110942104, 1.4835353468979733,
          1.4215474981146945, 1.3652695816866820, 1.3140821981660262 },
      {3.4743442276011565, 3.3506435237931318, 3.2253874553970796, 3.0989155857923674, 2.9716917563645966, 2.8443224050289158, 2.7175659710731042, 2.5923258387894212, 2.4696193053976527,
          2.3505186258697131, 2.2360679774997898, 2.1271901209248893, 2.0246035447940876, 1.9287698811561929, 1.8398817372685952, 1.7578879212707146, 1.6825432817153028, 1.6134676345891947,
          1.5502013538353168, 1.4922506570736884, 1.4391204994250741 } };

  @Test
  public void correctnessTest() {
    OGComplexMatrix c = new OGComplexMatrix(realP, imagP);
    ComplexType ans, tabans;
    final int rows = c.getNumberOfRows();
    final int cols = c.getNumberOfColumns();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        ans = new ComplexType(ZSQRT.zsqrt(new double[] {c.getEntry(i, j).getReal(), c.getEntry(i, j).getImag() }));
        tabans = new ComplexType(answerReal[i][j], answerImag[i][j]);
        assertTrue(Math.abs(ans.getReal() - tabans.getReal()) < 10 * D1mach.four());
        assertTrue(Math.abs(ans.getImag() - tabans.getImag()) < 10 * D1mach.four());
      }
    }
  }
}
