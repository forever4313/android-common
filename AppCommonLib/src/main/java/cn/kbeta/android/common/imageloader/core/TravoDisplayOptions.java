package cn.kbeta.android.common.imageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;


/**
 * @author:kevin dong
 * @date:2016/03/01
 * @email:dk-26@163.com
 */
public class TravoDisplayOptions {

    private final int imageResOnLoading;
    private final int imageResForEmptyUri;
    private final int imageResOnFail;
    private final Drawable imageOnLoading;
    private final Drawable imageForEmptyUri;
    private final Drawable imageOnFail;
    private final boolean cacheInMemory;
    private final boolean cacheOnDisk;
    private final boolean considerExifParams;
    private final boolean isSyncLoading;
    private final boolean resetViewBeforeLoading;
    private final BitmapFactory.Options decodingOptions;
    private final TravoImageScaleType imageScaleType;

    //optional
    private final TravoBitmapDisplayer displayer;


    private TravoDisplayOptions(Builder builder) {
        imageResOnLoading = builder.imageResOnLoading;
        imageResForEmptyUri = builder.imageResForEmptyUri;
        imageResOnFail = builder.imageResOnFail;
        imageOnLoading = builder.imageOnLoading;
        imageForEmptyUri = builder.imageForEmptyUri;
        imageOnFail = builder.imageOnFail;
        cacheInMemory = builder.cacheInMemory;
        cacheOnDisk = builder.cacheOnDisk;
        considerExifParams = builder.considerExifParams;
        isSyncLoading = builder.isSyncLoading;
        decodingOptions = builder.decodingOptions;
        resetViewBeforeLoading = builder.resetViewBeforeLoading;
        imageScaleType = builder.imageScaleType;
        displayer = builder.displayer;
    }


    public boolean shouldShowImageOnLoading() {
        return imageOnLoading != null || imageResOnLoading != 0;
    }

    public boolean shouldShowImageForEmptyUri() {
        return imageForEmptyUri != null || imageResForEmptyUri != 0;
    }

    public boolean shouldShowImageOnFail() {
        return imageOnFail != null || imageResOnFail != 0;
    }


    public Drawable getImageOnLoading(Resources res) {
        return imageResOnLoading != 0 ? res.getDrawable(imageResOnLoading) : imageOnLoading;
    }

    public Drawable getImageForEmptyUri(Resources res) {
        return imageResForEmptyUri != 0 ? res.getDrawable(imageResForEmptyUri) : imageForEmptyUri;
    }

    public Drawable getImageOnFail(Resources res) {
        return imageResOnFail != 0 ? res.getDrawable(imageResOnFail) : imageOnFail;
    }

    public boolean isResetViewBeforeLoading() {
        return resetViewBeforeLoading;
    }

    public boolean isCacheInMemory() {
        return cacheInMemory;
    }

    public boolean isCacheOnDisk() {
        return cacheOnDisk;
    }

    public BitmapFactory.Options getDecodingOptions() {
        return decodingOptions;
    }


    public boolean isConsiderExifParams() {
        return considerExifParams;
    }

    boolean isSyncLoading() {
        return isSyncLoading;
    }

    public TravoImageScaleType getImageScaleType() {
        return imageScaleType;
    }

    public TravoBitmapDisplayer getDisplayer() {
        return displayer;
    }

    public static class Builder {
        private int imageResOnLoading = 0;
        private int imageResForEmptyUri = 0;
        private int imageResOnFail = 0;
        private Drawable imageOnLoading = null;
        private Drawable imageForEmptyUri = null;
        private Drawable imageOnFail = null;
        private boolean cacheInMemory = false;
        private boolean cacheOnDisk = false;
        private boolean resetViewBeforeLoading = false;
        private BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
        private boolean considerExifParams = false;
        private boolean isSyncLoading = false;
        private TravoImageScaleType imageScaleType = TravoImageScaleType.IN_SAMPLE_POWER_OF_2;

        //optional
        private TravoBitmapDisplayer displayer = TravoBitmapDisplayer.newDefaultBitmapDisplayer();


        public Builder showImageOnLoading(int imageRes) {
            imageResOnLoading = imageRes;
            return this;
        }

        public Builder showImageOnLoading(Drawable drawable) {
            imageOnLoading = drawable;
            return this;
        }

        public Builder showImageForEmptyUri(int imageRes) {
            imageResForEmptyUri = imageRes;
            return this;
        }


        public Builder showImageForEmptyUri(Drawable drawable) {
            imageForEmptyUri = drawable;
            return this;
        }


        public Builder showImageOnFail(int imageRes) {
            imageResOnFail = imageRes;
            return this;
        }


        public Builder showImageOnFail(Drawable drawable) {
            imageOnFail = drawable;
            return this;
        }

        /**
         * Sets {@link Bitmap.Config bitmap config} for image decoding. Default value - {@link Bitmap.Config#ARGB_8888}
         */
        public Builder bitmapConfig(Bitmap.Config bitmapConfig) {
            if (bitmapConfig == null)
                throw new IllegalArgumentException("bitmapConfig can't be null");
            decodingOptions.inPreferredConfig = bitmapConfig;
            return this;
        }

        /**
         * Sets whether loaded image will be cached in memory
         */
        public Builder cacheInMemory(boolean cacheInMemory) {
            this.cacheInMemory = cacheInMemory;
            return this;
        }


        /**
         * Sets whether loaded image will be cached on disk
         */
        public Builder cacheOnDisk(boolean cacheOnDisk) {
            this.cacheOnDisk = cacheOnDisk;
            return this;
        }


        /**
         * Sets whether ImageLoader will consider EXIF parameters of JPEG image (rotate, flip)
         */
        public Builder considerExifParams(boolean considerExifParams) {
            this.considerExifParams = considerExifParams;
            return this;
        }


        public Builder syncLoading(boolean isSyncLoading) {
            this.isSyncLoading = isSyncLoading;
            return this;
        }

        /**
         * image view will be reset (set <b>null</b>) before image loading start
         */
        public Builder resetViewBeforeLoading(boolean resetViewBeforeLoading) {
            this.resetViewBeforeLoading = resetViewBeforeLoading;
            return this;
        }


        public Builder imageScaleType(TravoImageScaleType imageScaleType) {
            this.imageScaleType = imageScaleType;
            return this;
        }

        public Builder displayer(TravoBitmapDisplayer displayer) {
            if (displayer == null) throw new IllegalArgumentException("displayer can't be null");
            this.displayer = displayer;
            return this;
        }

        /**
         * Sets all options equal to incoming options
         */
        public Builder cloneFrom(TravoDisplayOptions options) {
            imageResOnLoading = options.imageResOnLoading;
            imageResForEmptyUri = options.imageResForEmptyUri;
            imageResOnFail = options.imageResOnFail;
            imageOnLoading = options.imageOnLoading;
            imageForEmptyUri = options.imageForEmptyUri;
            imageOnFail = options.imageOnFail;
            cacheInMemory = options.cacheInMemory;
            cacheOnDisk = options.cacheOnDisk;
            considerExifParams = options.considerExifParams;
            isSyncLoading = options.isSyncLoading;
            decodingOptions = options.decodingOptions;
            resetViewBeforeLoading = options.resetViewBeforeLoading;
            imageScaleType = options.imageScaleType;
            displayer = options.displayer;
            return this;
        }

        public TravoDisplayOptions build() {
            return new TravoDisplayOptions(this);
        }

    }

}
