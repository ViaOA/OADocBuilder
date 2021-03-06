// Generated by OABuilder
package com.viaoa.docbuilder.model.oa.search;

import javax.xml.bind.annotation.*;
import java.util.logging.*;
import com.viaoa.docbuilder.model.oa.*;
import com.viaoa.docbuilder.model.oa.propertypath.*;
import com.viaoa.annotation.*;
import com.viaoa.object.*;
import com.viaoa.hub.*;
import com.viaoa.util.*;
import com.viaoa.datasource.*;
import com.viaoa.filter.*;

@OAClass(useDataSource=false, localOnly=true)
@XmlRootElement(name = "pageSearch")
@XmlType(factoryMethod = "jaxbCreate")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PageSearch extends OAObject {
    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(PageSearch.class.getName());
    public static final String P_MaxResults = "MaxResults";

    protected int maxResults;

    public int getMaxResults() {
        return maxResults;
    }
    public void setMaxResults(int newValue) {
        fireBeforePropertyChange(P_MaxResults, this.maxResults, newValue);
        int old = maxResults;
        this.maxResults = newValue;
        firePropertyChange(P_MaxResults, old, this.maxResults);
    }

    public static PageSearch jaxbCreate() {
        PageSearch pageSearch = (PageSearch) OAObject.jaxbCreateInstance(PageSearch.class);
        if (pageSearch == null) pageSearch = new PageSearch();
        return pageSearch;
    }

    public void reset() {
    }

    public boolean isDataEntered() {
        return false;
    }

    protected String extraWhere;
    protected Object[] extraWhereParams;
    protected OAFilter<Page> filterExtraWhere;

    public void setExtraWhere(String s, Object ... args) {
        this.extraWhere = s;
        this.extraWhereParams = args;
        if (OAString.isNotEmpty(s) && getExtraWhereFilter() == null) {
            OAFilter<Page> f = new OAQueryFilter<Page>(Page.class, s, args);
            setExtraWhereFilter(f);
        }
    }
    public void setExtraWhereFilter(OAFilter<Page> filter) {
        this.filterExtraWhere = filter;
    }
    public OAFilter<Page> getExtraWhereFilter() {
        return this.filterExtraWhere;
    }

    public OASelect<Page> getSelect() {
        final String prefix = "";
        String sql = "";
        String sortOrder = null;
        Object[] args = new Object[0];

        if (OAString.isNotEmpty(extraWhere)) {
            if (sql.length() > 0) sql = "(" + sql + ") AND ";
            sql += extraWhere;
            args = OAArray.add(Object.class, args, extraWhereParams);
        }

        OASelect<Page> select = new OASelect<Page>(Page.class, sql, args, sortOrder);
        if (getExtraWhereFilter() != null && getExtraWhereFilter().updateSelect(select)) {
            select.setFilter(new OAAndFilter(this.getCustomFilter(), getExtraWhereFilter()));
        }
        else select.setFilter(this.getCustomFilter());
        select.setDataSourceFilter(this.getDataSourceFilter());
        if (getMaxResults() > 0) select.setMax(getMaxResults());
        return select;
    }

    public void appendSelect(final String fromName, final OASelect select) {
        final String prefix = fromName + ".";
        String sql = "";
        Object[] args = new Object[0];
        select.add(sql, args);
    }

    private OAFilter<Page> filterDataSourceFilter;
    public OAFilter<Page> getDataSourceFilter() {
        if (filterDataSourceFilter != null) return filterDataSourceFilter;
        filterDataSourceFilter = new OAFilter<Page>() {
            @Override
            public boolean isUsed(Page page) {
                return PageSearch.this.isUsedForDataSourceFilter(page);
            }
        };
        return filterDataSourceFilter;
    }
    
    private OAFilter<Page> filterCustomFilter;
    public OAFilter<Page> getCustomFilter() {
        if (filterCustomFilter != null) return filterCustomFilter;
        filterCustomFilter = new OAFilter<Page>() {
            @Override
            public boolean isUsed(Page page) {
                boolean b = PageSearch.this.isUsedForCustomFilter(page);
                return b;
            }
        };
        return filterCustomFilter;
    }
    
    public boolean isUsedForDataSourceFilter(Page searchPage) {
        return true;
    }
    public boolean isUsedForCustomFilter(Page searchPage) {
        return true;
    }
}
