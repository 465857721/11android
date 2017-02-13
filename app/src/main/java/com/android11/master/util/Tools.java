package com.android11.master.util;

import android.content.Context;
import android.util.DisplayMetrics;

import java.lang.reflect.Field;

/**
 * Created by 周康 on 2016/11/23.
 */

public class Tools {

    /**
     * 获得屏幕宽度，单位px
     *
     * @param context 上下文
     * @return 屏幕宽度
     */
    public int getScreenWidth(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获得屏幕高度
     *
     * @param context 上下文
     * @return 屏幕除去通知栏的高度
     */
    public int getScreenHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels - getStatusBarHeight(context);
    }

    /**
     * 获取通知栏高度
     *
     * @param context 上下文
     * @return 通知栏高度
     */
    public int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object obj = clazz.newInstance();
            Field field = clazz.getField("status_bar_height");
            int temp = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }
}
