// Generated by OABuilder

package com.viaoa.docbuilder.model;

import java.util.logging.*;
import com.viaoa.object.*;
import com.viaoa.annotation.*;
import com.viaoa.hub.*;
import com.viaoa.util.*;
import com.viaoa.filter.*;
import com.viaoa.datasource.*;

import com.viaoa.docbuilder.model.oa.*;
import com.viaoa.docbuilder.model.oa.propertypath.*;
import com.viaoa.docbuilder.model.oa.search.*;
import com.viaoa.docbuilder.model.oa.filter.*;
import com.viaoa.docbuilder.model.search.*;
import com.viaoa.docbuilder.model.filter.*;
import com.viaoa.docbuilder.delegate.ModelDelegate;
import com.viaoa.docbuilder.resource.Resource;

public class CodeModel extends OAObjectModel {
    private static Logger LOG = Logger.getLogger(CodeModel.class.getName());
    
    // Hubs
    protected Hub<Code> hub;
    // selected codes
    protected Hub<Code> hubMultiSelect;
    // detail hubs
    protected Hub<Page> hubPage;
    
    // ObjectModels
    protected PageModel modelPage;
    
    // SearchModels used for references
    protected PageSearchModel modelPageSearch;
    
    public CodeModel() {
        setDisplayName("Code");
        setPluralDisplayName("Codes");
    }
    
    public CodeModel(Hub<Code> hubCode) {
        this();
        if (hubCode != null) HubDelegate.setObjectClass(hubCode, Code.class);
        this.hub = hubCode;
    }
    public CodeModel(Code code) {
        this();
        getHub().add(code);
        getHub().setPos(0);
    }
    
    public Hub<Code> getOriginalHub() {
        return getHub();
    }
    
    public Hub<Page> getPageHub() {
        if (hubPage != null) return hubPage;
        hubPage = getHub().getDetailHub(Code.P_Page);
        return hubPage;
    }
    public Code getCode() {
        return getHub().getAO();
    }
    
    public Hub<Code> getHub() {
        if (hub == null) {
            hub = new Hub<Code>(Code.class);
        }
        return hub;
    }
    
    public Hub<Code> getMultiSelectHub() {
        if (hubMultiSelect == null) {
            hubMultiSelect = new Hub<Code>(Code.class);
        }
        return hubMultiSelect;
    }
    
    public PageModel getPageModel() {
        if (modelPage != null) return modelPage;
        modelPage = new PageModel(getPageHub());
        modelPage.setDisplayName("Page");
        modelPage.setPluralDisplayName("Pages");
        modelPage.setForJfc(getForJfc());
        modelPage.setAllowNew(true);
        modelPage.setAllowSave(true);
        modelPage.setAllowAdd(false);
        modelPage.setAllowRemove(true);
        modelPage.setAllowClear(true);
        modelPage.setAllowDelete(false);
        modelPage.setAllowSearch(true);
        modelPage.setAllowHubSearch(false);
        modelPage.setAllowGotoEdit(true);
        modelPage.setViewOnly(getViewOnly());
        // call Code.pageModelCallback(PageModel) to be able to customize this model
        OAObjectCallbackDelegate.onObjectCallbackModel(Code.class, Code.P_Page, modelPage);
    
        return modelPage;
    }
    
    public PageSearchModel getPageSearchModel() {
        if (modelPageSearch != null) return modelPageSearch;
        modelPageSearch = new PageSearchModel();
        HubSelectDelegate.adoptWhereHub(modelPageSearch.getHub(), Code.P_Page, getHub());
        return modelPageSearch;
    }
    
    public HubCopy<Code> createHubCopy() {
        Hub<Code> hubCodex = new Hub<>(Code.class);
        HubCopy<Code> hc = new HubCopy<>(getHub(), hubCodex, true);
        return hc;
    }
    public CodeModel createCopy() {
        CodeModel mod = new CodeModel(createHubCopy().getHub());
        return mod;
    }
}
