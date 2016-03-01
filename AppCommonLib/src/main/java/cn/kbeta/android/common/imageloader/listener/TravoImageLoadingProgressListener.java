package cn.kbeta.android.common.imageloader.listener;

import android.view.View;

/**
 * @author:kevin dong
 * @date:2016/03/01
 * @email:dk-26@163.com
 */
public interface TravoImageLoadingProgressListener {

    /**
     * Is called when image loading progress changed.
     *
     * @param imageUri Image URI
     * @param view     View for image. Can be <b>null</b>.
     * @param current  Downloaded size in bytes
     * @param total    Total size in bytes
     */
    void onProgressUpdate(String imageUri, View view, int current, int total);
}
