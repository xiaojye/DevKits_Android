package com.jye.devkit.base.util

import com.jye.devkit.base.DkBase

/**
 * 延迟操作
 *
 * @param delayMillis 延迟秒数
 * @param runnable 延迟操作
 * @author jye
 * @since 1.0
 */
fun delayRun(delayMillis: Long, runnable: () -> Unit) {
    DkBase.getMainHandler().postDelayed(runnable, delayMillis)
}