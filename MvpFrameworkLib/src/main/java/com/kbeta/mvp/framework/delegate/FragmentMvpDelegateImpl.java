package com.kbeta.mvp.framework.delegate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.kbeta.mvp.common.MvpPresenter;
import com.kbeta.mvp.common.MvpView;

/**
 *
 * The default implementation of {@link FragmentMvpDelegate}
 * @author: dk
 * @date:2016/2/28
 * @email:dk-26@163.com
 */
public class FragmentMvpDelegateImpl<V extends MvpView,P extends MvpPresenter<V>> implements FragmentMvpDelegate<V,P>{


    protected BaseMvpDelegateCallback<V, P> delegateCallback;
    protected MvpInternalDelegate<V, P> internalDelegate;
    private boolean onViewCreatedCalled = false;



    public FragmentMvpDelegateImpl(BaseMvpDelegateCallback<V, P> delegateCallback) {
        if (delegateCallback == null) {
            throw new NullPointerException("MvpDelegateCallback is null!");
        }

        this.delegateCallback = delegateCallback;
    }

    protected MvpInternalDelegate<V, P> getInternalDelegate() {
        if (internalDelegate == null) {
            internalDelegate = new MvpInternalDelegate<>(delegateCallback);
        }

        return internalDelegate;
    }

    @Override public void onCreate(Bundle saved) {

    }

    @Override public void onDestroy() {

    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getInternalDelegate().createPresenter();
        getInternalDelegate().attachView();
        onViewCreatedCalled = true;
    }

    @Override public void onDestroyView() {
        getInternalDelegate().detachView();
    }

    @Override public void onPause() {

    }

    @Override public void onResume() {

    }

    @Override public void onStart() {

        if (!onViewCreatedCalled){
            throw new IllegalStateException("It seems that you are using " + delegateCallback.getClass().getCanonicalName()+" as headless (UI less) fragment (because onViewCreated() has not been called or maybe delegation misses that part). Having a Presenter without a View (UI) doesn't make sense. Simply use an usual fragment instead of an MvpFragment if you want to use a UI less Fragment");
        }

    }

    @Override public void onStop() {

    }

    @Override public void onActivityCreated(Bundle savedInstanceState) {

    }

    @Override public void onAttach(Activity activity) {

    }

    @Override public void onDetach() {

    }

    @Override public void onSaveInstanceState(Bundle outState) {

    }
}
