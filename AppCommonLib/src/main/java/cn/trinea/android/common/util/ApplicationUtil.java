/**
 *
 * Copyright 2014 Travo, Inc. All rights reserved.
 * AppliationUtil.java
 *
 */
package cn.trinea.android.common.util;

import android.content.Context;

/**
 *@date 2014-8-28
 */
public class ApplicationUtil
{
    private static Context context;
    
    public static void init(Context context)
    {
        if(context == null)
            throw new IllegalArgumentException("context cannot be null!");
        ApplicationUtil.context = context;
    }
    
    public static Context getContext()
    {
        if(context == null)
            throw new IllegalArgumentException("context cannot be null!");
        return context;
    }

}
