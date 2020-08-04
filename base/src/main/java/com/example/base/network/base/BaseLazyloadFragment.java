package com.example.base.network.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * create by libo
 * create on 2018/11/16
 * description 懒加载Fragment，默认所有fragment都是懒加载
 */
public abstract class BaseLazyloadFragment extends Fragment {
    protected View rootView;
    private boolean isVisible;
    /** 是否是第一次加载布局 */
    private boolean isInitView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = LayoutInflater.from(getContext()).inflate(getLayoutId(), container, false);
        initLoadMoreViews();
        initView();
        isInitView = true;
        isCanLoadData();
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    protected abstract int getLayoutId();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        //isVisibleToUser值表示:该Fragment的UI用户是否可见，获取该标志记录下来
        if (isVisibleToUser) {
            isVisible = true;
            isCanLoadData();
        } else {
            isVisible = false;
        }
    }

    private void isCanLoadData() {
        //所以能加载数据条件是view初始化完成并且对用户可见
        if (isVisible && isInitView) {
            loadData();

            isVisible = false;
            isInitView = false;
        }
    }

    protected abstract void initView();

    protected void initData(){}

    protected abstract void initLoadMoreViews();

    /**
     * 懒加载方法
     */
    protected void loadData(){}
}
