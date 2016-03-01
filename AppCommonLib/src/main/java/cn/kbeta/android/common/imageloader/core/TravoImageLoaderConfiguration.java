package cn.kbeta.android.common.imageloader.core;

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * @author:kevin dong
 * @date:2016/03/01
 * @email:dk-26@163.com
 */
public class TravoImageLoaderConfiguration {

    private ImageLoaderConfiguration configuration;

    public TravoImageLoaderConfiguration(ImageLoaderConfiguration configuration) {
        this.configuration = configuration;
    }

    public ImageLoaderConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ImageLoaderConfiguration configuration) {
        this.configuration = configuration;
    }
}
