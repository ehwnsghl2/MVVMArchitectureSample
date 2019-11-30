package com.branjunhoe.cleanarchitecture.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * 반려동물 프로필 사진 보이기
 * */
@BindingAdapter(value = ["setImage"])
fun ImageView.setImage(path: String) {
     Glide.with(this)
         .load(path)
         .into(this)
}




