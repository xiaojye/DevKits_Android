package com.jye.devkit.ui.imagepreview.model;

import android.net.Uri;
import android.widget.ImageView;

/**
 * [功能描述]
 *
 * @author jye
 * @since 1.0
 */
public class ImagePreviewInfo extends PreviewInfo {

    public ImagePreviewInfo(String url) {
        super(Uri.parse(url));
    }

    public ImagePreviewInfo(Uri uri) {
        super(uri);
    }

    public ImagePreviewInfo(Uri uri, ImageView imageView) {
        super(uri, imageView);
    }

}
