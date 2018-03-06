package com.onion.util;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

/**
 * Created by OnionMac on 2018/2/28.
 */

public class ManifestUtil {

    public static String getActivityMetaData(Activity activity,String dataName) throws PackageManager.NameNotFoundException {
        ActivityInfo info= activity.getPackageManager()
                .getActivityInfo(activity.getComponentName(),
                        PackageManager.GET_META_DATA);
        String data =info.metaData.getString(dataName);
        return data;
    }

    public static String getApplicationMetaData(Activity activity,String dataName) throws PackageManager.NameNotFoundException {
        ApplicationInfo appInfo = activity.getPackageManager()
                .getApplicationInfo(activity.getPackageName(),
                        PackageManager.GET_META_DATA);
        String data = appInfo.metaData.getString(dataName);
        return data;
    }

    public static String getServiceMetaData(Activity activity, Class<? extends Service> clazz,String dataName) throws PackageManager.NameNotFoundException {
        ComponentName cn=new ComponentName(activity,clazz);
        ServiceInfo info = activity.getPackageManager()
                .getServiceInfo(cn, PackageManager.GET_META_DATA);
        String data = info.metaData.getString(dataName);
        return data;
    }

    public static String getReceiverMetaData(Activity activity, Class<? extends BroadcastReceiver> clazz,String dataName) throws PackageManager.NameNotFoundException {
        ComponentName cn=new ComponentName(activity, clazz);
        ActivityInfo info=activity.getPackageManager()
                .getReceiverInfo(cn, PackageManager.GET_META_DATA);
        String data = info.metaData.getString(dataName);
        return data;
    }
}
