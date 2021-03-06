// Copied from OATemplate project by OABuilder 06/20/21 11:44 AM
package com.viaoa.docbuilder.delegate;

import com.viaoa.docbuilder.model.*;
import com.viaoa.docbuilder.util.DataGenerator;
import com.viaoa.datasource.objectcache.OADataSourceObjectCache;
import com.viaoa.hub.Hub;
import com.viaoa.hub.HubEvent;
import com.viaoa.hub.HubListenerAdapter;
import com.viaoa.object.OAObject;
import com.viaoa.object.OAObjectCallbackDelegate;
import com.viaoa.object.OAThreadLocalDelegate;
import com.viaoa.util.*;

public class TestDelegate {

    private OADataSourceObjectCache ds;
    private DataGenerator dg;

    public void createSampleData(String xx) {
        if (dg == null) {
            ds = new OADataSourceObjectCache();
            ds.setAssignIdOnCreate(true);
            dg = new DataGenerator();
            try {
                OAObjectCallbackDelegate.demoAllowAllToPass(true);
                dg.createSamples();
            }
            finally {
                OAObjectCallbackDelegate.demoAllowAllToPass(false);
            }
        }
    }
}



