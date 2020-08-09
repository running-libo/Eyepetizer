package com.example.base.network.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.example.base.BR
import com.example.base.network.base.viewmodel.BaseViewModel
import java.lang.reflect.ParameterizedType

/**
 * create by libo
 * create on 2020/8/4
 * description
 */
abstract class BaseMvvmActivity<V : ViewDataBinding, VM : BaseViewModel> : BaseActivity() {
    lateinit var viewModel: VM
    lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        initViewModel()
    }

    /**
     * 创建dataBingding，并自动设置布局
     */
    private fun initDataBinding() {
        var dbClass = genericTypeBinding()
        var method = dbClass.getMethod("inflate", LayoutInflater::class.java)
        binding = method.invoke(null, layoutInflater) as V
        setContentView(binding.root)
    }

    private fun initViewModel() {
        viewModel = createViewModel()
        binding!!.setVariable(getBindingVariable(), viewModel)
        binding.lifecycleOwner = this
    }

    /**
     * 创建viewModel
     */
    protected fun createViewModel(): VM {
        return ViewModelProviders.of(this).get(genericTypeViewModel())
    }

    /**
     * 获取参数Variable
     */
    private fun getBindingVariable() = BR.viewModel

    /**
     * 获取当前类泛型viewmodel的Class类型
     * @return
     */
    fun genericTypeViewModel(): Class<VM> {
        return (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<VM>
    }

    fun genericTypeBinding(): Class<V> {
        return (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<V>
    }

}