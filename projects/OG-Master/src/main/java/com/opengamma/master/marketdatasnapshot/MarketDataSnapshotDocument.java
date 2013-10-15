/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.master.marketdatasnapshot;

import java.io.Serializable;
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

import com.opengamma.core.marketdatasnapshot.impl.ManageableMarketDataSnapshot;
import com.opengamma.id.UniqueId;
import com.opengamma.master.AbstractDocument;
import com.opengamma.util.ArgumentChecker;
import com.opengamma.util.PublicSPI;

/**
 * A document used to pass into and out of the snapshot master.
 * <p>
 * The snapshot master provides full management of the snapshot database.
 * Each element is stored in a document.
 *
 * @see MarketDataSnapshotMaster
 */
@PublicSPI
@BeanDefinition
public class MarketDataSnapshotDocument extends AbstractDocument implements Serializable {

  /** Serialization version. */
  private static final long serialVersionUID = 1L;

  /**
   * The snapshot object held by the document.
   */
  @PropertyDefinition
  private ManageableMarketDataSnapshot _snapshot;
  /**
   * The snapshot document unique identifier.
   * This field is managed by the master but must be set for updates.
   */
  @PropertyDefinition
  private UniqueId _uniqueId;

  /**
   * Creates an instance.
   */
  public MarketDataSnapshotDocument() {
  }

  /**
   * Creates an instance from a snapshot and an id.
   *
   * @param uniqueId  the unique identifier, may be null
   * @param snapshot  the snapshot, not null
   */
  public MarketDataSnapshotDocument(final UniqueId uniqueId, final ManageableMarketDataSnapshot snapshot) {
    ArgumentChecker.notNull(snapshot, "snapshot");
    setUniqueId(uniqueId);
    setSnapshot(snapshot);
  }

  /**
   * Creates an instance from a snapshot.
   *
   * @param snapshot  the snapshot, not null
   */
  public MarketDataSnapshotDocument(final ManageableMarketDataSnapshot snapshot) {
    ArgumentChecker.notNull(snapshot, "snapshot");
    setUniqueId(snapshot.getUniqueId());
    setSnapshot(snapshot);
  }

  //-------------------------------------------------------------------------
  /**
   * Gets the name of the snapshot.
   * <p>
   * This is derived from the snapshot itself.
   *
   * @return the name, null if no name
   */
  public String getName() {
    return (getSnapshot() != null ? getSnapshot().getName() : null);
  }

  @Override
  public ManageableMarketDataSnapshot getValue() {
    return getSnapshot();
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code MarketDataSnapshotDocument}.
   * @return the meta-bean, not null
   */
  public static MarketDataSnapshotDocument.Meta meta() {
    return MarketDataSnapshotDocument.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(MarketDataSnapshotDocument.Meta.INSTANCE);
  }

  @Override
  public MarketDataSnapshotDocument.Meta metaBean() {
    return MarketDataSnapshotDocument.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the snapshot object held by the document.
   * @return the value of the property
   */
  public ManageableMarketDataSnapshot getSnapshot() {
    return _snapshot;
  }

  /**
   * Sets the snapshot object held by the document.
   * @param snapshot  the new value of the property
   */
  public void setSnapshot(ManageableMarketDataSnapshot snapshot) {
    this._snapshot = snapshot;
  }

  /**
   * Gets the the {@code snapshot} property.
   * @return the property, not null
   */
  public final Property<ManageableMarketDataSnapshot> snapshot() {
    return metaBean().snapshot().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the snapshot document unique identifier.
   * This field is managed by the master but must be set for updates.
   * @return the value of the property
   */
  public UniqueId getUniqueId() {
    return _uniqueId;
  }

  /**
   * Sets the snapshot document unique identifier.
   * This field is managed by the master but must be set for updates.
   * @param uniqueId  the new value of the property
   */
  public void setUniqueId(UniqueId uniqueId) {
    this._uniqueId = uniqueId;
  }

  /**
   * Gets the the {@code uniqueId} property.
   * This field is managed by the master but must be set for updates.
   * @return the property, not null
   */
  public final Property<UniqueId> uniqueId() {
    return metaBean().uniqueId().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public MarketDataSnapshotDocument clone() {
    return (MarketDataSnapshotDocument) super.clone();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      MarketDataSnapshotDocument other = (MarketDataSnapshotDocument) obj;
      return JodaBeanUtils.equal(getSnapshot(), other.getSnapshot()) &&
          JodaBeanUtils.equal(getUniqueId(), other.getUniqueId()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(getSnapshot());
    hash += hash * 31 + JodaBeanUtils.hashCode(getUniqueId());
    return hash ^ super.hashCode();
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("MarketDataSnapshotDocument{");
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
    buf.append("snapshot").append('=').append(JodaBeanUtils.toString(getSnapshot())).append(',').append(' ');
    buf.append("uniqueId").append('=').append(JodaBeanUtils.toString(getUniqueId())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code MarketDataSnapshotDocument}.
   */
  public static class Meta extends AbstractDocument.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code snapshot} property.
     */
    private final MetaProperty<ManageableMarketDataSnapshot> _snapshot = DirectMetaProperty.ofReadWrite(
        this, "snapshot", MarketDataSnapshotDocument.class, ManageableMarketDataSnapshot.class);
    /**
     * The meta-property for the {@code uniqueId} property.
     */
    private final MetaProperty<UniqueId> _uniqueId = DirectMetaProperty.ofReadWrite(
        this, "uniqueId", MarketDataSnapshotDocument.class, UniqueId.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "snapshot",
        "uniqueId");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 284874180:  // snapshot
          return _snapshot;
        case -294460212:  // uniqueId
          return _uniqueId;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends MarketDataSnapshotDocument> builder() {
      return new DirectBeanBuilder<MarketDataSnapshotDocument>(new MarketDataSnapshotDocument());
    }

    @Override
    public Class<? extends MarketDataSnapshotDocument> beanType() {
      return MarketDataSnapshotDocument.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code snapshot} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ManageableMarketDataSnapshot> snapshot() {
      return _snapshot;
    }

    /**
     * The meta-property for the {@code uniqueId} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<UniqueId> uniqueId() {
      return _uniqueId;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 284874180:  // snapshot
          return ((MarketDataSnapshotDocument) bean).getSnapshot();
        case -294460212:  // uniqueId
          return ((MarketDataSnapshotDocument) bean).getUniqueId();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 284874180:  // snapshot
          ((MarketDataSnapshotDocument) bean).setSnapshot((ManageableMarketDataSnapshot) newValue);
          return;
        case -294460212:  // uniqueId
          ((MarketDataSnapshotDocument) bean).setUniqueId((UniqueId) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
