package com.kbeta.mvp.framework;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.kbeta.mvp.common.MvpPresenter;
import com.kbeta.mvp.common.MvpView;
import com.kbeta.mvp.framework.delegate.ActivityMvpDelegate;
import com.kbeta.mvp.framework.delegate.ActivityMvpDelegateImpl;
import com.kbeta.mvp.framework.delegate.BaseMvpDelegateCallback;


/**
 * @author: dk
 * @date:2016/2/28
 * @email:dk-26@163.com
 */
public abstract  class MvpActivity<V extends MvpView,P extends MvpPresenter<V>> extends AppCompatActivity implements BaseMvpDelegateCallback<V,P>, MvpView{

    protected ActivityMvpDelegate mvpDelegate;
    protected P presenter;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
    }


    @Override protected void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @Override protected void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @Override protected void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @Override protected void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    @Override protected void onRestart() {
        super.onRestart();
        getMvpDelegate().onRestart();
    }

    @Override public void onContentChanged() {
        super.onContentChanged();
        getMvpDelegate().onContentChanged();
    }

    @Override protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getMvpDelegate().onPostCreate(savedInstanceState);
    }

    /**
     * Instantiate a presenter instance
     *
     * @return The {@link MvpPresenter} for this view
     */
    @NonNull
    public abstract P createPresenter();

    /**
     * Get the mvp delegate. This is internally used for creating presenter, attaching and detaching
     * view from presenter.
     *
     * <p><b>Please note that only one instance of mvp delegate should be used per Activity
     * instance</b>.
     * </p>
     *
     * <p>
     * Only override this method if you really know what you are doing.
     * </p>
     *
     * @return {@link ActivityMvpDelegateImpl}
     */
    @NonNull protected ActivityMvpDelegate<V, P> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new ActivityMvpDelegateImpl(this);
        }

        return mvpDelegate;
    }
    @NonNull @Override public P getPresenter() {
        return presenter;
    }

    @Override public void setPresenter( @NonNull P presenter) {
        this.presenter = presenter;
    }

    @NonNull @Override public V getMvpView() {
        return (V) this;
    }



}
