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

public class PackageInfoSearchModel {
    private static Logger LOG = Logger.getLogger(PackageInfoSearchModel.class.getName());
    
    protected Hub<PackageInfo> hub;  // search results
    protected Hub<PackageInfo> hubMultiSelect;
    protected Hub<PackageInfo> hubSearchFrom;  // hub (optional) to search from
    protected Hub<PackageInfoSearch> hubPackageInfoSearch;  // search data, size=1, AO
    
    // finder used to find objects in a path
    protected OAFinder<?, PackageInfo> finder;
    
    // object used for search data
    protected PackageInfoSearch packageInfoSearch;
    
    public PackageInfoSearchModel() {
    }
    
    public PackageInfoSearchModel(Hub<PackageInfo> hub) {
        this.hub = hub;
    }
    
    // hub used for search results
    public Hub<PackageInfo> getHub() {
        if (hub == null) {
            hub = new Hub<PackageInfo>(PackageInfo.class);
        }
        return hub;
    }
    
    // hub used to search within
    private HubListener hlSearchFromHub;
    public Hub<PackageInfo> getSearchFromHub() {
        return hubSearchFrom;
    }
    public void setSearchFromHub(Hub<PackageInfo> hub) {
        if (this.hlSearchFromHub != null) {
            hubSearchFrom.removeListener(hlSearchFromHub);
            hlSearchFromHub = null;
        }
    
        hubSearchFrom = hub;
        if (hubSearchFrom != null) {
            hlSearchFromHub = new HubListenerAdapter() {
                @Override
                public void onNewList(HubEvent e) {
                    PackageInfoSearchModel.this.getHub().clear();
                }
            };
            hubSearchFrom.addHubListener(hlSearchFromHub);
        }
    }
    public void close() {
        setSearchFromHub(null);
    }
    
    public Hub<PackageInfo> getMultiSelectHub() {
        if (hubMultiSelect == null) {
            hubMultiSelect = new Hub<>(PackageInfo.class);
        }
        return hubMultiSelect;
    }
    
    public OAFinder<?, PackageInfo> getFinder() {
        return finder;
    }
    public void setFinder(OAFinder<?, PackageInfo> finder) {
        this.finder = finder;
    }
    
    // object used to input query data, to be used by searchHub
    public PackageInfoSearch getPackageInfoSearch() {
        if (packageInfoSearch != null) return packageInfoSearch;
        packageInfoSearch = new PackageInfoSearch();
        return packageInfoSearch;
    }
    
    // hub for search object - used to bind with UI components for entering search data
    public Hub<PackageInfoSearch> getPackageInfoSearchHub() {
        if (hubPackageInfoSearch == null) {
            hubPackageInfoSearch = new Hub<PackageInfoSearch>(PackageInfoSearch.class);
            hubPackageInfoSearch.add(getPackageInfoSearch());
            hubPackageInfoSearch.setPos(0);
        }
        return hubPackageInfoSearch;
    }
    
    
    
    public void beforeInput() {
        // hook that is called before search input starts
    }
    
    // uses PackageInfoSearch to build query, and populate Hub 
    public void performSearch() {
        OASelect<PackageInfo> sel = getPackageInfoSearch().getSelect();
        sel.setSearchHub(getSearchFromHub());
        sel.setFinder(getFinder());
        getHub().select(sel);
    }
    
    // can to overwritten to know when a selection is made
    public void onSelect(PackageInfo packageInfo, Hub<PackageInfo> hub) {
    }
    // can to overwritten to know when a multi-select is made
    public void onSelect(Hub<PackageInfo> hub) {
    }
}

