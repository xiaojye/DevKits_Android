package com.jye.devkit.base.util

import android.view.View

/**
 * View相关扩展函数
 * @author jye
 * @since 1.0
 */

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.visibleOrGone(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.visibleOrInvisible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

fun View.onClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}

fun View.onClick(listener: (v: View) -> Unit) {
    this.setOnClickListener { listener(it) }
}

fun View.onLongClick(listener: View.OnLongClickListener) {
    this.setOnLongClickListener(listener)
}

fun View.onLongClick(listener: (v: View) -> Unit) {
    this.setOnLongClickListener {
        listener.invoke(it)
        true
    }
}

fun View.setPaddingLeft(value: Int) {
    if (value != this.paddingLeft) {
        this.setPadding(value, this.paddingTop, this.paddingRight, this.paddingBottom)
    }
}

fun View.setPaddingTop(value: Int) {
    if (value != this.paddingTop) {
        this.setPadding(this.paddingLeft, value, this.paddingRight, this.paddingBottom)
    }
}

fun View.setPaddingRight(value: Int) {
    if (value != this.paddingRight) {
        this.setPadding(this.paddingLeft, this.paddingTop, value, this.paddingBottom)
    }
}

fun View.setPaddingBottom(value: Int) {
    if (value != this.paddingBottom) {
        this.setPadding(this.paddingLeft, this.paddingTop, this.paddingRight, value)
    }
}
