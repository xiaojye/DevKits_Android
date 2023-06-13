package com.jye.devkit.ui.imagepreview.model;

import android.net.Uri;

/**
 * [功能描述]
 *
 * @author jye
 * @since 1.0
 */
public class VideoPreviewInfo extends PreviewInfo {


    public VideoPreviewInfo(String url) {
        super(Uri.parse(url));
    }

}
