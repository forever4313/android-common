package com.kbeta.mvp.framework.delegate;

import android.app.Activity;
import android.os.Bundle;

import com.kbeta.mvp.common.MvpPresenter;
import com.kbeta.mvp.common.MvpView;


/**
 *
 * A delegate for Activities to attach them to mosbies mvp.
 *
 * <p>
 * The following methods must be invoked from the corresponding Activities lifecycle methods:
 * <ul>
 * <li>{@link #onCreate(Bundle)}</li>
 * <li>{@link #onDestroy()}</li>
 * <li>{@link #onPause()} </li>
 * <li>{@link #onResume()} </li>
 * <li>{@link #onStart()} </li>
 * <li>{@link #onStop()} </li>
 * <li>{@link #onRestart()} </li>
 * <li>{@link #onContentChanged()} </li>
 * <li>{@link #onSaveInstanceState(Bundle)} </li>
 * <li>{@link #onPostCreate(Bundle)} </li>
 * <li></li>
 * </ul>
 * </p>
 *
 * @author: dk
 * @date:2016/2/28
 * @email:dk-26@163.com
 */
public interface ActivityMvpDelegate<V extends MvpView,P extends MvpPresenter<V>> {


    /**
     * This method must be called from {@link Activity#onCreate(Bundle)}.
     * This method internally creates the presenter and attaches the view to it.
     */
    public void onCreate(Bundle bundle);

    /**
     * This method must be called from {@link Activity#onDestroy()}}.
     * This method internally detaches the view from presenter
     */
    public void onDestroy();

    /**
     * This method must be called from {@link Activity#onPause()}
     */
    public void onPause();

    /**
     * This method must be called from {@link Activity#onResume()}
     */
    public void onResume();

    /**
     * This method must be called from {@link Activity#onStart()}
     */
    public void onStart();

    /**
     * This method must be called from {@link Activity#onStop()}
     */
    public void onStop();

    /**
     * This method must be called from {@link Activity#onRestart()}
     */
    public void onRestart();

    /**
     * This method must be called from {@link Activity#onContentChanged()}
     */
    public void onContentChanged();

    /**
     * This method must be called from {@link Activity#onSaveInstanceState(Bundle)}
     */
    public void onSaveInstanceState(Bundle outState);

    /**
     * This method must be called from {@link Activity#onPostCreate(Bundle)}
     */
    public void onPostCreate(Bundle savedInstanceState);



}
