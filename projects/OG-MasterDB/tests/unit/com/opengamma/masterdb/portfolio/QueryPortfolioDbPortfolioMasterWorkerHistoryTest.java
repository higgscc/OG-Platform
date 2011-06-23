/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.masterdb.portfolio;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.opengamma.id.UniqueIdentifier;
import com.opengamma.master.portfolio.PortfolioHistoryRequest;
import com.opengamma.master.portfolio.PortfolioHistoryResult;
import com.opengamma.util.db.PagingRequest;
import com.opengamma.util.test.DBTest;

/**
 * Tests QueryPortfolioDbPortfolioMasterWorker.
 */
public class QueryPortfolioDbPortfolioMasterWorkerHistoryTest extends AbstractDbPortfolioMasterWorkerTest {
  // superclass sets up dummy database

  private static final Logger s_logger = LoggerFactory.getLogger(QueryPortfolioDbPortfolioMasterWorkerHistoryTest.class);

  @Factory(dataProvider = "databases", dataProviderClass = DBTest.class)
  public QueryPortfolioDbPortfolioMasterWorkerHistoryTest(String databaseType, String databaseVersion) {
    super(databaseType, databaseVersion);
    s_logger.info("running testcases for {}", databaseType);
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }

  //-------------------------------------------------------------------------
  @Test
  public void test_history_documents_noInstants_node_depthZero() {
    UniqueIdentifier oid = UniqueIdentifier.of("DbPrt", "201");
    PortfolioHistoryRequest request = new PortfolioHistoryRequest(oid);
    PortfolioHistoryResult test = _prtMaster.history(request);
    
    assertEquals(2, test.getDocuments().size());
    assert202(test.getDocuments().get(0));
    assert201(test.getDocuments().get(1));
  }

  @Test
  public void test_history_documents_noInstants_node_depthOne() {
    UniqueIdentifier oid = UniqueIdentifier.of("DbPrt", "101");
    PortfolioHistoryRequest request = new PortfolioHistoryRequest(oid);
    request.setDepth(1);
    PortfolioHistoryResult test = _prtMaster.history(request);
    assert101(test.getDocuments().get(0), 1);
  }

  @Test
  public void test_history_documents_noInstants_node_maxDepth() {
    UniqueIdentifier oid = UniqueIdentifier.of("DbPrt", "101");
    PortfolioHistoryRequest request = new PortfolioHistoryRequest(oid);
    request.setDepth(-1);
    PortfolioHistoryResult test = _prtMaster.history(request);
    assert101(test.getDocuments().get(0), 999);
  }

  //-------------------------------------------------------------------------
  @Test
  public void test_history_noInstants() {
    UniqueIdentifier oid = UniqueIdentifier.of("DbPrt", "201");
    PortfolioHistoryRequest request = new PortfolioHistoryRequest(oid);
    PortfolioHistoryResult test = _prtMaster.history(request);
    
    assertEquals(1, test.getPaging().getFirstItem());
    assertEquals(Integer.MAX_VALUE, test.getPaging().getPagingSize());
    assertEquals(2, test.getPaging().getTotalItems());
    
    assertEquals(2, test.getDocuments().size());
    assert202(test.getDocuments().get(0));
    assert201(test.getDocuments().get(1));
  }

  //-------------------------------------------------------------------------
  @Test
  public void test_history_noInstants_pageOne() {
    UniqueIdentifier oid = UniqueIdentifier.of("DbPrt", "201");
    PortfolioHistoryRequest request = new PortfolioHistoryRequest(oid);
    request.setPagingRequest(PagingRequest.of(1, 1));
    PortfolioHistoryResult test = _prtMaster.history(request);
    
    assertEquals(1, test.getPaging().getFirstItem());
    assertEquals(1, test.getPaging().getPagingSize());
    assertEquals(2, test.getPaging().getTotalItems());
    
    assertEquals(1, test.getDocuments().size());
    assert202(test.getDocuments().get(0));
  }

