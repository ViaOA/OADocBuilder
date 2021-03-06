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
@XmlRootElement(name = "codeSearch")
@XmlType(factoryMethod = "jaxbCreate")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CodeSearch extends OAObject {
    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(CodeSearch.class.getName());
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

    public static CodeSearch jaxbCreate() {
        CodeSearch codeSearch = (CodeSearch) OAObject.jaxbCreateInstance(CodeSearch.class);
        if (codeSearch == null) codeSearch = new CodeSearch();
        return codeSearch;
    }

    public void reset() {
    }

    public boolean isDataEntered() {
        return false;
    }

    protected String extraWhere;
    protected Object[] extraWhereParams;
    protected OAFilter<Code> filterExtraWhere;

    public void setExtraWhere(String s, Object ... args) {
        this.extraWhere = s;
        this.extraWhereParams = args;
        if (OAString.isNotEmpty(s) && getExtraWhereFilter() == null) {
            OAFilter<Code> f = new OAQueryFilter<Code>(Code.class, s, args);
            setExtraWhereFilter(f);
        }
    }
    public void setExtraWhereFilter(OAFilter<Code> filter) {
        this.filterExtraWhere = filter;
    }
    public OAFilter<Code> getExtraWhereFilter() {
        return this.filterExtraWhere;
    }

    public OASelect<Code> getSelect() {
        final String prefix = "";
        String sql = "";
        String sortOrder = null;
        Object[] args = new Object[0];

        if (OAString.isNotEmpty(extraWhere)) {
            if (sql.length() > 0) sql = "(" + sql + ") AND ";
            sql += extraWhere;
            args = OAArray.add(Object.class, args, extraWhereParams);
        }

        OASelect<Code> select = new OASelect<Code>(Code.class, sql, args, sortOrder);
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

    private OAFilter<Code> filterDataSourceFilter;
    public OAFilter<Code> getDataSourceFilter() {
        if (filterDataSourceFilter != null) return filterDataSourceFilter;
        filterDataSourceFilter = new OAFilter<Code>() {
            @Override
            public boolean isUsed(Code code) {
                return CodeSearch.this.isUsedForDataSourceFilter(code);
            }
        };
        return filterDataSourceFilter;
    }
    
    private OAFilter<Code> filterCustomFilter;
    public OAFilter<Code> getCustomFilter() {
        if (filterCustomFilter != null) return filterCustomFilter;
        filterCustomFilter = new OAFilter<Code>() {
            @Override
            public boolean isUsed(Code code) {
                boolean b = CodeSearch.this.isUsedForCustomFilter(code);
                return b;
            }
        };
        return filterCustomFilter;
    }
    
    public boolean isUsedForDataSourceFilter(Code searchCode) {
        return true;
    }
    public boolean isUsedForCustomFilter(Code searchCode) {
        return true;
    }
}
