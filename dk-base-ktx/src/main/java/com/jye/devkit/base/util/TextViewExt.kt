package com.jye.devkit.base.util

import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

/**
 * TextView相关扩展函数
 * @author jye
 * @since 1.0
 */

fun TextView.setDrawableLeft(@DrawableRes resId: Int) {
    val drawable = ContextCompat.getDrawable(this.context, resId)
    drawable?.let {
        drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
        this.setCompoundDrawables(drawable, null, null, null)
    }
}

fun TextView.setDrawableRight(@DrawableRes resId: Int) {
    val drawable = ContextCompat.getDrawable(this.context, resId)
    drawable?.let {
        drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
        this.setCompoundDrawables(null, null, drawable, null)
    }
}

fun TextView.setDrawableTop(@DrawableRes resId: Int) {
    val drawable = ContextCompat.getDrawable(this.context, resId)
    drawable?.let {
        drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
        this.setCompoundDrawables(null, drawable, null, null)
    }
}

fun TextView.setDrawableBottom(@DrawableRes resId: Int) {
    val drawable = ContextCompat.getDrawable(this.context, resId)
    drawable?.let {
        drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
        this.setCompoundDrawables(null, null, null, drawable)
    }
}