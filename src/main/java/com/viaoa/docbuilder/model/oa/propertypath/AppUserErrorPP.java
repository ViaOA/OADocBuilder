// Generated by OABuilder
package com.viaoa.docbuilder.model.oa.propertypath;
 
import com.viaoa.docbuilder.model.oa.*;
 
public class AppUserErrorPP {
    private static AppUserLoginPPx appUserLogin;
     

    public static AppUserLoginPPx appUserLogin() {
        if (appUserLogin == null) appUserLogin = new AppUserLoginPPx(AppUserError.P_AppUserLogin);
        return appUserLogin;
    }

    public static String id() {
        String s = AppUserError.P_Id;
        return s;
    }

    public static String dateTime() {
        String s = AppUserError.P_DateTime;
        return s;
    }

    public static String message() {
        String s = AppUserError.P_Message;
        return s;
    }

    public static String stackTrace() {
        String s = AppUserError.P_StackTrace;
        return s;
    }

    public static String reviewed() {
        String s = AppUserError.P_Reviewed;
        return s;
    }

    public static String reviewNote() {
        String s = AppUserError.P_ReviewNote;
        return s;
    }

    public static String pp() {
        return ""; // this
    }
}
 
