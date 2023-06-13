package com.jye.devkit.ui.imagepreview.model.builder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.jye.devkit.ui.imagepreview.model.ImagePreviewInfo;
import com.jye.devkit.ui.imagepreview.ui.ImagePreviewActivity;
import com.jye.devkit.ui.R;
import com.jye.devkit.ui.imagepreview.DkImagePreview;

import java.util.List;

/**
 * [功能描述]
 *
 * @author jye
 * @since 1.0
 */
public class ImagePreviewBuilder extends PreviewBuilder<ImagePreviewBuilder> {

    public ImagePreviewBuilder(DkImagePreview preview, List<ImagePreviewInfo> imagePreviewInfoList) {
        super(preview);
        mPreviewOptions.previewInfoList = imagePreviewInfoList;
    }

    @Override
    protected void doStart(Context context) {
        Intent intent = new Intent(context, ImagePreviewActivity.class);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.image_preview_enter_anim, 0);
    }
}