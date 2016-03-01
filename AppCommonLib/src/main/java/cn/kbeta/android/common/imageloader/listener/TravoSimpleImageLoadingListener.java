package cn.kbeta.android.common.imageloader.listener;

import android.graphics.Bitmap;
import android.view.View;

/**
 * @author:kevin dong
 * @date:2016/03/01
 * @email:dk-26@163.com
 */
public class TravoSimpleImageLoadingListener implements TravoImageLoadingListener {
    @Override
    public void onLoadingStarted(String imageUri, View view) {

    }

    @Override
    public void onLoadingFailed(String imageUri, View view, TravoFailReason failReason) {

    }

    @Override
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

    }

    @Override
    public void onLoadingCancelled(String imageUri, View view) {

    }
}
