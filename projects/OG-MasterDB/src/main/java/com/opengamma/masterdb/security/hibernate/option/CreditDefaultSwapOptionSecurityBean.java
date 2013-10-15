/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.masterdb.security.hibernate.option;

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

import com.opengamma.financial.security.option.CreditDefaultSwapOptionSecurity;
import com.opengamma.masterdb.security.hibernate.CurrencyBean;
import com.opengamma.masterdb.security.hibernate.ExternalIdBean;
import com.opengamma.masterdb.security.hibernate.SecurityBean;
import com.opengamma.masterdb.security.hibernate.ZonedDateTimeBean;

/**
 * A Hibernate bean representation of {@link CreditDefaultSwapOptionSecurity}.
 */
@BeanDefinition
public class CreditDefaultSwapOptionSecurityBean extends SecurityBean {
  
  @PropertyDefinition
  private Boolean _buy;
  @PropertyDefinition
  private ExternalIdBean _protectionBuyer;
  @PropertyDefinition
  private ExternalIdBean _protectionSeller;
  @PropertyDefinition
  private ZonedDateTimeBean _startDate;
  @PropertyDefinition
  private ZonedDateTimeBean _maturityDate;
  @PropertyDefinition
  private CurrencyBean _currency;
  @PropertyDefinition
  private Double _notional;
  @PropertyDefinition
  private Double _strike;
  @PropertyDefinition
  private Boolean _knockOut;
  @PropertyDefinition
  private Boolean _payer;
  @PropertyDefinition
  private OptionExerciseType _exerciseType;
  @PropertyDefinition
  private ExternalIdBean _underlying;
    
