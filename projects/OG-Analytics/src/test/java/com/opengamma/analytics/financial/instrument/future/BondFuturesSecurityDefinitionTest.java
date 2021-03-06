/**
 * Copyright (C) 2011 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.analytics.financial.instrument.future;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.threeten.bp.Period;
import org.threeten.bp.ZonedDateTime;

import com.opengamma.analytics.financial.instrument.bond.BondFixedSecurityDefinition;
import com.opengamma.analytics.financial.interestrate.bond.definition.BondFixedSecurity;
import com.opengamma.analytics.financial.interestrate.future.derivative.BondFuturesSecurity;
import com.opengamma.analytics.financial.schedule.ScheduleCalculator;
import com.opengamma.financial.convention.businessday.BusinessDayConvention;
import com.opengamma.financial.convention.businessday.BusinessDayConventionFactory;
import com.opengamma.financial.convention.calendar.Calendar;
import com.opengamma.financial.convention.calendar.MondayToFridayCalendar;
import com.opengamma.financial.convention.daycount.DayCount;
import com.opengamma.financial.convention.daycount.DayCountFactory;
import com.opengamma.financial.convention.yield.YieldConvention;
import com.opengamma.financial.convention.yield.YieldConventionFactory;
import com.opengamma.util.money.Currency;
import com.opengamma.util.time.DateUtils;

/**
 * Tests related to bond futures security Definition construction.
 */
public class BondFuturesSecurityDefinitionTest {

