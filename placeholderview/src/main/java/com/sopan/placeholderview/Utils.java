package com.sopan.placeholderview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

/**
 * Created by Sopan on 20/08/16.
 */
public class Utils {

    /**
     *
     * @param context
     * @return
     */
    protected static int getDeviceWidth(Context context){
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     *
     * @param context
     * @return
     */
    protected static int getDeviceHeight(Context context){
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     *
     * @return
     */
    protected static boolean isAboveApi21(){
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     *
     * @param context
     * @param dp
     * @return
     */
    public static int dpToPx(Context context,int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    public static int dpToPx(float dp) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
}
