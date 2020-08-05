package com.example.base.network.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import java.lang.reflect.ParameterizedType

/**
 * create by libo
 * create on 2020/8/4
 * description
 */
abstract class BaseMvvmFragment<V : ViewDataBinding, VM : BaseViewModel> : BaseLazyloadFragment(), IBaseView {
    protected var viewModel: VM? = null
    protected var binding: V? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        initDataBinding()
    }

    private fun initViewModel() {
        viewModel = createViewModel()
        binding!!.setVariable(getBindingVariable(), viewModel)
        binding!!.lifecycleOwner = this
    }

    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(activity!!, layoutId)
    }

    protected fun createViewModel(): VM {
        return ViewModelProviders.of(this).get(genericType!!)
    }

    /**
     * 获取参数Variable
     */
    abstract protected fun getBindingVariable(): Int

    /**
     * 获取当前类泛型viewmodel的Class类型
     * @return
     */
    private val genericType: Class<VM>?
        private get() {
            var entitiClass: Class<VM>? = null
            val genericSuperclass = javaClass.genericSuperclass
            if (genericSuperclass is ParameterizedType) {
                //是否为泛型类型，是就获取泛型对应位置类型
                val actualTypeArguments = genericSuperclass.actualTypeArguments
                if (actualTypeArguments != null && actualTypeArguments.size > 0) {
                    entitiClass = actualTypeArguments[1] as Class<VM>
                }
            }
            return entitiClass
        }

    override fun showToast() {}
    override fun showLoading() {}
    override fun showEmpty() {}
}