  @Test
  public void test_history_noInstants_pageTwo() {
    UniqueIdentifier oid = UniqueIdentifier.of("DbPrt", "201");
    PortfolioHistoryRequest request = new PortfolioHistoryRequest(oid);
    request.setPagingRequest(PagingRequest.of(2, 1));
    PortfolioHistoryResult test = _prtMaster.history(request);
    
    assertNotNull(test);
    assertNotNull(test.getPaging());
    assertEquals(2, test.getPaging().getFirstItem());
    assertEquals(1, test.getPaging().getPagingSize());
    assertEquals(2, test.getPaging().getTotalItems());
    
    assertNotNull(test.getDocuments());
    assertEquals(1, test.getDocuments().size());
    assert201(test.getDocuments().get(0));
  }

  //-------------------------------------------------------------------------
  @Test
  public void test_history_versionsFrom_preFirst() {
    UniqueIdentifier oid = UniqueIdentifier.of("DbPrt", "201");
    PortfolioHistoryRequest request = new PortfolioHistoryRequest(oid);
    request.setVersionsFromInstant(_version1Instant.minusSeconds(5));
    PortfolioHistoryResult test = _prtMaster.history(request);
    
    assertEquals(2, test.getPaging().getTotalItems());
    
    assertEquals(2, test.getDocuments().size());
    assert202(test.getDocuments().get(0));
    assert201(test.getDocuments().get(1));
  }

  @Test
  public void test_history_versionsFrom_firstToSecond() {
    UniqueIdentifier oid = UniqueIdentifier.of("DbPrt", "201");
    PortfolioHistoryRequest request = new PortfolioHistoryRequest(oid);
    request.setVersionsFromInstant(_version1Instant.plusSeconds(5));
    PortfolioHistoryResult test = _prtMaster.history(request);
    
    assertEquals(2, test.getPaging().getTotalItems());
    
    assertEquals(2, test.getDocuments().size());
    assert202(test.getDocuments().get(0));
    assert201(test.getDocuments().get(1));
  }

  @Test
  public void test_history_versionsFrom_postSecond() {
    UniqueIdentifier oid = UniqueIdentifier.of("DbPrt", "201");
    PortfolioHistoryRequest request = new PortfolioHistoryRequest(oid);
    request.setVersionsFromInstant(_version2Instant.plusSeconds(5));
    PortfolioHistoryResult test = _prtMaster.history(request);
    
    assertEquals(1, test.getPaging().getTotalItems());
    
    assertEquals(1, test.getDocuments().size());
    assert202(test.getDocuments().get(0));
  }

  //-------------------------------------------------------------------------
  @Test
  public void test_history_versionsTo_preFirst() {
    UniqueIdentifier oid = UniqueIdentifier.of("DbPrt", "201");
    PortfolioHistoryRequest request = new PortfolioHistoryRequest(oid);
    request.setVersionsToInstant(_version1Instant.minusSeconds(5));
    PortfolioHistoryResult test = _prtMaster.history(request);
    
    assertEquals(0, test.getPaging().getTotalItems());
    
    assertEquals(0, test.getDocuments().size());
  }

  @Test
  public void test_history_versionsTo_firstToSecond() {
    UniqueIdentifier oid = UniqueIdentifier.of("DbPrt", "201");
    PortfolioHistoryRequest request = new PortfolioHistoryRequest(oid);
    request.setVersionsToInstant(_version1Instant.plusSeconds(5));
    PortfolioHistoryResult test = _prtMaster.history(request);
    
    assertEquals(1, test.getPaging().getTotalItems());
    
    assertEquals(1, test.getDocuments().size());
    assert201(test.getDocuments().get(0));
  }

  @Test
  public void test_history_versionsTo_postSecond() {
    UniqueIdentifier oid = UniqueIdentifier.of("DbPrt", "201");
    PortfolioHistoryRequest request = new PortfolioHistoryRequest(oid);
    request.setVersionsToInstant(_version2Instant.plusSeconds(5));
    PortfolioHistoryResult test = _prtMaster.history(request);
    
    assertEquals(2, test.getPaging().getTotalItems());
    
    assertEquals(2, test.getDocuments().size());
    assert202(test.getDocuments().get(0));
    assert201(test.getDocuments().get(1));
  }

  //-------------------------------------------------------------------------
  @Test
  public void test_toString() {
    assertEquals(_prtMaster.getClass().getSimpleName() + "[DbPrt]", _prtMaster.toString());
  }

}