  // 5-Year U.S. Treasury Note Futures: FVU1
  private static final Currency CUR = Currency.USD;
  private static final Period PAYMENT_TENOR = Period.ofMonths(6);
  private static final Calendar CALENDAR = new MondayToFridayCalendar("A");
  private static final DayCount DAY_COUNT = DayCountFactory.INSTANCE.getDayCount("Actual/Actual ISDA");
  private static final BusinessDayConvention BUSINESS_DAY = BusinessDayConventionFactory.INSTANCE.getBusinessDayConvention("Following");
  private static final boolean IS_EOM = false;
  private static final int SETTLEMENT_DAYS = 1;
  private static final YieldConvention YIELD_CONVENTION = YieldConventionFactory.INSTANCE.getYieldConvention("STREET CONVENTION");
  private static final int NB_BOND = 7;
  private static final Period[] BOND_TENOR = new Period[] {Period.ofYears(5), Period.ofYears(5), Period.ofYears(5), Period.ofYears(8), Period.ofYears(5), Period.ofYears(5), Period.ofYears(5) };
  private static final ZonedDateTime[] START_ACCRUAL_DATE = new ZonedDateTime[] {DateUtils.getUTCDate(2010, 11, 30), DateUtils.getUTCDate(2010, 12, 31), DateUtils.getUTCDate(2011, 1, 31),
      DateUtils.getUTCDate(2008, 2, 29), DateUtils.getUTCDate(2011, 3, 31), DateUtils.getUTCDate(2011, 4, 30), DateUtils.getUTCDate(2011, 5, 31) };
  private static final double[] RATE = new double[] {0.01375, 0.02125, 0.0200, 0.02125, 0.0225, 0.0200, 0.0175 };
  private static final double[] CONVERSION_FACTOR = new double[] {.8317, .8565, .8493, .8516, .8540, .8417, .8292 };
  private static final String US_GOVT = "US GOVT";
  private static final ZonedDateTime[] MATURITY_DATE = new ZonedDateTime[NB_BOND];
  private static final BondFixedSecurityDefinition[] BASKET_DEFINITION = new BondFixedSecurityDefinition[NB_BOND];
  static {
    for (int loopbasket = 0; loopbasket < NB_BOND; loopbasket++) {
      MATURITY_DATE[loopbasket] = START_ACCRUAL_DATE[loopbasket].plus(BOND_TENOR[loopbasket]);
      BASKET_DEFINITION[loopbasket] = BondFixedSecurityDefinition.from(CUR, MATURITY_DATE[loopbasket], START_ACCRUAL_DATE[loopbasket], PAYMENT_TENOR, RATE[loopbasket], SETTLEMENT_DAYS, CALENDAR,
          DAY_COUNT, BUSINESS_DAY, YIELD_CONVENTION, IS_EOM, US_GOVT);
    }
  }
  private static final ZonedDateTime LAST_TRADING_DATE = DateUtils.getUTCDate(2011, 9, 21);
  private static final ZonedDateTime FIRST_NOTICE_DATE = DateUtils.getUTCDate(2011, 8, 31);
  private static final ZonedDateTime LAST_NOTICE_DATE = DateUtils.getUTCDate(2011, 9, 29);
  private static final double NOTIONAL = 100000;
  private static final BondFuturesSecurityDefinition FUTURE_DEFINITION = new BondFuturesSecurityDefinition(LAST_TRADING_DATE, FIRST_NOTICE_DATE, LAST_NOTICE_DATE, NOTIONAL, BASKET_DEFINITION,
      CONVERSION_FACTOR);

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testNullLastTrading() {
    new BondFuturesSecurityDefinition(null, FIRST_NOTICE_DATE, LAST_NOTICE_DATE, NOTIONAL, BASKET_DEFINITION, CONVERSION_FACTOR);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testNullFirstNotice() {
    new BondFuturesSecurityDefinition(LAST_TRADING_DATE, null, LAST_NOTICE_DATE, NOTIONAL, BASKET_DEFINITION, CONVERSION_FACTOR);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testNullLastNotice() {
    new BondFuturesSecurityDefinition(LAST_TRADING_DATE, FIRST_NOTICE_DATE, null, NOTIONAL, BASKET_DEFINITION, CONVERSION_FACTOR);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testNullBasket() {
    new BondFuturesSecurityDefinition(LAST_TRADING_DATE, FIRST_NOTICE_DATE, LAST_NOTICE_DATE, NOTIONAL, null, CONVERSION_FACTOR);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testNullConversion() {
    new BondFuturesSecurityDefinition(LAST_TRADING_DATE, FIRST_NOTICE_DATE, LAST_NOTICE_DATE, NOTIONAL, BASKET_DEFINITION, null);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void zeroBasket() {
    new BondFuturesSecurityDefinition(LAST_TRADING_DATE, FIRST_NOTICE_DATE, LAST_NOTICE_DATE, NOTIONAL, new BondFixedSecurityDefinition[0], CONVERSION_FACTOR);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void sizeConversionFactor() {
    final double[] incorrectConversionFactor = new double[NB_BOND - 1];
    new BondFuturesSecurityDefinition(LAST_TRADING_DATE, FIRST_NOTICE_DATE, LAST_NOTICE_DATE, NOTIONAL, BASKET_DEFINITION, incorrectConversionFactor);
  }

  @Test
  /**
   * Tests the getter methods.
   */
  public void getter() {
    assertEquals("Bond future security definition: last trading date", LAST_TRADING_DATE, FUTURE_DEFINITION.getTradingLastDate());
    assertEquals("Bond future security definition: first notice date", FIRST_NOTICE_DATE, FUTURE_DEFINITION.getNoticeFirstDate());
    assertEquals("Bond future security definition: last notice date", LAST_NOTICE_DATE, FUTURE_DEFINITION.getNoticeLastDate());
    assertEquals("Bond future security definition: first delivery date", ScheduleCalculator.getAdjustedDate(FIRST_NOTICE_DATE, SETTLEMENT_DAYS, CALENDAR), FUTURE_DEFINITION.getDeliveryFirstDate());
    assertEquals("Bond future security definition: last delivery date", ScheduleCalculator.getAdjustedDate(LAST_NOTICE_DATE, SETTLEMENT_DAYS, CALENDAR), FUTURE_DEFINITION.getDeliveryLastDate());
    assertEquals("Bond future security definition: notional", NOTIONAL, FUTURE_DEFINITION.getNotional());
    assertEquals("Bond future security definition: delivery basket", BASKET_DEFINITION, FUTURE_DEFINITION.getDeliveryBasket());
    assertEquals("Bond future security definition: conversion factors", CONVERSION_FACTOR, FUTURE_DEFINITION.getConversionFactor());
    assertEquals("Bond future security definition: settlement days", SETTLEMENT_DAYS, FUTURE_DEFINITION.getSettlementDays());
  }

  @Test
  /**
   * Tests the equal and hashCode methods.
   */
  public void equalHash() {
    assertTrue(FUTURE_DEFINITION.equals(FUTURE_DEFINITION));
    final BondFuturesSecurityDefinition other = new BondFuturesSecurityDefinition(LAST_TRADING_DATE, FIRST_NOTICE_DATE, LAST_NOTICE_DATE, NOTIONAL, BASKET_DEFINITION, CONVERSION_FACTOR);
    assertTrue(FUTURE_DEFINITION.equals(other));
    assertTrue(FUTURE_DEFINITION.hashCode() == other.hashCode());
    BondFuturesSecurityDefinition modifiedFuture;
    modifiedFuture = new BondFuturesSecurityDefinition(FIRST_NOTICE_DATE, FIRST_NOTICE_DATE, LAST_NOTICE_DATE, NOTIONAL, BASKET_DEFINITION, CONVERSION_FACTOR);
    assertFalse(FUTURE_DEFINITION.equals(modifiedFuture));
    modifiedFuture = new BondFuturesSecurityDefinition(LAST_TRADING_DATE, LAST_TRADING_DATE, LAST_NOTICE_DATE, NOTIONAL, BASKET_DEFINITION, CONVERSION_FACTOR);
    assertFalse(FUTURE_DEFINITION.equals(modifiedFuture));
    modifiedFuture = new BondFuturesSecurityDefinition(LAST_TRADING_DATE, FIRST_NOTICE_DATE, FIRST_NOTICE_DATE, NOTIONAL, BASKET_DEFINITION, CONVERSION_FACTOR);
    assertFalse(FUTURE_DEFINITION.equals(modifiedFuture));
    modifiedFuture = new BondFuturesSecurityDefinition(LAST_TRADING_DATE, FIRST_NOTICE_DATE, LAST_NOTICE_DATE, NOTIONAL + 100000, BASKET_DEFINITION, CONVERSION_FACTOR);
    assertFalse(FUTURE_DEFINITION.equals(modifiedFuture));
    final double[] otherConversionFactor = new double[] {.9000, .8565, .8493, .8516, .8540, .8417, .8292 };
    modifiedFuture = new BondFuturesSecurityDefinition(LAST_TRADING_DATE, FIRST_NOTICE_DATE, LAST_NOTICE_DATE, NOTIONAL, BASKET_DEFINITION, otherConversionFactor);
    assertFalse(FUTURE_DEFINITION.equals(modifiedFuture));
    final BondFixedSecurityDefinition[] otherBasket = new BondFixedSecurityDefinition[NB_BOND];
    for (int loopbasket = 0; loopbasket < NB_BOND; loopbasket++) {
      otherBasket[loopbasket] = BondFixedSecurityDefinition.from(CUR, MATURITY_DATE[loopbasket], START_ACCRUAL_DATE[loopbasket], PAYMENT_TENOR, 2 * RATE[loopbasket], SETTLEMENT_DAYS, CALENDAR,
          DAY_COUNT, BUSINESS_DAY, YIELD_CONVENTION, IS_EOM, US_GOVT);
    }
    modifiedFuture = new BondFuturesSecurityDefinition(LAST_TRADING_DATE, FIRST_NOTICE_DATE, LAST_NOTICE_DATE, NOTIONAL, otherBasket, CONVERSION_FACTOR);
    assertFalse(FUTURE_DEFINITION.equals(modifiedFuture));
    assertFalse(FUTURE_DEFINITION.equals(LAST_TRADING_DATE));
    assertFalse(FUTURE_DEFINITION.equals(null));
  }

  @SuppressWarnings("deprecation")
  @Test
  /**
   * Tests the toDerivative method.
   */
  public void toDerivativeDeprecated() {
    final ZonedDateTime firstDeliveryDate = ScheduleCalculator.getAdjustedDate(FIRST_NOTICE_DATE, SETTLEMENT_DAYS, CALENDAR);
    final ZonedDateTime lastDeliveryDate = ScheduleCalculator.getAdjustedDate(LAST_NOTICE_DATE, SETTLEMENT_DAYS, CALENDAR);
    final ZonedDateTime referenceDate = DateUtils.getUTCDate(2011, 6, 17);
    final DayCount actAct = DayCountFactory.INSTANCE.getDayCount("Actual/Actual ISDA");
    final double lastTradingTime = actAct.getDayCountFraction(referenceDate, LAST_TRADING_DATE);
    final double firstNoticeTime = actAct.getDayCountFraction(referenceDate, FIRST_NOTICE_DATE);
    final double lastNoticeTime = actAct.getDayCountFraction(referenceDate, LAST_NOTICE_DATE);
    final double firstDeliveryTime = actAct.getDayCountFraction(referenceDate, firstDeliveryDate);
    final double lastDeliveryTime = actAct.getDayCountFraction(referenceDate, lastDeliveryDate);
    final String creditCruveName = "Credit";
    final String repoCurveName = "Repo";
    final String[] curvesName = {creditCruveName, repoCurveName };
    final BondFixedSecurity[] basket = new BondFixedSecurity[NB_BOND];
    for (int loopbasket = 0; loopbasket < NB_BOND; loopbasket++) {
      basket[loopbasket] = BASKET_DEFINITION[loopbasket].toDerivative(referenceDate, lastDeliveryDate, curvesName);
    }
    final BondFuturesSecurity futureConverted = FUTURE_DEFINITION.toDerivative(referenceDate, curvesName);
    final BondFuturesSecurity futureExpected = new BondFuturesSecurity(lastTradingTime, firstNoticeTime, lastNoticeTime, firstDeliveryTime, lastDeliveryTime, NOTIONAL, basket, CONVERSION_FACTOR);
    assertEquals("Bond future security definition: future conversion", futureExpected, futureConverted);
  }

  @Test
  /**
   * Tests the toDerivative method.
   */
  public void toDerivative() {
    final ZonedDateTime firstDeliveryDate = ScheduleCalculator.getAdjustedDate(FIRST_NOTICE_DATE, SETTLEMENT_DAYS, CALENDAR);
    final ZonedDateTime lastDeliveryDate = ScheduleCalculator.getAdjustedDate(LAST_NOTICE_DATE, SETTLEMENT_DAYS, CALENDAR);
    final ZonedDateTime referenceDate = DateUtils.getUTCDate(2011, 6, 17);
    final DayCount actAct = DayCountFactory.INSTANCE.getDayCount("Actual/Actual ISDA");
    final double lastTradingTime = actAct.getDayCountFraction(referenceDate, LAST_TRADING_DATE);
    final double firstNoticeTime = actAct.getDayCountFraction(referenceDate, FIRST_NOTICE_DATE);
    final double lastNoticeTime = actAct.getDayCountFraction(referenceDate, LAST_NOTICE_DATE);
    final double firstDeliveryTime = actAct.getDayCountFraction(referenceDate, firstDeliveryDate);
    final double lastDeliveryTime = actAct.getDayCountFraction(referenceDate, lastDeliveryDate);
    final BondFixedSecurity[] basket = new BondFixedSecurity[NB_BOND];
    for (int loopbasket = 0; loopbasket < NB_BOND; loopbasket++) {
      basket[loopbasket] = BASKET_DEFINITION[loopbasket].toDerivative(referenceDate, lastDeliveryDate);
    }
    final BondFuturesSecurity futureConverted = FUTURE_DEFINITION.toDerivative(referenceDate);
    final BondFuturesSecurity futureExpected = new BondFuturesSecurity(lastTradingTime, firstNoticeTime, lastNoticeTime, firstDeliveryTime, lastDeliveryTime, NOTIONAL, basket, CONVERSION_FACTOR);
    assertEquals("Bond future security definition: future conversion", futureExpected, futureConverted);
  }
}
