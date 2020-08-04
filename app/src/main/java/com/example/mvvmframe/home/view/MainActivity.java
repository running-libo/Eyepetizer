package com.example.mvvmframe.home.view;

import androidx.lifecycle.Observer;
import com.example.mvvmframe.BR;
import com.example.mvvmframe.R;
import com.example.base.network.base.BaseMvvmActivity;
import com.example.mvvmframe.databinding.ActivityMainBinding;
import com.example.mvvmframe.home.view.viewmodel.HomeViewModel;

public class MainActivity extends BaseMvvmActivity<ActivityMainBinding, HomeViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        viewModel.loadData();
        viewModel.getLoadSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

            }
        });
    }

    @Override
    protected int getBindingVariable() {
        return BR.viewModel;
    }

}