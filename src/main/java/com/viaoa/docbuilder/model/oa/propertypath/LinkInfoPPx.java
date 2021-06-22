// Generated by OABuilder
package com.viaoa.docbuilder.model.oa.propertypath;
 
import java.io.Serializable;
import com.viaoa.docbuilder.model.oa.*;
 
public class LinkInfoPPx implements PPxInterface, Serializable {
    private static final long serialVersionUID = 1L;
    public final String pp;  // propertyPath
     
    public LinkInfoPPx(String name) {
        this(null, name);
    }

    public LinkInfoPPx(PPxInterface parent, String name) {
        String s = null;
        if (parent != null) {
            s = parent.toString();
        }
        if (s == null) s = "";
        if (name != null && name.length() > 0) {
            if (s.length() > 0 && name.charAt(0) != ':') s += ".";
            s += name;
        }
        pp = s;
    }

    public PagePPx page() {
        PagePPx ppx = new PagePPx(this, LinkInfo.P_Page);
        return ppx;
    }

    public String id() {
        return pp + "." + LinkInfo.P_Id;
    }

    public String created() {
        return pp + "." + LinkInfo.P_Created;
    }

    public String name() {
        return pp + "." + LinkInfo.P_Name;
    }

    public String description() {
        return pp + "." + LinkInfo.P_Description;
    }

    public String link() {
        return pp + "." + LinkInfo.P_Link;
    }

    @Override
    public String toString() {
        return pp;
    }
    public String pp() {
        return pp;
    }
}
 
