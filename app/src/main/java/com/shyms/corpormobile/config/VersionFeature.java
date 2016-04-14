package com.shyms.corpormobile.config;

import com.shyms.corpormobile.base.BaseApplication;
import com.shyms.corpormobile.util.Device;
import com.shyms.corpormobile.util.SPUtil;

import java.lang.reflect.Field;

/**
 * Created by ken on 24/10/15.
 */
public class VersionFeature {

    public static final String IS_FIRST_LAUNCH = "first_launch";

    static {
        int oldVersionCode = (int) SPUtil.get(SPConstants.CURRENT_VERSION_CODE, -1);
        int currentVersionCode = Device.getAppVersionCode(BaseApplication.context);

        if (oldVersionCode < currentVersionCode) {
            Field[] fields = VersionFeature.class.getDeclaredFields();
            if (fields != null && fields.length > 0) {
                try {
                    for (Field field : fields) {
                        SPUtil.put((String) field.get(null), true);
                    }
                } catch (IllegalAccessException e) {
                }
            }
            SPUtil.put(SPConstants.CURRENT_VERSION_CODE, currentVersionCode);
        }
    }

    public static boolean hasFeature(String feature, boolean defaultValue) {
        return (Boolean) SPUtil.get(feature, defaultValue);
    }

    public static void closeFeature(String feature) {
        SPUtil.put(feature, false);
    }
}
