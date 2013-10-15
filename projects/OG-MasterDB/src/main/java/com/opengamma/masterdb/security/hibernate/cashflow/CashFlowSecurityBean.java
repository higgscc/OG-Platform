/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */

package com.opengamma.masterdb.security.hibernate.cashflow;

import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.masterdb.security.hibernate.CurrencyBean;
import com.opengamma.masterdb.security.hibernate.SecurityBean;
import com.opengamma.masterdb.security.hibernate.ZonedDateTimeBean;

/**
 * A Hibernate bean representation of {@link com.opengamma.financial.security.cashflow.CashFlowSecurity}.
 */
@BeanDefinition
public class CashFlowSecurityBean extends SecurityBean {
  @PropertyDefinition
  private CurrencyBean _currency;
  @PropertyDefinition
  private ZonedDateTimeBean _settlement;
  @PropertyDefinition
  private double _amount;

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof CashFlowSecurityBean)) {
      return false;
    }
    CashFlowSecurityBean cashflow = (CashFlowSecurityBean) other;
    return new EqualsBuilder()
      .append(getId(), cashflow.getId())
      .append(getCurrency(), cashflow.getCurrency())
      .append(getSettlement(), cashflow.getSettlement())
      .append(getAmount(), cashflow.getAmount()).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
      .append(getCurrency())
      .append(getSettlement())
      .append(getAmount())
      .toHashCode();
  }
  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code CashFlowSecurityBean}.
   * @return the meta-bean, not null
   */
  public static CashFlowSecurityBean.Meta meta() {
    return CashFlowSecurityBean.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(CashFlowSecurityBean.Meta.INSTANCE);
  }

  @Override
  public CashFlowSecurityBean.Meta metaBean() {
    return CashFlowSecurityBean.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currency.
   * @return the value of the property
   */
  public CurrencyBean getCurrency() {
    return _currency;
  }

  /**
   * Sets the currency.
   * @param currency  the new value of the property
   */
  public void setCurrency(CurrencyBean currency) {
    this._currency = currency;
  }

  /**
   * Gets the the {@code currency} property.
   * @return the property, not null
   */
  public final Property<CurrencyBean> currency() {
    return metaBean().currency().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the settlement.
   * @return the value of the property
   */
  public ZonedDateTimeBean getSettlement() {
    return _settlement;
  }

  /**
   * Sets the settlement.
   * @param settlement  the new value of the property
   */
  public void setSettlement(ZonedDateTimeBean settlement) {
    this._settlement = settlement;
  }

  /**
   * Gets the the {@code settlement} property.
   * @return the property, not null
   */
  public final Property<ZonedDateTimeBean> settlement() {
    return metaBean().settlement().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the amount.
   * @return the value of the property
   */
  public double getAmount() {
    return _amount;
  }

  /**
   * Sets the amount.
   * @param amount  the new value of the property
   */
  public void setAmount(double amount) {
    this._amount = amount;
  }

  /**
   * Gets the the {@code amount} property.
   * @return the property, not null
   */
  public final Property<Double> amount() {
    return metaBean().amount().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public CashFlowSecurityBean clone() {
    return (CashFlowSecurityBean) super.clone();
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(128);
    buf.append("CashFlowSecurityBean{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  @Override
  protected void toString(StringBuilder buf) {
    super.toString(buf);
    buf.append("currency").append('=').append(JodaBeanUtils.toString(getCurrency())).append(',').append(' ');
    buf.append("settlement").append('=').append(JodaBeanUtils.toString(getSettlement())).append(',').append(' ');
    buf.append("amount").append('=').append(JodaBeanUtils.toString(getAmount())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code CashFlowSecurityBean}.
   */
  public static class Meta extends SecurityBean.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code currency} property.
     */
    private final MetaProperty<CurrencyBean> _currency = DirectMetaProperty.ofReadWrite(
        this, "currency", CashFlowSecurityBean.class, CurrencyBean.class);
    /**
     * The meta-property for the {@code settlement} property.
     */
    private final MetaProperty<ZonedDateTimeBean> _settlement = DirectMetaProperty.ofReadWrite(
        this, "settlement", CashFlowSecurityBean.class, ZonedDateTimeBean.class);
    /**
     * The meta-property for the {@code amount} property.
     */
    private final MetaProperty<Double> _amount = DirectMetaProperty.ofReadWrite(
        this, "amount", CashFlowSecurityBean.class, Double.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "currency",
        "settlement",
        "amount");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 575402001:  // currency
          return _currency;
        case 73828649:  // settlement
          return _settlement;
        case -1413853096:  // amount
          return _amount;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends CashFlowSecurityBean> builder() {
      return new DirectBeanBuilder<CashFlowSecurityBean>(new CashFlowSecurityBean());
    }

    @Override
    public Class<? extends CashFlowSecurityBean> beanType() {
      return CashFlowSecurityBean.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code currency} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<CurrencyBean> currency() {
      return _currency;
    }

    /**
     * The meta-property for the {@code settlement} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ZonedDateTimeBean> settlement() {
      return _settlement;
    }

    /**
     * The meta-property for the {@code amount} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Double> amount() {
      return _amount;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 575402001:  // currency
          return ((CashFlowSecurityBean) bean).getCurrency();
        case 73828649:  // settlement
          return ((CashFlowSecurityBean) bean).getSettlement();
        case -1413853096:  // amount
          return ((CashFlowSecurityBean) bean).getAmount();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 575402001:  // currency
          ((CashFlowSecurityBean) bean).setCurrency((CurrencyBean) newValue);
          return;
        case 73828649:  // settlement
          ((CashFlowSecurityBean) bean).setSettlement((ZonedDateTimeBean) newValue);
          return;
        case -1413853096:  // amount
          ((CashFlowSecurityBean) bean).setAmount((Double) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
