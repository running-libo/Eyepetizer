package com.example.module_login

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.base.network.base.activity.BaseMvvmActivity
import com.example.base.network.route.RoutePath
import com.example.module_login.databinding.ActivityLoginBinding

@Route(path = RoutePath.Login.LOGIN_ACTIVITY)
class LoginActivity : BaseMvvmActivity<ActivityLoginBinding, LoginViewModel>() {

    override fun setLayoutId(): Int = R.layout.activity_login

}