// Generated by OABuilder
package com.viaoa.docbuilder.model.search;

import java.util.logging.*;

import com.viaoa.object.*;
import com.viaoa.hub.*;
import com.viaoa.util.*;
import com.viaoa.filter.*;
import com.viaoa.datasource.*;

import com.viaoa.docbuilder.model.*;
import com.viaoa.docbuilder.model.oa.*;
import com.viaoa.docbuilder.model.oa.propertypath.*;
import com.viaoa.docbuilder.model.oa.search.*;
import com.viaoa.docbuilder.model.oa.filter.*;
import com.viaoa.docbuilder.delegate.ModelDelegate;
import com.viaoa.docbuilder.resource.Resource;

public class ClassInfoSearchModel {
    private static Logger LOG = Logger.getLogger(ClassInfoSearchModel.class.getName());
    
    protected Hub<ClassInfo> hub;  // search results
    protected Hub<ClassInfo> hubMultiSelect;
    protected Hub<ClassInfo> hubSearchFrom;  // hub (optional) to search from
    protected Hub<ClassInfoSearch> hubClassInfoSearch;  // search data, size=1, AO
    
    // finder used to find objects in a path
    protected OAFinder<?, ClassInfo> finder;
    
    // object used for search data
    protected ClassInfoSearch classInfoSearch;
    
    public ClassInfoSearchModel() {
    }
    
    public ClassInfoSearchModel(Hub<ClassInfo> hub) {
        this.hub = hub;
    }
    
    // hub used for search results
    public Hub<ClassInfo> getHub() {
        if (hub == null) {
            hub = new Hub<ClassInfo>(ClassInfo.class);
        }
        return hub;
    }
    
    // hub used to search within
    private HubListener hlSearchFromHub;
    public Hub<ClassInfo> getSearchFromHub() {
        return hubSearchFrom;
    }
    public void setSearchFromHub(Hub<ClassInfo> hub) {
        if (this.hlSearchFromHub != null) {
            hubSearchFrom.removeListener(hlSearchFromHub);
            hlSearchFromHub = null;
        }
    
        hubSearchFrom = hub;
        if (hubSearchFrom != null) {
            hlSearchFromHub = new HubListenerAdapter() {
                @Override
                public void onNewList(HubEvent e) {
                    ClassInfoSearchModel.this.getHub().clear();
                }
            };
            hubSearchFrom.addHubListener(hlSearchFromHub);
        }
    }
    public void close() {
        setSearchFromHub(null);
    }
    
    public Hub<ClassInfo> getMultiSelectHub() {
        if (hubMultiSelect == null) {
            hubMultiSelect = new Hub<>(ClassInfo.class);
        }
        return hubMultiSelect;
    }
    
    public OAFinder<?, ClassInfo> getFinder() {
        return finder;
    }
    public void setFinder(OAFinder<?, ClassInfo> finder) {
        this.finder = finder;
    }
    
    // object used to input query data, to be used by searchHub
    public ClassInfoSearch getClassInfoSearch() {
        if (classInfoSearch != null) return classInfoSearch;
        classInfoSearch = new ClassInfoSearch();
        return classInfoSearch;
    }
    
    // hub for search object - used to bind with UI components for entering search data
    public Hub<ClassInfoSearch> getClassInfoSearchHub() {
        if (hubClassInfoSearch == null) {
            hubClassInfoSearch = new Hub<ClassInfoSearch>(ClassInfoSearch.class);
            hubClassInfoSearch.add(getClassInfoSearch());
            hubClassInfoSearch.setPos(0);
        }
        return hubClassInfoSearch;
    }
    
    
    
    public void beforeInput() {
        // hook that is called before search input starts
    }
    
    // uses ClassInfoSearch to build query, and populate Hub 
    public void performSearch() {
        OASelect<ClassInfo> sel = getClassInfoSearch().getSelect();
        sel.setSearchHub(getSearchFromHub());
        sel.setFinder(getFinder());
        getHub().select(sel);
    }
    
    // can to overwritten to know when a selection is made
    public void onSelect(ClassInfo classInfo, Hub<ClassInfo> hub) {
    }
    // can to overwritten to know when a multi-select is made
    public void onSelect(Hub<ClassInfo> hub) {
    }
}

