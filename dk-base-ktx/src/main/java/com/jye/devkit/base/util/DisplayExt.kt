package com.jye.devkit.base.util

import com.jye.devkit.base.DkBase

/**
 * 屏幕相关扩展函数
 * @author jye
 * @since 1.0
 */

fun Int.dp(): Int {
    return px2dp()
}

fun Float.dp(): Float {
    return DisplayUtils.px2dpF(
        DkBase.getAppContext(),
        this
    )
}

fun Int.sp(): Int {
    return px2sp()
}

fun Float.sp(): Float {
    return DisplayUtils.px2spF(
        DkBase.getAppContext(),
        this
    )
}

fun Int.dp2px(): Int {
    return DisplayUtils.dp2px(
        DkBase.getAppContext(),
        this
    )
}

fun Float.dp2px(): Int {
    return DisplayUtils.dp2px(
        DkBase.getAppContext(),
        this
    )
}

fun Int.sp2px(): Int {
    return DisplayUtils.sp2px(
        DkBase.getAppContext(),
        this
    )
}

fun Float.sp2px(): Int {
    return DisplayUtils.sp2px(
        DkBase.getAppContext(),
        this
    )
}

fun Int.px2dp(): Int {
    return DisplayUtils.px2dp(
        DkBase.getAppContext(),
        this
    )
}

fun Float.px2dp(): Int {
    return DisplayUtils.px2dp(
        DkBase.getAppContext(),
        this
    )
}

fun Int.px2sp(): Int {
    return DisplayUtils.px2sp(
        DkBase.getAppContext(),
        this
    )
}

fun Float.px2sp(): Int {
    return DisplayUtils.px2sp(
        DkBase.getAppContext(),
        this
    )
}
