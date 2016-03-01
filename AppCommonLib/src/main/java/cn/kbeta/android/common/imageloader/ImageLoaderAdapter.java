package cn.kbeta.android.common.imageloader;


import cn.kbeta.android.common.imageloader.core.TravoDisplayOptions;
import cn.kbeta.android.common.imageloader.core.TravoImageLoaderConfiguration;
import cn.kbeta.android.common.imageloader.core.TravoImageSize;
import cn.kbeta.android.common.imageloader.listener.TravoImageLoadingListener;
import cn.kbeta.android.common.imageloader.listener.TravoImageLoadingProgressListener;

/**
 * @author:kevin dong
 * @date:2016/03/01
 * @email:dk-26@163.com
 */
public interface ImageLoaderAdapter {


    <O> O options(TravoDisplayOptions options);

    <C> C configuration(TravoImageLoaderConfiguration config);

    <L> L loadingListener(TravoImageLoadingListener listener);

    <P> P loadingProgressListener(TravoImageLoadingProgressListener loadingProgressListener);

    <S> S imageSize(TravoImageSize size);


}
