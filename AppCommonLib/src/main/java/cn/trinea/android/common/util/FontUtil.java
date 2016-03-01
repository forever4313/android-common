package cn.trinea.android.common.util;

import android.content.Context;
import android.graphics.Typeface;

public class FontUtil {

	static Typeface typeface ;
	public static Typeface getFont(Context context,String font) {
		if(typeface == null){
			typeface =  Typeface.createFromAsset(context.getAssets(), font);
		}
	    return typeface;
	}
}
