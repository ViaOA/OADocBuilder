// Generated by OABuilder
package com.viaoa.docbuilder.model.oa.propertypath;
 
import com.viaoa.docbuilder.model.oa.*;
 
public class LinkInfoPP {
    private static PagePPx page;
     

    public static PagePPx page() {
        if (page == null) page = new PagePPx(LinkInfo.P_Page);
        return page;
    }

    public static String id() {
        String s = LinkInfo.P_Id;
        return s;
    }

    public static String created() {
        String s = LinkInfo.P_Created;
        return s;
    }

    public static String name() {
        String s = LinkInfo.P_Name;
        return s;
    }

    public static String description() {
        String s = LinkInfo.P_Description;
        return s;
    }

    public static String link() {
        String s = LinkInfo.P_Link;
        return s;
    }

    public static String pp() {
        return ""; // this
    }
}
 
