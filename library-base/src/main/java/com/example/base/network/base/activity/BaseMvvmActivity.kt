package com.example.base.network.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.example.base.BR
import com.example.base.network.base.view.IBaseView
import com.example.base.network.base.viewmodel.BaseViewModel
import com.example.base.network.utils.ActivityManager
import java.lang.reflect.ParameterizedType

/**
 * create by libo
 * create on 2020/8/4
 * description
 */
abstract class BaseMvvmActivity<V : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity(), IBaseView {
    lateinit var viewModel: VM
    lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        initViewModel()
        binding.lifecycleOwner = this
        init()
        ActivityManager.addActivity(this) //创建Activity入栈管理
    }

    protected abstract fun getLayoutId(): Int

    private fun initViewModel() {
        viewModel = createViewModel()
        binding!!.setVariable(getBindingVariable(), viewModel)
        binding!!.lifecycleOwner = this
    }

    /**
     * 创建dataBingding
     */
    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    protected abstract fun init()

    /**
     * 创建viewModel
     */
    protected fun createViewModel(): VM {
        return ViewModelProviders.of(this).get(genericType())
    }

    /**
     * 获取参数Variable
     */
    private fun getBindingVariable() = BR.viewModel

    /**
     * 获取当前类泛型viewmodel的Class类型
     * @return
     */
    fun genericType(): Class<VM> {
        var entitiClass: Class<VM>? = null
        val genericSuperclass = javaClass.genericSuperclass
        if (genericSuperclass is ParameterizedType) {
            entitiClass = genericSuperclass.actualTypeArguments[1] as Class<VM>
        }
        return entitiClass!!
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityManager.removeActivity(this) //销毁Activity移出栈
    }

    override fun showToast() {}

    override fun showLoading() {}

    override fun showEmpty() {}
}