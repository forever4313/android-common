package cn.kbeta.android.common.imageloader.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import cn.kbeta.android.common.imageloader.ImageLoaderAdapter;
import cn.kbeta.android.common.imageloader.core.TravoDisplayOptions;
import cn.kbeta.android.common.imageloader.core.TravoImageLoaderConfiguration;
import cn.kbeta.android.common.imageloader.core.TravoImageSize;
import cn.kbeta.android.common.imageloader.listener.TravoFailReason;
import cn.kbeta.android.common.imageloader.listener.TravoImageLoadingListener;
import cn.kbeta.android.common.imageloader.listener.TravoImageLoadingProgressListener;
import cn.kbeta.android.common.util.ApplicationUtil;

/**
 * @author:kevin dong
 * @date:2016/03/01
 * @email:dk-26@163.com
 */
public class UniversalImageLoaderAdapter implements ImageLoaderAdapter {
    private static Context context = ApplicationUtil.getContext();
    private static UniversalImageLoaderAdapter instance;

    private UniversalImageLoaderAdapter() {
    }

    public static UniversalImageLoaderAdapter getInstance() {
        if (instance == null) {
            instance = new UniversalImageLoaderAdapter();
        }
        return instance;
    }

    @Override
    public DisplayImageOptions options(TravoDisplayOptions travoDisplayOptions) {
        if (travoDisplayOptions == null)
            return null;
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .decodingOptions(travoDisplayOptions.getDecodingOptions())
                .cacheInMemory(travoDisplayOptions.isCacheInMemory())
                .cacheOnDisk(travoDisplayOptions.isCacheOnDisk())
                .bitmapConfig(travoDisplayOptions.getDecodingOptions() == null ? null : travoDisplayOptions.getDecodingOptions().inPreferredConfig)
                .considerExifParams(travoDisplayOptions.isConsiderExifParams())
                .resetViewBeforeLoading(travoDisplayOptions.isResetViewBeforeLoading())
                .showImageForEmptyUri(travoDisplayOptions.getImageForEmptyUri(context.getResources()))
                .showImageOnFail(travoDisplayOptions.getImageOnFail(context.getResources()))
                .showImageOnLoading(travoDisplayOptions.getImageOnLoading(context.getResources()))
                .imageScaleType(getImageScaleType(travoDisplayOptions))
                .displayer(travoDisplayOptions.getDisplayer().getDisplayer())
                .build();
        return options;
    }

    @Override
    public ImageLoaderConfiguration configuration(TravoImageLoaderConfiguration travoImageLoaderConfiguration) {

        if (travoImageLoaderConfiguration == null) {
            return null;
        }
        return travoImageLoaderConfiguration.getConfiguration();
    }

    @Override
    public ImageLoadingListener loadingListener(final TravoImageLoadingListener listener) {
        if (listener == null)
            return null;
        return new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                listener.onLoadingStarted(imageUri, view);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                listener.onLoadingFailed(imageUri, view, parseReason(failReason));
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                listener.onLoadingComplete(imageUri, view, loadedImage);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                listener.onLoadingCancelled(imageUri, view);
            }
        };
    }

    @Override
    public ImageLoadingProgressListener loadingProgressListener(final TravoImageLoadingProgressListener loadingProgressListener) {
        if (loadingProgressListener == null) {
            return null;
        }
        return new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {
                loadingProgressListener.onProgressUpdate(imageUri, view, current, total);
            }
        };
    }

    @Override
    public ImageSize imageSize(TravoImageSize size) {
        if (size == null)
            return null;
        return new ImageSize(size.getWidth(), size.getHeight());
    }

    private TravoFailReason parseReason(FailReason failReason) {
        TravoFailReason.FailType failType;
        switch (failReason.getType()) {
            case IO_ERROR:
                failType = TravoFailReason.FailType.IO_ERROR;
                break;
            case DECODING_ERROR:
                failType = TravoFailReason.FailType.DECODING_ERROR;
                break;
            case NETWORK_DENIED:
                failType = TravoFailReason.FailType.NETWORK_DENIED;
                break;
            case OUT_OF_MEMORY:
                failType = TravoFailReason.FailType.OUT_OF_MEMORY;
                break;
            default:
                failType = TravoFailReason.FailType.UNKNOWN;
        }
        return new TravoFailReason(failType, failReason.getCause());
    }


    private ImageScaleType getImageScaleType(TravoDisplayOptions travoDisplayOptions) {
        switch (travoDisplayOptions.getImageScaleType()) {
            case NONE:
                return ImageScaleType.NONE;
            case NONE_SAFE:
                return ImageScaleType.NONE_SAFE;
            case EXACTLY_STRETCHED:
                return ImageScaleType.EXACTLY_STRETCHED;
            case EXACTLY:
                return ImageScaleType.EXACTLY;
            case IN_SAMPLE_POWER_OF_2:
                return ImageScaleType.IN_SAMPLE_POWER_OF_2;
            case IN_SAMPLE_INT:
                return ImageScaleType.IN_SAMPLE_INT;
        }
        return null;
    }
}
