package com.example.base.network.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.example.base.R;

import java.io.File;
import java.security.MessageDigest;

/**
 * create by libo
 * create on 2018/11/14
 * description Glide图片加载工具类
 */
public class ImageLoaderManager {

    /**
     * 默认加载方式
     */
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(imageView.getContext())
                    .load(url)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(40)))
                    .into(imageView);
        }

    }

    /**
     * gif格式
     *
     * @param context
     * @param url
     * @param imageView
     * @param placeHolder
     */
    public static void loadImageGif(Context context, String url, ImageView imageView, int placeHolder) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeHolder == 0 ? R.color.color_bg_theme : placeHolder)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context)
                .asGif()
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }

    /**
     * 加载webp
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadImageWebp(Context context, String url, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(context)
                .load(url)
                .apply(options)
                .transition(new DrawableTransitionOptions().crossFade(200))
                .into(imageView);
    }

    /**
     * 默认加载方式，不使用渐入动画
     *
     * @param context
     * @param url
     * @param imageView
     * @param placeHolder
     */
    public static void loadImageNoAnim(Context context, String url, ImageView imageView, int placeHolder) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeHolder == 0 ? R.color.color_bg_theme : placeHolder)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate();

        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }

    /**
     * 加载圆形图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param placeHolder
     */
    public static void loadCircleImage(Context context, String url, ImageView imageView, int placeHolder) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeHolder == 0 ? R.color.color_bg_theme : placeHolder)
                .error(placeHolder)
                .priority(Priority.HIGH)
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new CircleCrop());

        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }

    /**
     * 加载圆角图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param placeHolder
     */
    public static void loadRoundImage(Context context, String url, ImageView imageView, int radius, int placeHolder) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeHolder == 0 ? R.color.color_bg_theme : placeHolder)
                .priority(Priority.HIGH)
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transforms(new CenterCrop(), new RoundedCorners(radius));

        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }

    /**
     * 加载本地图片文件
     *
     * @param context
     * @param file
     * @param imageView
     * @param placeHolder
     */
    public static void loadFileImage(Context context, File file, ImageView imageView, int placeHolder, int rotate) {
        class RotateTransformation extends BitmapTransformation {

            private float rotateRotationAngle = 0f;

            public RotateTransformation(float rotateRotationAngle) {
                this.rotateRotationAngle = rotateRotationAngle;
            }

            @Override
            protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
                Matrix matrix = new Matrix();

                matrix.postRotate(rotateRotationAngle);

                return Bitmap.createBitmap(toTransform, 0, 0, toTransform.getWidth(), toTransform.getHeight(), matrix, true);
            }

            @Override
            public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

            }
        }
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeHolder == 0 ? R.color.color_bg_theme : placeHolder)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new RotateTransformation(rotate))
                .centerCrop();

        Glide.with(context)
                .load(file)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }

    public static void loadFileImage(Context context, File file, ImageView imageView, int placeHolder, int rotate, RequestListener<Drawable> listener) {
        class RotateTransformation extends BitmapTransformation {

            private float rotateRotationAngle = 0f;

            public RotateTransformation(float rotateRotationAngle) {
                this.rotateRotationAngle = rotateRotationAngle;
            }

            @Override
            protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
                Matrix matrix = new Matrix();

                matrix.postRotate(rotateRotationAngle);

                return Bitmap.createBitmap(toTransform, 0, 0, toTransform.getWidth(), toTransform.getHeight(), matrix, true);
            }

            @Override
            public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

            }
        }
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeHolder == 0 ? R.color.color_bg_theme : placeHolder)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new RotateTransformation(rotate))
                .centerCrop();

        Glide.with(context)
                .load(file)
                .addListener(listener)
                .apply(requestOptions)
                .into(imageView);
    }

    public static void loadFileImage(Context context, File file, ImageView imageView) {
        loadFileImage(context, file, imageView, 0, 0);
    }

    public static void loadFileImage(Context context, File file, ImageView imageView, RequestListener<Drawable> listener) {
        loadFileImage(context, file, imageView, 0, 0, listener);
    }

}
