package com.kbeta.mvp.framework.delegate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.kbeta.mvp.common.MvpPresenter;
import com.kbeta.mvp.common.MvpView;


/**
 * A delegate for Fragments to attach them to mosby mvp.
 * <p>
 * The following methods must be invoked from the corresponding Fragments lifecycle methods:
 *
 * @author: dk
 * @date:2016/2/28
 * @email:dk-26@163.com
 */
public interface FragmentMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {



    /**
     * Must be called from {@link Fragment#onCreate(Bundle)}
     *
     * @param saved The bundle
     */
    public void onCreate(Bundle saved);

    /**
     * Must be called from {@link Fragment#onDestroy()}
     */
    public void onDestroy();

    /**
     * Must be called from {@link Fragment#onViewCreated(View, Bundle)}
     *
     * @param view The inflated view
     * @param savedInstanceState the bundle with the viewstate
     */
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState);

    /**
     * Must be called from {@link Fragment#onDestroyView()}
     */
    public void onDestroyView();

    /**
     * Must be called from {@link Fragment#onPause()}
     */
    public void onPause();

    /**
     * Must be called from {@link Fragment#onResume()}
     */
    public void onResume();

    /**
     * Must be called from {@link Fragment#onStart()}
     */
    public void onStart();

    /**
     * Must be called from {@link Fragment#onStop()}
     */
    public void onStop();

    /**
     * Must be called from {@link Fragment#onActivityCreated(Bundle)}
     *
     * @param savedInstanceState The saved bundle
     */
    public void onActivityCreated(Bundle savedInstanceState);

    /**
     * Must be called from {@link Fragment#onAttach(Activity)}
     *
     * @param activity The activity the fragment is attached to
     */
    public void onAttach(Activity activity);

    /**
     * Must be called from {@link Fragment#onDetach()}
     */
    public void onDetach();

    /**
     * Must be called from {@link Fragment#onSaveInstanceState(Bundle)}
     */
    public void onSaveInstanceState(Bundle outState);
}
