/**
 * Copyright (C) 2012 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.masterdb.security.hibernate.cds;

import java.util.Map;

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

/**
 * 
 */
@BeanDefinition
public class LegacyRecoveryLockCDSSecurityBean extends CreditDefaultSwapSecurityBean {
  
  @PropertyDefinition
  private Double _parSpread;

  @PropertyDefinition
  private Double _recoveryRate;

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code LegacyRecoveryLockCDSSecurityBean}.
   * @return the meta-bean, not null
   */
  public static LegacyRecoveryLockCDSSecurityBean.Meta meta() {
    return LegacyRecoveryLockCDSSecurityBean.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(LegacyRecoveryLockCDSSecurityBean.Meta.INSTANCE);
  }

  @Override
  public LegacyRecoveryLockCDSSecurityBean.Meta metaBean() {
    return LegacyRecoveryLockCDSSecurityBean.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the parSpread.
   * @return the value of the property
   */
  public Double getParSpread() {
    return _parSpread;
  }

  /**
   * Sets the parSpread.
   * @param parSpread  the new value of the property
   */
  public void setParSpread(Double parSpread) {
    this._parSpread = parSpread;
  }

  /**
   * Gets the the {@code parSpread} property.
   * @return the property, not null
   */
  public final Property<Double> parSpread() {
    return metaBean().parSpread().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the recoveryRate.
   * @return the value of the property
   */
  public Double getRecoveryRate() {
    return _recoveryRate;
  }

  /**
   * Sets the recoveryRate.
   * @param recoveryRate  the new value of the property
   */
  public void setRecoveryRate(Double recoveryRate) {
    this._recoveryRate = recoveryRate;
  }

  /**
   * Gets the the {@code recoveryRate} property.
   * @return the property, not null
   */
  public final Property<Double> recoveryRate() {
    return metaBean().recoveryRate().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public LegacyRecoveryLockCDSSecurityBean clone() {
    return (LegacyRecoveryLockCDSSecurityBean) super.clone();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      LegacyRecoveryLockCDSSecurityBean other = (LegacyRecoveryLockCDSSecurityBean) obj;
      return JodaBeanUtils.equal(getParSpread(), other.getParSpread()) &&
          JodaBeanUtils.equal(getRecoveryRate(), other.getRecoveryRate()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(getParSpread());
    hash += hash * 31 + JodaBeanUtils.hashCode(getRecoveryRate());
    return hash ^ super.hashCode();
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("LegacyRecoveryLockCDSSecurityBean{");
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
    buf.append("parSpread").append('=').append(JodaBeanUtils.toString(getParSpread())).append(',').append(' ');
    buf.append("recoveryRate").append('=').append(JodaBeanUtils.toString(getRecoveryRate())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code LegacyRecoveryLockCDSSecurityBean}.
   */
  public static class Meta extends CreditDefaultSwapSecurityBean.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code parSpread} property.
     */
    private final MetaProperty<Double> _parSpread = DirectMetaProperty.ofReadWrite(
        this, "parSpread", LegacyRecoveryLockCDSSecurityBean.class, Double.class);
    /**
     * The meta-property for the {@code recoveryRate} property.
     */
    private final MetaProperty<Double> _recoveryRate = DirectMetaProperty.ofReadWrite(
        this, "recoveryRate", LegacyRecoveryLockCDSSecurityBean.class, Double.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "parSpread",
        "recoveryRate");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1556795764:  // parSpread
          return _parSpread;
        case 2002873877:  // recoveryRate
          return _recoveryRate;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends LegacyRecoveryLockCDSSecurityBean> builder() {
      return new DirectBeanBuilder<LegacyRecoveryLockCDSSecurityBean>(new LegacyRecoveryLockCDSSecurityBean());
    }

    @Override
    public Class<? extends LegacyRecoveryLockCDSSecurityBean> beanType() {
      return LegacyRecoveryLockCDSSecurityBean.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code parSpread} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Double> parSpread() {
      return _parSpread;
    }

    /**
     * The meta-property for the {@code recoveryRate} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Double> recoveryRate() {
      return _recoveryRate;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 1556795764:  // parSpread
          return ((LegacyRecoveryLockCDSSecurityBean) bean).getParSpread();
        case 2002873877:  // recoveryRate
          return ((LegacyRecoveryLockCDSSecurityBean) bean).getRecoveryRate();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 1556795764:  // parSpread
          ((LegacyRecoveryLockCDSSecurityBean) bean).setParSpread((Double) newValue);
          return;
        case 2002873877:  // recoveryRate
          ((LegacyRecoveryLockCDSSecurityBean) bean).setRecoveryRate((Double) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
