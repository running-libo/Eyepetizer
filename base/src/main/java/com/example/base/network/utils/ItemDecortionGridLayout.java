package com.example.base.network.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/**
 * create by libo
 * create on 2018/11/29
 * description recyclerview gridlayoutManager或者staggeredLayoutManager设置间距类
 */
public class ItemDecortionGridLayout extends RecyclerView.ItemDecoration {

    private Context mContext;
    private int paddingSpace = 10;

    public ItemDecortionGridLayout(Context context) {
        this.mContext = context;
    }

    public ItemDecortionGridLayout(Context context, int paddingSpace) {
        this.mContext = context;
        this.paddingSpace = paddingSpace;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawVertical(c, parent);
    }

    public void drawVertical(Canvas c, RecyclerView parent) {

        final int childCount = parent.getChildCount();

        // 在每一个子控件的右侧画线
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            String tag = (String) child.getTag();

            if (tag == null) {
                int right = child.getRight();

                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
                int M = ScreenUtils.dp2px(mContext, paddingSpace);
                layoutParams.topMargin = M;
                layoutParams.bottomMargin = M;

                if (right > ScreenUtils.getScreenWidth(mContext) / 2) {
                    layoutParams.rightMargin = M;
                    layoutParams.leftMargin = M / 2;
                } else {
                    layoutParams.rightMargin = M / 2;
                    layoutParams.leftMargin = M;
                }

                child.setLayoutParams(layoutParams);
            }
        }
    }


}
