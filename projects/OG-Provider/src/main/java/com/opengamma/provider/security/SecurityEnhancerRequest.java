/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.provider.security;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBean;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.opengamma.core.security.Security;
import com.opengamma.util.ArgumentChecker;
import com.opengamma.util.PublicSPI;

/**
 * Request to enhance one or more securities.
 * <p>
 * This class is mutable and not thread-safe.
 */
@PublicSPI
@BeanDefinition
public class SecurityEnhancerRequest extends DirectBean {

  /**
   * The list of securities to enhance.
   */
  @PropertyDefinition
  private final List<Security> _securities = Lists.newArrayList();

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance to enhance one or more securities.
   * 
   * @param securities  the securities to enhance, not null
   * @return the request, not null
   */
  public static SecurityEnhancerRequest create(Security... securities) {
    SecurityEnhancerRequest request = new SecurityEnhancerRequest();
    request.addSecurities(securities);
    return request;
  }

  /**
   * Obtains an instance to enhance multiple securities.
   * 
   * @param securities  the securities to enhance, not null
   * @return the request, not null
   */
  public static SecurityEnhancerRequest create(Iterable<? extends Security> securities) {
    SecurityEnhancerRequest request = new SecurityEnhancerRequest();
    request.addSecurities(securities);
    return request;
  }

  //-------------------------------------------------------------------------
  /**
   * Creates an instance.
   */
  protected SecurityEnhancerRequest() {
  }

  //-------------------------------------------------------------------------
  /**
   * Adds an array of securities to those to be enhanced.
   * 
   * @param securities  the securities to enhance, not null
   */
  public void addSecurities(Security... securities) {
    ArgumentChecker.notNull(securities, "securities");
    getSecurities().addAll(Arrays.asList(securities));
  }

  /**
   * Adds a collection of securities to those to be enhanced.
   * 
   * @param securities  the securities to enhance, not null
   */
  public void addSecurities(Iterable<? extends Security> securities) {
    ArgumentChecker.notNull(securities, "securities");
    Iterables.addAll(getSecurities(), securities);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code SecurityEnhancerRequest}.
   * @return the meta-bean, not null
   */
  public static SecurityEnhancerRequest.Meta meta() {
    return SecurityEnhancerRequest.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(SecurityEnhancerRequest.Meta.INSTANCE);
  }

  @Override
  public SecurityEnhancerRequest.Meta metaBean() {
    return SecurityEnhancerRequest.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the list of securities to enhance.
   * @return the value of the property
   */
  public List<Security> getSecurities() {
    return _securities;
  }

  /**
   * Sets the list of securities to enhance.
   * @param securities  the new value of the property
   */
  public void setSecurities(List<Security> securities) {
    this._securities.clear();
    this._securities.addAll(securities);
  }

  /**
   * Gets the the {@code securities} property.
   * @return the property, not null
   */
  public final Property<List<Security>> securities() {
    return metaBean().securities().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public SecurityEnhancerRequest clone() {
    BeanBuilder<? extends SecurityEnhancerRequest> builder = metaBean().builder();
    for (MetaProperty<?> mp : metaBean().metaPropertyIterable()) {
      if (mp.style().isBuildable()) {
        Object value = mp.get(this);
        if (value instanceof Bean) {
          value = ((Bean) value).clone();
        }
        builder.set(mp.name(), value);
      }
    }
    return builder.build();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      SecurityEnhancerRequest other = (SecurityEnhancerRequest) obj;
      return JodaBeanUtils.equal(getSecurities(), other.getSecurities());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash += hash * 31 + JodaBeanUtils.hashCode(getSecurities());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("SecurityEnhancerRequest{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  protected void toString(StringBuilder buf) {
    buf.append("securities").append('=').append(JodaBeanUtils.toString(getSecurities())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code SecurityEnhancerRequest}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code securities} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<List<Security>> _securities = DirectMetaProperty.ofReadWrite(
        this, "securities", SecurityEnhancerRequest.class, (Class) List.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "securities");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1574008798:  // securities
          return _securities;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends SecurityEnhancerRequest> builder() {
      return new DirectBeanBuilder<SecurityEnhancerRequest>(new SecurityEnhancerRequest());
    }

    @Override
    public Class<? extends SecurityEnhancerRequest> beanType() {
      return SecurityEnhancerRequest.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code securities} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<List<Security>> securities() {
      return _securities;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 1574008798:  // securities
          return ((SecurityEnhancerRequest) bean).getSecurities();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 1574008798:  // securities
          ((SecurityEnhancerRequest) bean).setSecurities((List<Security>) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
