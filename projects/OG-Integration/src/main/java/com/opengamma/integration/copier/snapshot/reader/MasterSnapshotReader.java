/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.integration.copier.snapshot.reader;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opengamma.core.marketdatasnapshot.CurveKey;
import com.opengamma.core.marketdatasnapshot.CurveSnapshot;
import com.opengamma.core.marketdatasnapshot.StructuredMarketDataSnapshot;
import com.opengamma.core.marketdatasnapshot.VolatilitySurfaceKey;
import com.opengamma.core.marketdatasnapshot.VolatilitySurfaceSnapshot;
import com.opengamma.core.marketdatasnapshot.YieldCurveKey;
import com.opengamma.core.marketdatasnapshot.YieldCurveSnapshot;
import com.opengamma.id.UniqueId;
import com.opengamma.master.marketdatasnapshot.MarketDataSnapshotDocument;
import com.opengamma.master.marketdatasnapshot.MarketDataSnapshotMaster;
import com.opengamma.util.ArgumentChecker;

/**
 * Snapshot reader.
 */
public class MasterSnapshotReader implements SnapshotReader {

  private static final Logger s_logger = LoggerFactory.getLogger(SnapshotReader.class);

  private MarketDataSnapshotMaster _snapshotMaster;
  private StructuredMarketDataSnapshot _snapshot;
  private MarketDataSnapshotDocument _snapshotDocument;

  public MasterSnapshotReader(UniqueId uniqueId, MarketDataSnapshotMaster marketDataSnapshotMaster) {
    ArgumentChecker.notNull(marketDataSnapshotMaster, "marketDataSnapshotMaster");
    ArgumentChecker.notNull(uniqueId, "uniqueId");
    _snapshotMaster = marketDataSnapshotMaster;
    _snapshot = _snapshotMaster.get(uniqueId).getSnapshot();

  }

  @Override
  public Map<CurveKey, CurveSnapshot> readCurves() {
    _snapshot.getCurves();
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public StructuredMarketDataSnapshot readGlobalValues() {
    _snapshot.getGlobalValues();
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public Map<VolatilitySurfaceKey, VolatilitySurfaceSnapshot> readVolatilitySurfaces() {
    _snapshot.getVolatilitySurfaces();
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public Map<YieldCurveKey, YieldCurveSnapshot> readYieldCurves() {
    _snapshot.getYieldCurves();
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public String[] getCurrentPath() {
    return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void close() {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public String getName() {
    _snapshot.getName();
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public String getBasisViewName() {
    _snapshot.getBasisViewName();
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }
}