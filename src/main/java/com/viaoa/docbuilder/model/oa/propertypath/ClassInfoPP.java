// Generated by OABuilder
package com.viaoa.docbuilder.model.oa.propertypath;
 
import com.viaoa.docbuilder.model.oa.*;
 
public class ClassInfoPP {
    private static PackageInfoPPx packageInfo;
    private static PagePPx page;
    private static PagePPx referencePages;
     

    public static PackageInfoPPx packageInfo() {
        if (packageInfo == null) packageInfo = new PackageInfoPPx(ClassInfo.P_PackageInfo);
        return packageInfo;
    }

    public static PagePPx page() {
        if (page == null) page = new PagePPx(ClassInfo.P_Page);
        return page;
    }

    public static PagePPx referencePages() {
        if (referencePages == null) referencePages = new PagePPx(ClassInfo.P_ReferencePages);
        return referencePages;
    }

    public static String id() {
        String s = ClassInfo.P_Id;
        return s;
    }

    public static String created() {
        String s = ClassInfo.P_Created;
        return s;
    }

    public static String name() {
        String s = ClassInfo.P_Name;
        return s;
    }

    public static String core() {
        String s = ClassInfo.P_Core;
        return s;
    }

    public static String doc() {
        String s = ClassInfo.P_Doc;
        return s;
    }

    public static String pp() {
        return ""; // this
    }
}
 
