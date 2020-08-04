package com.example.mvvmframe.home.view.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import com.example.mvvmframe.BR;
import com.example.mvvmframe.R;
import com.example.base.network.base.BaseViewModel;
import com.example.base.network.bean.DataResponse;
import com.example.base.network.net.ApiCallBack;
import com.example.base.network.net.ApiManager;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * create by libo
 * create on 2020/8/4
 * description
 */
public class HomeViewModel extends BaseViewModel {
    public ItemBinding<DataResponse.ItemListBean> itemBinding = ItemBinding.of(BR.item, R.layout.itemview);
    public ObservableList<DataResponse.ItemListBean> items = new ObservableArrayList<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadData() {
        ApiManager.getApiService().getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new ApiCallBack<DataResponse>() {
                    @Override
                    public void onSuccess(DataResponse dataResponse) {

                        items.addAll(dataResponse.getItemList());
                        getLoadSuccess().postValue(true);
                    }
                });
    }

}
