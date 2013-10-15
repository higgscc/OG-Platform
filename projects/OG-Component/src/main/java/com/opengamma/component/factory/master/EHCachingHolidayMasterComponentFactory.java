/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.component.factory.master;

import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.ehcache.CacheManager;

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

import com.opengamma.component.ComponentInfo;
import com.opengamma.component.ComponentRepository;
import com.opengamma.component.factory.AbstractComponentFactory;
import com.opengamma.component.factory.ComponentInfoAttributes;
import com.opengamma.master.holiday.HolidayMaster;
import com.opengamma.master.holiday.impl.DataHolidayMasterResource;
import com.opengamma.master.holiday.impl.EHCachingHolidayMaster;
import com.opengamma.master.holiday.impl.RemoteHolidayMaster;

/**
 * Component factory for the combined holiday master.
 * <p>
 * This factory creates a combined holiday master from an underlying and user master.
 */
@BeanDefinition
public class EHCachingHolidayMasterComponentFactory extends AbstractComponentFactory {

  /**
   * The classifier that the factory should publish under.
   */
  @PropertyDefinition(validate = "notNull")
  private String _classifier;
  /**
   * The flag determining whether the component should be published by REST (default true).
   */
  @PropertyDefinition
  private boolean _publishRest = true;
  /**
   * The underlying holiday master.
   */
  @PropertyDefinition(validate = "notNull")
  private HolidayMaster _underlying;
  /**
   * The cache manager.
   */
  @PropertyDefinition
  private CacheManager _cacheManager;


  //-------------------------------------------------------------------------
  @Override
  public void init(ComponentRepository repo, LinkedHashMap<String, String> holidayuration) {

    HolidayMaster master = new EHCachingHolidayMaster(getClassifier(),
                                                      getUnderlying(),
                                                      getCacheManager());

    // register
    ComponentInfo info = new ComponentInfo(HolidayMaster.class, getClassifier());
    info.addAttribute(ComponentInfoAttributes.LEVEL, 2);
    info.addAttribute(ComponentInfoAttributes.REMOTE_CLIENT_JAVA, RemoteHolidayMaster.class);
    repo.registerComponent(info, master);
    if (isPublishRest()) {
      repo.getRestComponents().publish(info, new DataHolidayMasterResource(master));
    }
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code EHCachingHolidayMasterComponentFactory}.
   * @return the meta-bean, not null
   */
  public static EHCachingHolidayMasterComponentFactory.Meta meta() {
    return EHCachingHolidayMasterComponentFactory.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(EHCachingHolidayMasterComponentFactory.Meta.INSTANCE);
  }

