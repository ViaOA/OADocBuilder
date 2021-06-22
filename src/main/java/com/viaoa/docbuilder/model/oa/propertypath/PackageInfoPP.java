// Generated by OABuilder
package com.viaoa.docbuilder.model.oa.propertypath;
 
import com.viaoa.docbuilder.model.oa.*;
 
public class PackageInfoPP {
    private static ClassInfoPPx classInfos;
    private static PackageInfoPPx packageInfos;
    private static PagePPx page;
    private static PackageInfoPPx parentPackageInfo;
    private static ProjectInfoPPx projectInfo;
     

    public static ClassInfoPPx classInfos() {
        if (classInfos == null) classInfos = new ClassInfoPPx(PackageInfo.P_ClassInfos);
        return classInfos;
    }

    public static PackageInfoPPx packageInfos() {
        if (packageInfos == null) packageInfos = new PackageInfoPPx(PackageInfo.P_PackageInfos);
        return packageInfos;
    }

    public static PagePPx page() {
        if (page == null) page = new PagePPx(PackageInfo.P_Page);
        return page;
    }

    public static PackageInfoPPx parentPackageInfo() {
        if (parentPackageInfo == null) parentPackageInfo = new PackageInfoPPx(PackageInfo.P_ParentPackageInfo);
        return parentPackageInfo;
    }

    public static ProjectInfoPPx projectInfo() {
        if (projectInfo == null) projectInfo = new ProjectInfoPPx(PackageInfo.P_ProjectInfo);
        return projectInfo;
    }

    public static String id() {
        String s = PackageInfo.P_Id;
        return s;
    }

    public static String created() {
        String s = PackageInfo.P_Created;
        return s;
    }

    public static String packageName() {
        String s = PackageInfo.P_PackageName;
        return s;
    }

    public static String seq() {
        String s = PackageInfo.P_Seq;
        return s;
    }

    public static String pp() {
        return ""; // this
    }
}
 