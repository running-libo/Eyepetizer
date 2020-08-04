package com.example.mvvmframe.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;
import com.example.mvvmframe.BR;
import com.example.mvvmframe.utils.ActivityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * create by libo
 * create on 2020/8/4
 * description
 */
public abstract class BaseMvvmActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity implements IBaseView {

    protected VM viewModel;
    protected V binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        initViewModel();
        init();

        ActivityManager.getInstance().addActivity(this);  //创建Activity入栈管理
    }

    protected abstract int getLayoutId();

    private void initViewModel() {
        viewModel = (VM) getViewModel();
        binding.setVariable(BR.viewModel, viewModel);
        binding.setLifecycleOwner(this);
    }

    private void initDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    protected abstract void init();

    protected BaseViewModel getViewModel() {

        return ViewModelProviders.of(this).get(getGenericType());
    }

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
    protected void onDestroy() {
        super.onDestroy();

        ActivityManager.getInstance().removeActivity(this);  //销毁Activity移出栈
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
