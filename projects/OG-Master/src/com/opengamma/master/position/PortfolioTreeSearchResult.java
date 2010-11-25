/**
 * Copyright (C) 2009 - 2010 by OpenGamma Inc.
 *
 * Please see distribution for license.
 */
package com.opengamma.master.position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.joda.beans.BeanDefinition;
import org.joda.beans.MetaProperty;

import com.opengamma.master.AbstractSearchResult;

/**
 * Result from searching for portfolio trees.
 * <p>
 * The returned documents will match the search criteria.
 * See {@link PortfolioTreeSearchRequest} for more details.
 * <p>
 * This returns multiple instances of the tree excluding positions, which may be a large response.
 * The depth parameter in the request allows the size of the result to be controlled.
 */
@BeanDefinition
public class PortfolioTreeSearchResult extends AbstractSearchResult<PortfolioTreeDocument> {

  /**
   * Creates an instance.
   */
  public PortfolioTreeSearchResult() {
  }

  //-------------------------------------------------------------------------
  /**
   * Gets the returned portfolios from within the documents.
   * 
   * @return the portfolios, not null
   */
  public List<ManageablePortfolio> getPortfolios() {
    List<ManageablePortfolio> result = new ArrayList<ManageablePortfolio>();
    if (getDocuments() != null) {
      for (PortfolioTreeDocument doc : getDocuments()) {
        result.add(doc.getPortfolio());
      }
    }
    return result;
  }

  /**
   * Gets the first portfolio, or null if no documents.
   * 
   * @return the first portfolio, null if none
   */
  public ManageablePortfolio getFirstPortfolio() {
    return getDocuments().size() > 0 ? getDocuments().get(0).getPortfolio() : null;
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code PortfolioTreeSearchResult}.
   * @return the meta-bean, not null
   */
  @SuppressWarnings("unchecked")
  public static PortfolioTreeSearchResult.Meta meta() {
    return PortfolioTreeSearchResult.Meta.INSTANCE;
  }

  @Override
  public PortfolioTreeSearchResult.Meta metaBean() {
    return PortfolioTreeSearchResult.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(String propertyName) {
    switch (propertyName.hashCode()) {
    }
    return super.propertyGet(propertyName);
  }

  @Override
  protected void propertySet(String propertyName, Object newValue) {
    switch (propertyName.hashCode()) {
    }
    super.propertySet(propertyName, newValue);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code PortfolioTreeSearchResult}.
   */
  public static class Meta extends AbstractSearchResult.Meta<PortfolioTreeDocument> {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<Object>> _map;

    @SuppressWarnings({"unchecked", "rawtypes" })
    protected Meta() {
      LinkedHashMap temp = new LinkedHashMap(super.metaPropertyMap());
      _map = Collections.unmodifiableMap(temp);
    }

    @Override
    public PortfolioTreeSearchResult createBean() {
      return new PortfolioTreeSearchResult();
    }

    @Override
    public Class<? extends PortfolioTreeSearchResult> beanType() {
      return PortfolioTreeSearchResult.class;
    }

    @Override
    public Map<String, MetaProperty<Object>> metaPropertyMap() {
      return _map;
    }

    //-----------------------------------------------------------------------
  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
