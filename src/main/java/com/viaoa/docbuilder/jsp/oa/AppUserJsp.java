// Copied from OATemplate project by OABuilder 06/20/21 11:44 AM
package com.viaoa.docbuilder.jsp.oa;

import com.viaoa.docbuilder.model.AppUserModel;
import com.viaoa.docbuilder.model.oa.AppUser;
import com.viaoa.hub.Hub;
import com.viaoa.jsp.*;

public class AppUserJsp extends AppUserJspBase {

    public AppUserJsp(Hub<AppUser> hub, OAForm form) {
        this(new AppUserModel(hub), form, "");
    }    
    public AppUserJsp(AppUserModel model, OAForm form) {
        this(model, form, "");
    }
    public AppUserJsp(Hub<AppUser> hub, OAForm form, String idPrefix) {
        this(new AppUserModel(hub), form, idPrefix);
    }    
    public AppUserJsp(AppUserModel model, OAForm form, String idPrefix) {
        super(model, form, idPrefix);
    }
}