  public CreditDefaultSwapOptionSecurityBean() {
    super();
  }
  
  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code CreditDefaultSwapOptionSecurityBean}.
   * @return the meta-bean, not null
   */
  public static CreditDefaultSwapOptionSecurityBean.Meta meta() {
    return CreditDefaultSwapOptionSecurityBean.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(CreditDefaultSwapOptionSecurityBean.Meta.INSTANCE);
  }

  @Override
  public CreditDefaultSwapOptionSecurityBean.Meta metaBean() {
    return CreditDefaultSwapOptionSecurityBean.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the buy.
   * @return the value of the property
   */
  public Boolean getBuy() {
    return _buy;
  }

  /**
   * Sets the buy.
   * @param buy  the new value of the property
   */
  public void setBuy(Boolean buy) {
    this._buy = buy;
  }

  /**
   * Gets the the {@code buy} property.
   * @return the property, not null
   */
  public final Property<Boolean> buy() {
    return metaBean().buy().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the protectionBuyer.
   * @return the value of the property
   */
  public ExternalIdBean getProtectionBuyer() {
    return _protectionBuyer;
  }

  /**
   * Sets the protectionBuyer.
   * @param protectionBuyer  the new value of the property
   */
  public void setProtectionBuyer(ExternalIdBean protectionBuyer) {
    this._protectionBuyer = protectionBuyer;
  }

  /**
   * Gets the the {@code protectionBuyer} property.
   * @return the property, not null
   */
  public final Property<ExternalIdBean> protectionBuyer() {
    return metaBean().protectionBuyer().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the protectionSeller.
   * @return the value of the property
   */
  public ExternalIdBean getProtectionSeller() {
    return _protectionSeller;
  }

  /**
   * Sets the protectionSeller.
   * @param protectionSeller  the new value of the property
   */
  public void setProtectionSeller(ExternalIdBean protectionSeller) {
    this._protectionSeller = protectionSeller;
  }

  /**
   * Gets the the {@code protectionSeller} property.
   * @return the property, not null
   */
  public final Property<ExternalIdBean> protectionSeller() {
    return metaBean().protectionSeller().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the startDate.
   * @return the value of the property
   */
  public ZonedDateTimeBean getStartDate() {
    return _startDate;
  }

  /**
   * Sets the startDate.
   * @param startDate  the new value of the property
   */
  public void setStartDate(ZonedDateTimeBean startDate) {
    this._startDate = startDate;
  }

  /**
   * Gets the the {@code startDate} property.
   * @return the property, not null
   */
  public final Property<ZonedDateTimeBean> startDate() {
    return metaBean().startDate().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the maturityDate.
   * @return the value of the property
   */
  public ZonedDateTimeBean getMaturityDate() {
    return _maturityDate;
  }

  /**
   * Sets the maturityDate.
   * @param maturityDate  the new value of the property
   */
  public void setMaturityDate(ZonedDateTimeBean maturityDate) {
    this._maturityDate = maturityDate;
  }

  /**
   * Gets the the {@code maturityDate} property.
   * @return the property, not null
   */
  public final Property<ZonedDateTimeBean> maturityDate() {
    return metaBean().maturityDate().createProperty(this);
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
   * Gets the notional.
   * @return the value of the property
   */
  public Double getNotional() {
    return _notional;
  }

  /**
   * Sets the notional.
   * @param notional  the new value of the property
   */
  public void setNotional(Double notional) {
    this._notional = notional;
  }

  /**
   * Gets the the {@code notional} property.
   * @return the property, not null
   */
  public final Property<Double> notional() {
    return metaBean().notional().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the strike.
   * @return the value of the property
   */
  public Double getStrike() {
    return _strike;
  }

  /**
   * Sets the strike.
   * @param strike  the new value of the property
   */
  public void setStrike(Double strike) {
    this._strike = strike;
  }

  /**
   * Gets the the {@code strike} property.
   * @return the property, not null
   */
  public final Property<Double> strike() {
    return metaBean().strike().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the knockOut.
   * @return the value of the property
   */
  public Boolean getKnockOut() {
    return _knockOut;
  }

  /**
   * Sets the knockOut.
   * @param knockOut  the new value of the property
   */
  public void setKnockOut(Boolean knockOut) {
    this._knockOut = knockOut;
  }

  /**
   * Gets the the {@code knockOut} property.
   * @return the property, not null
   */
  public final Property<Boolean> knockOut() {
    return metaBean().knockOut().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the payer.
   * @return the value of the property
   */
  public Boolean getPayer() {
    return _payer;
  }

  /**
   * Sets the payer.
   * @param payer  the new value of the property
   */
  public void setPayer(Boolean payer) {
    this._payer = payer;
  }

  /**
   * Gets the the {@code payer} property.
   * @return the property, not null
   */
  public final Property<Boolean> payer() {
    return metaBean().payer().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the exerciseType.
   * @return the value of the property
   */
  public OptionExerciseType getExerciseType() {
    return _exerciseType;
  }

  /**
   * Sets the exerciseType.
   * @param exerciseType  the new value of the property
   */
  public void setExerciseType(OptionExerciseType exerciseType) {
    this._exerciseType = exerciseType;
  }

  /**
   * Gets the the {@code exerciseType} property.
   * @return the property, not null
   */
  public final Property<OptionExerciseType> exerciseType() {
    return metaBean().exerciseType().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the underlying.
   * @return the value of the property
   */
  public ExternalIdBean getUnderlying() {
    return _underlying;
  }

  /**
   * Sets the underlying.
   * @param underlying  the new value of the property
   */
  public void setUnderlying(ExternalIdBean underlying) {
    this._underlying = underlying;
  }

  /**
   * Gets the the {@code underlying} property.
   * @return the property, not null
   */
  public final Property<ExternalIdBean> underlying() {
    return metaBean().underlying().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public CreditDefaultSwapOptionSecurityBean clone() {
    return (CreditDefaultSwapOptionSecurityBean) super.clone();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      CreditDefaultSwapOptionSecurityBean other = (CreditDefaultSwapOptionSecurityBean) obj;
      return JodaBeanUtils.equal(getBuy(), other.getBuy()) &&
          JodaBeanUtils.equal(getProtectionBuyer(), other.getProtectionBuyer()) &&
          JodaBeanUtils.equal(getProtectionSeller(), other.getProtectionSeller()) &&
          JodaBeanUtils.equal(getStartDate(), other.getStartDate()) &&
          JodaBeanUtils.equal(getMaturityDate(), other.getMaturityDate()) &&
          JodaBeanUtils.equal(getCurrency(), other.getCurrency()) &&
          JodaBeanUtils.equal(getNotional(), other.getNotional()) &&
          JodaBeanUtils.equal(getStrike(), other.getStrike()) &&
          JodaBeanUtils.equal(getKnockOut(), other.getKnockOut()) &&
          JodaBeanUtils.equal(getPayer(), other.getPayer()) &&
          JodaBeanUtils.equal(getExerciseType(), other.getExerciseType()) &&
          JodaBeanUtils.equal(getUnderlying(), other.getUnderlying()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(getBuy());
    hash += hash * 31 + JodaBeanUtils.hashCode(getProtectionBuyer());
    hash += hash * 31 + JodaBeanUtils.hashCode(getProtectionSeller());
    hash += hash * 31 + JodaBeanUtils.hashCode(getStartDate());
    hash += hash * 31 + JodaBeanUtils.hashCode(getMaturityDate());
    hash += hash * 31 + JodaBeanUtils.hashCode(getCurrency());
    hash += hash * 31 + JodaBeanUtils.hashCode(getNotional());
    hash += hash * 31 + JodaBeanUtils.hashCode(getStrike());
    hash += hash * 31 + JodaBeanUtils.hashCode(getKnockOut());
    hash += hash * 31 + JodaBeanUtils.hashCode(getPayer());
    hash += hash * 31 + JodaBeanUtils.hashCode(getExerciseType());
    hash += hash * 31 + JodaBeanUtils.hashCode(getUnderlying());
    return hash ^ super.hashCode();
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(416);
    buf.append("CreditDefaultSwapOptionSecurityBean{");
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
    buf.append("buy").append('=').append(JodaBeanUtils.toString(getBuy())).append(',').append(' ');
    buf.append("protectionBuyer").append('=').append(JodaBeanUtils.toString(getProtectionBuyer())).append(',').append(' ');
    buf.append("protectionSeller").append('=').append(JodaBeanUtils.toString(getProtectionSeller())).append(',').append(' ');
    buf.append("startDate").append('=').append(JodaBeanUtils.toString(getStartDate())).append(',').append(' ');
    buf.append("maturityDate").append('=').append(JodaBeanUtils.toString(getMaturityDate())).append(',').append(' ');
    buf.append("currency").append('=').append(JodaBeanUtils.toString(getCurrency())).append(',').append(' ');
    buf.append("notional").append('=').append(JodaBeanUtils.toString(getNotional())).append(',').append(' ');
    buf.append("strike").append('=').append(JodaBeanUtils.toString(getStrike())).append(',').append(' ');
    buf.append("knockOut").append('=').append(JodaBeanUtils.toString(getKnockOut())).append(',').append(' ');
    buf.append("payer").append('=').append(JodaBeanUtils.toString(getPayer())).append(',').append(' ');
    buf.append("exerciseType").append('=').append(JodaBeanUtils.toString(getExerciseType())).append(',').append(' ');
    buf.append("underlying").append('=').append(JodaBeanUtils.toString(getUnderlying())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code CreditDefaultSwapOptionSecurityBean}.
   */
  public static class Meta extends SecurityBean.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code buy} property.
     */
    private final MetaProperty<Boolean> _buy = DirectMetaProperty.ofReadWrite(
        this, "buy", CreditDefaultSwapOptionSecurityBean.class, Boolean.class);
    /**
     * The meta-property for the {@code protectionBuyer} property.
     */
    private final MetaProperty<ExternalIdBean> _protectionBuyer = DirectMetaProperty.ofReadWrite(
        this, "protectionBuyer", CreditDefaultSwapOptionSecurityBean.class, ExternalIdBean.class);
    /**
     * The meta-property for the {@code protectionSeller} property.
     */
    private final MetaProperty<ExternalIdBean> _protectionSeller = DirectMetaProperty.ofReadWrite(
        this, "protectionSeller", CreditDefaultSwapOptionSecurityBean.class, ExternalIdBean.class);
    /**
     * The meta-property for the {@code startDate} property.
     */
    private final MetaProperty<ZonedDateTimeBean> _startDate = DirectMetaProperty.ofReadWrite(
        this, "startDate", CreditDefaultSwapOptionSecurityBean.class, ZonedDateTimeBean.class);
    /**
     * The meta-property for the {@code maturityDate} property.
     */
    private final MetaProperty<ZonedDateTimeBean> _maturityDate = DirectMetaProperty.ofReadWrite(
        this, "maturityDate", CreditDefaultSwapOptionSecurityBean.class, ZonedDateTimeBean.class);
    /**
     * The meta-property for the {@code currency} property.
     */
    private final MetaProperty<CurrencyBean> _currency = DirectMetaProperty.ofReadWrite(
        this, "currency", CreditDefaultSwapOptionSecurityBean.class, CurrencyBean.class);
    /**
     * The meta-property for the {@code notional} property.
     */
    private final MetaProperty<Double> _notional = DirectMetaProperty.ofReadWrite(
        this, "notional", CreditDefaultSwapOptionSecurityBean.class, Double.class);
    /**
     * The meta-property for the {@code strike} property.
     */
    private final MetaProperty<Double> _strike = DirectMetaProperty.ofReadWrite(
        this, "strike", CreditDefaultSwapOptionSecurityBean.class, Double.class);
    /**
     * The meta-property for the {@code knockOut} property.
     */
    private final MetaProperty<Boolean> _knockOut = DirectMetaProperty.ofReadWrite(
        this, "knockOut", CreditDefaultSwapOptionSecurityBean.class, Boolean.class);
    /**
     * The meta-property for the {@code payer} property.
     */
    private final MetaProperty<Boolean> _payer = DirectMetaProperty.ofReadWrite(
        this, "payer", CreditDefaultSwapOptionSecurityBean.class, Boolean.class);
    /**
     * The meta-property for the {@code exerciseType} property.
     */
    private final MetaProperty<OptionExerciseType> _exerciseType = DirectMetaProperty.ofReadWrite(
        this, "exerciseType", CreditDefaultSwapOptionSecurityBean.class, OptionExerciseType.class);
    /**
     * The meta-property for the {@code underlying} property.
     */
    private final MetaProperty<ExternalIdBean> _underlying = DirectMetaProperty.ofReadWrite(
        this, "underlying", CreditDefaultSwapOptionSecurityBean.class, ExternalIdBean.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "buy",
        "protectionBuyer",
        "protectionSeller",
        "startDate",
        "maturityDate",
        "currency",
        "notional",
        "strike",
        "knockOut",
        "payer",
        "exerciseType",
        "underlying");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 97926:  // buy
          return _buy;
        case 2087835226:  // protectionBuyer
          return _protectionBuyer;
        case 769920952:  // protectionSeller
          return _protectionSeller;
        case -2129778896:  // startDate
          return _startDate;
        case -414641441:  // maturityDate
          return _maturityDate;
        case 575402001:  // currency
          return _currency;
        case 1585636160:  // notional
          return _notional;
        case -891985998:  // strike
          return _strike;
        case -384166438:  // knockOut
          return _knockOut;
        case 106443605:  // payer
          return _payer;
        case -466331342:  // exerciseType
          return _exerciseType;
        case -1770633379:  // underlying
          return _underlying;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends CreditDefaultSwapOptionSecurityBean> builder() {
      return new DirectBeanBuilder<CreditDefaultSwapOptionSecurityBean>(new CreditDefaultSwapOptionSecurityBean());
    }

    @Override
    public Class<? extends CreditDefaultSwapOptionSecurityBean> beanType() {
      return CreditDefaultSwapOptionSecurityBean.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code buy} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Boolean> buy() {
      return _buy;
    }

    /**
     * The meta-property for the {@code protectionBuyer} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ExternalIdBean> protectionBuyer() {
      return _protectionBuyer;
    }

    /**
     * The meta-property for the {@code protectionSeller} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ExternalIdBean> protectionSeller() {
      return _protectionSeller;
    }

    /**
     * The meta-property for the {@code startDate} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ZonedDateTimeBean> startDate() {
      return _startDate;
    }

    /**
     * The meta-property for the {@code maturityDate} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ZonedDateTimeBean> maturityDate() {
      return _maturityDate;
    }

    /**
     * The meta-property for the {@code currency} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<CurrencyBean> currency() {
      return _currency;
    }

    /**
     * The meta-property for the {@code notional} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Double> notional() {
      return _notional;
    }

    /**
     * The meta-property for the {@code strike} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Double> strike() {
      return _strike;
    }

    /**
     * The meta-property for the {@code knockOut} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Boolean> knockOut() {
      return _knockOut;
    }

    /**
     * The meta-property for the {@code payer} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Boolean> payer() {
      return _payer;
    }

    /**
     * The meta-property for the {@code exerciseType} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<OptionExerciseType> exerciseType() {
      return _exerciseType;
    }

    /**
     * The meta-property for the {@code underlying} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ExternalIdBean> underlying() {
      return _underlying;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 97926:  // buy
          return ((CreditDefaultSwapOptionSecurityBean) bean).getBuy();
        case 2087835226:  // protectionBuyer
          return ((CreditDefaultSwapOptionSecurityBean) bean).getProtectionBuyer();
        case 769920952:  // protectionSeller
          return ((CreditDefaultSwapOptionSecurityBean) bean).getProtectionSeller();
        case -2129778896:  // startDate
          return ((CreditDefaultSwapOptionSecurityBean) bean).getStartDate();
        case -414641441:  // maturityDate
          return ((CreditDefaultSwapOptionSecurityBean) bean).getMaturityDate();
        case 575402001:  // currency
          return ((CreditDefaultSwapOptionSecurityBean) bean).getCurrency();
        case 1585636160:  // notional
          return ((CreditDefaultSwapOptionSecurityBean) bean).getNotional();
        case -891985998:  // strike
          return ((CreditDefaultSwapOptionSecurityBean) bean).getStrike();
        case -384166438:  // knockOut
          return ((CreditDefaultSwapOptionSecurityBean) bean).getKnockOut();
        case 106443605:  // payer
          return ((CreditDefaultSwapOptionSecurityBean) bean).getPayer();
        case -466331342:  // exerciseType
          return ((CreditDefaultSwapOptionSecurityBean) bean).getExerciseType();
        case -1770633379:  // underlying
          return ((CreditDefaultSwapOptionSecurityBean) bean).getUnderlying();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 97926:  // buy
          ((CreditDefaultSwapOptionSecurityBean) bean).setBuy((Boolean) newValue);
          return;
        case 2087835226:  // protectionBuyer
          ((CreditDefaultSwapOptionSecurityBean) bean).setProtectionBuyer((ExternalIdBean) newValue);
          return;
        case 769920952:  // protectionSeller
          ((CreditDefaultSwapOptionSecurityBean) bean).setProtectionSeller((ExternalIdBean) newValue);
          return;
        case -2129778896:  // startDate
          ((CreditDefaultSwapOptionSecurityBean) bean).setStartDate((ZonedDateTimeBean) newValue);
          return;
        case -414641441:  // maturityDate
          ((CreditDefaultSwapOptionSecurityBean) bean).setMaturityDate((ZonedDateTimeBean) newValue);
          return;
        case 575402001:  // currency
          ((CreditDefaultSwapOptionSecurityBean) bean).setCurrency((CurrencyBean) newValue);
          return;
        case 1585636160:  // notional
          ((CreditDefaultSwapOptionSecurityBean) bean).setNotional((Double) newValue);
          return;
        case -891985998:  // strike
          ((CreditDefaultSwapOptionSecurityBean) bean).setStrike((Double) newValue);
          return;
        case -384166438:  // knockOut
          ((CreditDefaultSwapOptionSecurityBean) bean).setKnockOut((Boolean) newValue);
          return;
        case 106443605:  // payer
          ((CreditDefaultSwapOptionSecurityBean) bean).setPayer((Boolean) newValue);
          return;
        case -466331342:  // exerciseType
          ((CreditDefaultSwapOptionSecurityBean) bean).setExerciseType((OptionExerciseType) newValue);
          return;
        case -1770633379:  // underlying
          ((CreditDefaultSwapOptionSecurityBean) bean).setUnderlying((ExternalIdBean) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
