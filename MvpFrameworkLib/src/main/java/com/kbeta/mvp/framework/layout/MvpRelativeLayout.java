package com.kbeta.mvp.framework.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.kbeta.mvp.common.MvpPresenter;
import com.kbeta.mvp.common.MvpView;
import com.kbeta.mvp.framework.delegate.BaseMvpDelegateCallback;
import com.kbeta.mvp.framework.delegate.ViewGroupMvpDelegate;
import com.kbeta.mvp.framework.delegate.ViewGroupMvpDelegateImpl;


/**
 * @author: dk
 * @date:2016/2/28
 * @email:dk-26@163.com
 */
public abstract class MvpRelativeLayout<V extends MvpView, P extends MvpPresenter<V>>
        extends RelativeLayout implements MvpView, BaseMvpDelegateCallback<V, P> {

    protected P presenter;
    protected ViewGroupMvpDelegate<V, P> mvpDelegate;

    public MvpRelativeLayout(Context context) {
        super(context);
    }

    public MvpRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MvpRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public MvpRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * Get the mvp delegate. This is internally used for creating presenter, attaching and detaching
     * view from presenter etc.
     *
     * <p><b>Please note that only one instance of mvp delegate should be used per android.view.View
     * instance</b>.
     * </p>
     *
     * <p>
     * Only override this method if you really know what you are doing.
     * </p>
     *
     * @return {@link ViewGroupMvpDelegateImpl}
     */
    @NonNull
    protected ViewGroupMvpDelegate<V, P> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new ViewGroupMvpDelegateImpl<>(this);
        }

        return mvpDelegate;
    }

    @Override protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getMvpDelegate().onAttachedToWindow();
    }

    @Override protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMvpDelegate().onDetachedFromWindow();
    }

    /**
     * Instantiate a presenter instance
     *
     * @return The {@link MvpPresenter} for this view
     */
    public abstract P createPresenter();

    @Override public P getPresenter() {
        return presenter;
    }

    @Override public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override public V getMvpView() {
        return (V) this;
    }


}
