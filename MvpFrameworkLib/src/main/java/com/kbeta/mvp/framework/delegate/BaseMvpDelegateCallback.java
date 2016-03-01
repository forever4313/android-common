package com.kbeta.mvp.framework.delegate;

import android.support.annotation.NonNull;

import com.kbeta.mvp.common.MvpPresenter;
import com.kbeta.mvp.common.MvpView;


/**
 *
 * The MvpDelegate callback that will be called from  {@link
 * FragmentMvpDelegate} or {@link ViewGroupMvpDelegate} or {@link ActivityMvpDelegate}. This interface must be implemented by all Activity or
 * Fragment or android.view.View that you want to support mosbys mvp.
 *
 * @param <V> The type of {@link MvpView}
 * @param <P> The type of {@link MvpPresenter}
 *
 * @author: dk
 * @date:2016/2/28
 * @email:dk-26@163.com
 */
public interface BaseMvpDelegateCallback<V extends MvpView,P extends MvpPresenter<V>> {

    /**
     * Creates the presenter instance
     *
     * @return the created presenter instance
     */
    @NonNull
    public P createPresenter();

    /**
     * Get the presenter. If null is returned, then a internally a new presenter instance gets
     * created
     * by calling {@link #createPresenter()}
     *
     * @return the presenter instance. can be null.
     */
    public P getPresenter();

    /**
     * Sets the presenter instance
     *
     * @param presenter The presenter instance
     */
    public void setPresenter(P presenter);

    /**
     * Get the MvpView for the presenter
     *
     * @return The view associated with the presenter
     */
    public V getMvpView();
}
