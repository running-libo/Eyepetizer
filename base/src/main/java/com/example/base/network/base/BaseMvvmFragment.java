package com.example.base.network.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * create by libo
 * create on 2020/8/4
 * description
 */
public abstract class BaseMvvmFragment<V extends ViewDataBinding, VM extends BaseViewModel> extends BaseLazyloadFragment implements IBaseView {

    protected VM viewModel;
    protected V binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViewModel();
        initDataBinding();
    }

    private void initViewModel() {
        viewModel = (VM) getViewModel();
        binding.setVariable(getBindingVariable(), viewModel);
        binding.setLifecycleOwner(this);
    }

    private void initDataBinding() {
        binding = DataBindingUtil.setContentView(getActivity(), getLayoutId());
    }

    protected BaseViewModel getViewModel() {
        return ViewModelProviders.of(this).get(getGenericType());
    }

    /**
     * 获取参数Variable
     */
    protected abstract int getBindingVariable();

    /**
     * 获取当前类泛型viewmodel的Class类型
     * @return
     */
    private Class<VM> getGenericType() {
        Class<VM> entitiClass = null;
        Type genericSuperclass = getClass().getGenericSuperclass();

        if (genericSuperclass instanceof ParameterizedType) {
            //是否为泛型类型，是就获取泛型对应位置类型
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                entitiClass = (Class<VM>) actualTypeArguments[1];
            }
        }

        return entitiClass;
    }

    @Override
    public void showToast() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }
}
