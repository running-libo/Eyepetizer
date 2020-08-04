package com.example.mvvmframe.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.mvvmframe.utils.ActivityManager;

/**
 * create by libo
 * create on 2020/8/4
 * description
 */
public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity implements IBaseView {

    protected VM viewModel;
    private V binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViewModel();
        initDataBinding();
        init();

        ActivityManager.getInstance().addActivity(this);  //创建Activity入栈管理
    }

    protected abstract int getLayoutId();

    private void initViewModel() {
        viewModel = getViewModel();
    }

    private void initDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        if (binding != null) {
            binding.executePendingBindings();
        }
    }

    protected abstract void init();

    protected abstract VM getViewModel();

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
