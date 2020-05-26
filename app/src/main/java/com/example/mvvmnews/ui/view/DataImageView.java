package com.example.mvvmnews.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import com.example.BaseApplication;
import com.squareup.picasso.Picasso;

/**
 * @author huanglinqing
 * @project MvvmNews
 * @date 2020/5/26
 * @desc
 */
public class DataImageView extends ImageView {

    public DataImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @BindingAdapter(value = {"imageUrl"}, requireAll = false)
    public static void setImageUrl(ImageView imageView, String url) {
        Picasso.with(BaseApplication.getContext()).load(url)
                .into((imageView));
    }


}
