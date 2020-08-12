package com.example.playactivity.module

import com.example.base.network.base.fragment.BaseMvvmFragment
import com.example.playactivity.databinding.FragmentCommentBinding


class CommentFragment : BaseMvvmFragment<FragmentCommentBinding, CommentViewModel>() {

    override fun initView() {
        viewModel.getComments(arguments!!.get("videoId") as Int)
    }

}