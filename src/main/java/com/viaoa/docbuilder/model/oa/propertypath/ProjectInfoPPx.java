// Generated by OABuilder
package com.viaoa.docbuilder.model.oa.propertypath;
 
import java.io.Serializable;
import com.viaoa.docbuilder.model.oa.*;
 
public class ProjectInfoPPx implements PPxInterface, Serializable {
    private static final long serialVersionUID = 1L;
    public final String pp;  // propertyPath
     
    public ProjectInfoPPx(String name) {
        this(null, name);
    }

    public ProjectInfoPPx(PPxInterface parent, String name) {
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

    public PackageInfoPPx packageInfos() {
        PackageInfoPPx ppx = new PackageInfoPPx(this, ProjectInfo.P_PackageInfos);
        return ppx;
    }

    public PagePPx page() {
        PagePPx ppx = new PagePPx(this, ProjectInfo.P_Page);
        return ppx;
    }

    public String id() {
        return pp + "." + ProjectInfo.P_Id;
    }

    public String created() {
        return pp + "." + ProjectInfo.P_Created;
    }

    public String name() {
        return pp + "." + ProjectInfo.P_Name;
    }

    public String directory() {
        return pp + "." + ProjectInfo.P_Directory;
    }

    public String console() {
        return pp + "." + ProjectInfo.P_Console;
    }

    public String loadClasses() {
        return pp + ".loadClasses";
    }

    @Override
    public String toString() {
        return pp;
    }
    public String pp() {
        return pp;
    }
}
 
