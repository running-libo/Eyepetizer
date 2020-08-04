package com.example.mvvmframe.home.view.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import com.example.mvvmframe.BR;
import com.example.mvvmframe.R;
import com.example.mvvmframe.base.BaseViewModel;
import com.example.mvvmframe.bean.DataResponse;
import com.example.mvvmframe.network.ApiCallBack;
import com.example.mvvmframe.network.ApiManager;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * create by libo
 * create on 2020/8/4
 * description
 */
public class HomeViewModel extends BaseViewModel {
    public ItemBinding<String> itemBinding = ItemBinding.of(BR.item, R.layout.itemview);
    public ObservableList<String> items = new ObservableArrayList<>();

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
//                        String json = new Gson().toJson(dataResponse.getItemList());
//                        Log.i("minfo", json);
//                        success.setValue(json);

                        for (int i=0;i<dataResponse.getItemList().size();i++) {
                            items.add("");
                        }

                        getLoadSuccess().postValue(true);
                    }
                });
    }

}
