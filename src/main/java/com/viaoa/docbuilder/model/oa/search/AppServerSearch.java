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
@XmlRootElement(name = "appServerSearch")
@XmlType(factoryMethod = "jaxbCreate")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class AppServerSearch extends OAObject {
    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AppServerSearch.class.getName());
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

    public static AppServerSearch jaxbCreate() {
        AppServerSearch appServerSearch = (AppServerSearch) OAObject.jaxbCreateInstance(AppServerSearch.class);
        if (appServerSearch == null) appServerSearch = new AppServerSearch();
        return appServerSearch;
    }

    public void reset() {
    }

    public boolean isDataEntered() {
        return false;
    }

    protected String extraWhere;
    protected Object[] extraWhereParams;
    protected OAFilter<AppServer> filterExtraWhere;

    public void setExtraWhere(String s, Object ... args) {
        this.extraWhere = s;
        this.extraWhereParams = args;
        if (OAString.isNotEmpty(s) && getExtraWhereFilter() == null) {
            OAFilter<AppServer> f = new OAQueryFilter<AppServer>(AppServer.class, s, args);
            setExtraWhereFilter(f);
        }
    }
    public void setExtraWhereFilter(OAFilter<AppServer> filter) {
        this.filterExtraWhere = filter;
    }
    public OAFilter<AppServer> getExtraWhereFilter() {
        return this.filterExtraWhere;
    }

    public OASelect<AppServer> getSelect() {
        final String prefix = "";
        String sql = "";
        String sortOrder = null;
        Object[] args = new Object[0];

        if (OAString.isNotEmpty(extraWhere)) {
            if (sql.length() > 0) sql = "(" + sql + ") AND ";
            sql += extraWhere;
            args = OAArray.add(Object.class, args, extraWhereParams);
        }

        OASelect<AppServer> select = new OASelect<AppServer>(AppServer.class, sql, args, sortOrder);
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

    private OAFilter<AppServer> filterDataSourceFilter;
    public OAFilter<AppServer> getDataSourceFilter() {
        if (filterDataSourceFilter != null) return filterDataSourceFilter;
        filterDataSourceFilter = new OAFilter<AppServer>() {
            @Override
            public boolean isUsed(AppServer appServer) {
                return AppServerSearch.this.isUsedForDataSourceFilter(appServer);
            }
        };
        return filterDataSourceFilter;
    }
    
    private OAFilter<AppServer> filterCustomFilter;
    public OAFilter<AppServer> getCustomFilter() {
        if (filterCustomFilter != null) return filterCustomFilter;
        filterCustomFilter = new OAFilter<AppServer>() {
            @Override
            public boolean isUsed(AppServer appServer) {
                boolean b = AppServerSearch.this.isUsedForCustomFilter(appServer);
                return b;
            }
        };
        return filterCustomFilter;
    }
    
    public boolean isUsedForDataSourceFilter(AppServer searchAppServer) {
        return true;
    }
    public boolean isUsedForCustomFilter(AppServer searchAppServer) {
        return true;
    }
}
