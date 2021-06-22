// Generated by OABuilder
package com.viaoa.docbuilder.model.filter;

import java.util.logging.*;

import com.viaoa.object.*;
import com.viaoa.annotation.*;
import com.viaoa.hub.*;
import com.viaoa.util.*;
import com.viaoa.datasource.*;

import com.viaoa.docbuilder.model.*;
import com.viaoa.docbuilder.model.oa.*;
import com.viaoa.docbuilder.model.oa.propertypath.*;
import com.viaoa.docbuilder.model.oa.filter.*;
import com.viaoa.docbuilder.model.search.*;
import com.viaoa.docbuilder.delegate.ModelDelegate;
import com.viaoa.docbuilder.resource.Resource;

public class AppUserLoginLastDayFilterModel {
    private static Logger LOG = Logger.getLogger(AppUserLoginLastDayFilterModel.class.getName());
    
    // Hubs
    protected Hub<AppUserLoginLastDayFilter> hubFilter;
    
    // ObjectModels
    
    // object used for filter data
    protected AppUserLoginLastDayFilter filter;
    
    public AppUserLoginLastDayFilterModel(Hub<AppUserLogin> hubMaster, Hub<AppUserLogin> hub) {
        filter = new AppUserLoginLastDayFilter(hubMaster, hub);
    }
    public AppUserLoginLastDayFilterModel(Hub<AppUserLogin> hub) {
        filter = new AppUserLoginLastDayFilter(hub);
    }
    
    // object used to input query data, to be used by filterHub
    public AppUserLoginLastDayFilter getFilter() {
        return filter;
    }
    
    // hub for filter UI object - used to bind with UI components for entering filter data
    public Hub<AppUserLoginLastDayFilter> getFilterHub() {
        if (hubFilter == null) {
            hubFilter = new Hub<AppUserLoginLastDayFilter>(AppUserLoginLastDayFilter.class);
            hubFilter.add(getFilter());
            hubFilter.setPos(0);
        }
        return hubFilter;
    }
    
    
    
    // get the Filtered hub
    public Hub<AppUserLogin> getHub() {
        return getFilter().getHubFilter().getHub();
    }
}
