package com.branjunhoe.cleanarchitecture.ext

import android.content.res.Resources

/**
 * 픽셀을 밀도로 변환
 * */
fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()

/**
 * 밀도를 픽셀로 변환
 * */
fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()