  @Override
  public EHCachingHolidayMasterComponentFactory.Meta metaBean() {
    return EHCachingHolidayMasterComponentFactory.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the classifier that the factory should publish under.
   * @return the value of the property, not null
   */
  public String getClassifier() {
    return _classifier;
  }

  /**
   * Sets the classifier that the factory should publish under.
   * @param classifier  the new value of the property, not null
   */
  public void setClassifier(String classifier) {
    JodaBeanUtils.notNull(classifier, "classifier");
    this._classifier = classifier;
  }

  /**
   * Gets the the {@code classifier} property.
   * @return the property, not null
   */
  public final Property<String> classifier() {
    return metaBean().classifier().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the flag determining whether the component should be published by REST (default true).
   * @return the value of the property
   */
  public boolean isPublishRest() {
    return _publishRest;
  }

  /**
   * Sets the flag determining whether the component should be published by REST (default true).
   * @param publishRest  the new value of the property
   */
  public void setPublishRest(boolean publishRest) {
    this._publishRest = publishRest;
  }

  /**
   * Gets the the {@code publishRest} property.
   * @return the property, not null
   */
  public final Property<Boolean> publishRest() {
    return metaBean().publishRest().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the underlying holiday master.
   * @return the value of the property, not null
   */
  public HolidayMaster getUnderlying() {
    return _underlying;
  }

  /**
   * Sets the underlying holiday master.
   * @param underlying  the new value of the property, not null
   */
  public void setUnderlying(HolidayMaster underlying) {
    JodaBeanUtils.notNull(underlying, "underlying");
    this._underlying = underlying;
  }

  /**
   * Gets the the {@code underlying} property.
   * @return the property, not null
   */
  public final Property<HolidayMaster> underlying() {
    return metaBean().underlying().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the cache manager.
   * @return the value of the property
   */
  public CacheManager getCacheManager() {
    return _cacheManager;
  }

  /**
   * Sets the cache manager.
   * @param cacheManager  the new value of the property
   */
  public void setCacheManager(CacheManager cacheManager) {
    this._cacheManager = cacheManager;
  }

  /**
   * Gets the the {@code cacheManager} property.
   * @return the property, not null
   */
  public final Property<CacheManager> cacheManager() {
    return metaBean().cacheManager().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public EHCachingHolidayMasterComponentFactory clone() {
    return (EHCachingHolidayMasterComponentFactory) super.clone();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      EHCachingHolidayMasterComponentFactory other = (EHCachingHolidayMasterComponentFactory) obj;
      return JodaBeanUtils.equal(getClassifier(), other.getClassifier()) &&
          (isPublishRest() == other.isPublishRest()) &&
          JodaBeanUtils.equal(getUnderlying(), other.getUnderlying()) &&
          JodaBeanUtils.equal(getCacheManager(), other.getCacheManager()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(getClassifier());
    hash += hash * 31 + JodaBeanUtils.hashCode(isPublishRest());
    hash += hash * 31 + JodaBeanUtils.hashCode(getUnderlying());
    hash += hash * 31 + JodaBeanUtils.hashCode(getCacheManager());
    return hash ^ super.hashCode();
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(160);
    buf.append("EHCachingHolidayMasterComponentFactory{");
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
    buf.append("classifier").append('=').append(JodaBeanUtils.toString(getClassifier())).append(',').append(' ');
    buf.append("publishRest").append('=').append(JodaBeanUtils.toString(isPublishRest())).append(',').append(' ');
    buf.append("underlying").append('=').append(JodaBeanUtils.toString(getUnderlying())).append(',').append(' ');
    buf.append("cacheManager").append('=').append(JodaBeanUtils.toString(getCacheManager())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code EHCachingHolidayMasterComponentFactory}.
   */
  public static class Meta extends AbstractComponentFactory.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code classifier} property.
     */
    private final MetaProperty<String> _classifier = DirectMetaProperty.ofReadWrite(
        this, "classifier", EHCachingHolidayMasterComponentFactory.class, String.class);
    /**
     * The meta-property for the {@code publishRest} property.
     */
    private final MetaProperty<Boolean> _publishRest = DirectMetaProperty.ofReadWrite(
        this, "publishRest", EHCachingHolidayMasterComponentFactory.class, Boolean.TYPE);
    /**
     * The meta-property for the {@code underlying} property.
     */
    private final MetaProperty<HolidayMaster> _underlying = DirectMetaProperty.ofReadWrite(
        this, "underlying", EHCachingHolidayMasterComponentFactory.class, HolidayMaster.class);
    /**
     * The meta-property for the {@code cacheManager} property.
     */
    private final MetaProperty<CacheManager> _cacheManager = DirectMetaProperty.ofReadWrite(
        this, "cacheManager", EHCachingHolidayMasterComponentFactory.class, CacheManager.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "classifier",
        "publishRest",
        "underlying",
        "cacheManager");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -281470431:  // classifier
          return _classifier;
        case -614707837:  // publishRest
          return _publishRest;
        case -1770633379:  // underlying
          return _underlying;
        case -1452875317:  // cacheManager
          return _cacheManager;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends EHCachingHolidayMasterComponentFactory> builder() {
      return new DirectBeanBuilder<EHCachingHolidayMasterComponentFactory>(new EHCachingHolidayMasterComponentFactory());
    }

    @Override
    public Class<? extends EHCachingHolidayMasterComponentFactory> beanType() {
      return EHCachingHolidayMasterComponentFactory.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code classifier} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> classifier() {
      return _classifier;
    }

    /**
     * The meta-property for the {@code publishRest} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Boolean> publishRest() {
      return _publishRest;
    }

    /**
     * The meta-property for the {@code underlying} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<HolidayMaster> underlying() {
      return _underlying;
    }

    /**
     * The meta-property for the {@code cacheManager} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<CacheManager> cacheManager() {
      return _cacheManager;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -281470431:  // classifier
          return ((EHCachingHolidayMasterComponentFactory) bean).getClassifier();
        case -614707837:  // publishRest
          return ((EHCachingHolidayMasterComponentFactory) bean).isPublishRest();
        case -1770633379:  // underlying
          return ((EHCachingHolidayMasterComponentFactory) bean).getUnderlying();
        case -1452875317:  // cacheManager
          return ((EHCachingHolidayMasterComponentFactory) bean).getCacheManager();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -281470431:  // classifier
          ((EHCachingHolidayMasterComponentFactory) bean).setClassifier((String) newValue);
          return;
        case -614707837:  // publishRest
          ((EHCachingHolidayMasterComponentFactory) bean).setPublishRest((Boolean) newValue);
          return;
        case -1770633379:  // underlying
          ((EHCachingHolidayMasterComponentFactory) bean).setUnderlying((HolidayMaster) newValue);
          return;
        case -1452875317:  // cacheManager
          ((EHCachingHolidayMasterComponentFactory) bean).setCacheManager((CacheManager) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

    @Override
    protected void validate(Bean bean) {
      JodaBeanUtils.notNull(((EHCachingHolidayMasterComponentFactory) bean)._classifier, "classifier");
      JodaBeanUtils.notNull(((EHCachingHolidayMasterComponentFactory) bean)._underlying, "underlying");
      super.validate(bean);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
