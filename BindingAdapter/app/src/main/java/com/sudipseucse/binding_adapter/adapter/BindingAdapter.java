package com.sudipseucse.binding_adapter.adapter;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class BindingAdapter {

    //Attributes that can be called from xml
    //@androidx.databinding.BindingAdapter({"imageFromUrl","whileError"})

    //Set required all attributes call from xml = false
    //@androidx.databinding.BindingAdapter(value = {"imageFromUrl","whileError"}, requireAll = false)
    @androidx.databinding.BindingAdapter(value = {"imageFromUrl","whileError"})

    //Every parameter that are defined needs to be used
    public static void imageFromUrl(ImageView imageView, String url, Drawable error) {

        //Glide implementation
        //Glide.with(imageView.getContext()).load(url).into(imageView);

        //Picasso implementation
        Picasso.get().load(url).error(error).into(imageView);
    }
}
