package com.example.mvvmframe.home.view;

import androidx.lifecycle.Observer;

import com.example.mvvmframe.R;
import com.example.mvvmframe.base.BaseMvvmActivity;
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
        viewModel.getSuccess().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });
    }

}