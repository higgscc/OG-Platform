/**
 * Copyright (C) 2009 - 2009 by OpenGamma Inc.
 *
 * Please see distribution for license.
 */
package com.opengamma.livedata.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.opengamma.id.DomainSpecificIdentifier;
import com.opengamma.id.IdentificationDomain;
import com.opengamma.livedata.CollectingLiveDataListener;
import com.opengamma.livedata.LiveDataSpecification;
import com.opengamma.livedata.LiveDataSpecificationImpl;

/**
 * 
 *
 * @author kirk
 */
public class ValueDistributorTest {
  
  @Test
  public void activeSpecificationsOneSpec() {
    ValueDistributor distributor = new ValueDistributor();
    Set<LiveDataSpecification> activeSpecs = null;
    
    CollectingLiveDataListener listener1 = new CollectingLiveDataListener();
    CollectingLiveDataListener listener2 = new CollectingLiveDataListener();
    LiveDataSpecification spec = new LiveDataSpecificationImpl(new DomainSpecificIdentifier(new IdentificationDomain("foo"), "bar"));
    
    distributor.addListener(spec, listener1);
    activeSpecs = distributor.getActiveSpecifications();
    assertNotNull(activeSpecs);
    assertEquals(1, activeSpecs.size());
    assertTrue(activeSpecs.contains(spec));

    distributor.addListener(spec, listener2);
    activeSpecs = distributor.getActiveSpecifications();
    assertNotNull(activeSpecs);
    assertEquals(1, activeSpecs.size());
    assertTrue(activeSpecs.contains(spec));
    
    distributor.removeListener(spec, listener1);
    activeSpecs = distributor.getActiveSpecifications();
    assertNotNull(activeSpecs);
    assertEquals(1, activeSpecs.size());
    assertTrue(activeSpecs.contains(spec));

    distributor.removeListener(spec, listener2);
    activeSpecs = distributor.getActiveSpecifications();
    assertNotNull(activeSpecs);
    assertTrue(activeSpecs.isEmpty());
  }

  @Test
  public void activeSpecificationsTwoSpecs() {
    ValueDistributor distributor = new ValueDistributor();
    Set<LiveDataSpecification> activeSpecs = null;
    
    CollectingLiveDataListener listener1 = new CollectingLiveDataListener();
    LiveDataSpecification spec1 = new LiveDataSpecificationImpl(new DomainSpecificIdentifier(new IdentificationDomain("foo"), "bar1"));
    LiveDataSpecification spec2 = new LiveDataSpecificationImpl(new DomainSpecificIdentifier(new IdentificationDomain("foo"), "bar2"));
    
    distributor.addListener(spec1, listener1);
    activeSpecs = distributor.getActiveSpecifications();
    assertNotNull(activeSpecs);
    assertEquals(1, activeSpecs.size());
    assertTrue(activeSpecs.contains(spec1));

    distributor.addListener(spec2, listener1);
    activeSpecs = distributor.getActiveSpecifications();
    assertNotNull(activeSpecs);
    assertEquals(2, activeSpecs.size());
    assertTrue(activeSpecs.contains(spec1));
    assertTrue(activeSpecs.contains(spec2));
  }

}
