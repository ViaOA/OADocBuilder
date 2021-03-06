// Generated by OABuilder
package com.viaoa.docbuilder.model.oa.propertypath;
 
import java.io.Serializable;
import com.viaoa.docbuilder.model.oa.*;
 
public class SectionPPx implements PPxInterface, Serializable {
    private static final long serialVersionUID = 1L;
    public final String pp;  // propertyPath
     
    public SectionPPx(String name) {
        this(null, name);
    }

    public SectionPPx(PPxInterface parent, String name) {
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
        PagePPx ppx = new PagePPx(this, Section.P_Page);
        return ppx;
    }

    public SectionPPx parentSection() {
        SectionPPx ppx = new SectionPPx(this, Section.P_ParentSection);
        return ppx;
    }

    public SectionPPx sections() {
        SectionPPx ppx = new SectionPPx(this, Section.P_Sections);
        return ppx;
    }

    public TutorialPPx tutorial() {
        TutorialPPx ppx = new TutorialPPx(this, Section.P_Tutorial);
        return ppx;
    }

    public String id() {
        return pp + "." + Section.P_Id;
    }

    public String created() {
        return pp + "." + Section.P_Created;
    }

    public String seq() {
        return pp + "." + Section.P_Seq;
    }

    public String name() {
        return pp + "." + Section.P_Name;
    }

    @Override
    public String toString() {
        return pp;
    }
    public String pp() {
        return pp;
    }
}
 
