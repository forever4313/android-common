package cn.kbeta.android.common.imageloader.core;

import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * @author:kevin dong
 * @date:2016/03/01
 * @email:dk-26@163.com
 */
public class TravoBitmapDisplayer {

    private BitmapDisplayer displayer;

    public static TravoBitmapDisplayer newRoundBitmapDisplayer(int cornerPix) {
        return new TravoBitmapDisplayer(new RoundedBitmapDisplayer(cornerPix));
    }

    public static TravoBitmapDisplayer newDefaultBitmapDisplayer() {
        return new TravoBitmapDisplayer(DefaultConfigurationFactory.createBitmapDisplayer());
    }


    protected TravoBitmapDisplayer(BitmapDisplayer displayer) {
        this.displayer = displayer;
    }

    public BitmapDisplayer getDisplayer() {
        return displayer;
    }

    public void setDisplayer(BitmapDisplayer displayer) {
        this.displayer = displayer;
    }
}
