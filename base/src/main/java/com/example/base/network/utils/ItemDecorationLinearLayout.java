package com.example.base.network.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * create by libo
 * create on 2018/11/27
 * description recyclerview linearlayoutManager设置间距类
 */
public class ItemDecorationLinearLayout extends RecyclerView.ItemDecoration {
    /**
     * 是否需要第一个item的top间隔
     */
    private  boolean needFirstTop =true;
    /**
     * 横向间距
     */
    private int horizontalSpace;
    /**
     * 纵向间距
     */
    private int verticalSpace;

    public ItemDecorationLinearLayout(int horizontalSpace, int verticalSpace) {
        this.horizontalSpace = horizontalSpace;
        this.verticalSpace = verticalSpace;
    }

    /**
     * 是否需要第一个item的top间隔
     * @param horizontalSpace
     * @param verticalSpace
     * @param needFirstTop
     */
    public ItemDecorationLinearLayout(int horizontalSpace, int verticalSpace,boolean needFirstTop) {
        this.horizontalSpace = horizontalSpace;
        this.verticalSpace = verticalSpace;
        this.needFirstTop = needFirstTop;
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (layoutManager.getOrientation() == LinearLayoutManager.HORIZONTAL) {  //水平方向
            outRect.left = horizontalSpace;
            outRect.top = verticalSpace;
            outRect.bottom = verticalSpace;

            //最后一个item才需要right间距
            if (recyclerView.getChildAdapterPosition(view) == layoutManager.getItemCount() - 1) {
                outRect.right = horizontalSpace;
            }

        } else {  //垂直方向
            outRect.left = horizontalSpace;
            outRect.right = horizontalSpace;
            if (needFirstTop){
                outRect.top = verticalSpace;
            }else {
                if (recyclerView.getChildAdapterPosition(view) != 0) {
                    outRect.top = verticalSpace;
                }
            }


            //最后一个item才需要bottom间距
            if (recyclerView.getChildAdapterPosition(view) == layoutManager.getItemCount() - 1) {
                outRect.bottom = verticalSpace;
            }
        }

    }
}
