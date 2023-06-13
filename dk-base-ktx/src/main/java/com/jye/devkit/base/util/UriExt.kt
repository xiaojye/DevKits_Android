package com.jye.devkit.base.util

import android.net.Uri
import com.jye.devkit.base.DkBase
import java.io.File

/**
 * Uri转File
 *
 * @return File
 * @author jye
 * @since 1.0
 */
fun Uri.toFile(): File {
    return UriUtils.getFileFromUri(DkBase.getAppContext(), this)
}

/**
 * File转Uri
 *
 * @return Uri
 * @author jye
 * @since 1.0
 */
fun File.toUri(): Uri {
    return UriUtils.getUriFromFile(DkBase.getAppContext(), this)
}