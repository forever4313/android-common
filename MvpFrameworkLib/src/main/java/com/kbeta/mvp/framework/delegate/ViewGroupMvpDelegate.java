package com.kbeta.mvp.framework.delegate;

import android.view.View;
import android.widget.FrameLayout;

import com.kbeta.mvp.common.MvpPresenter;
import com.kbeta.mvp.common.MvpView;


/**
 * * The mvp delegate used for everything that derives from {@link View} like {@link FrameLayout}
 * etc.
 *
 * <p>
 * The following methods must be called from the corresponding View lifecycle method:
 * @author: dk
 * @date:2016/2/28
 * @email:dk-26@163.com
 */
public interface ViewGroupMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {

    /**
     * Must be called from {@link View#onAttachedToWindow()}
     */
    public void onAttachedToWindow();

    /**
     * Must be called from {@link View#onDetachedFromWindow()}
     */
    public void onDetachedFromWindow();

}

