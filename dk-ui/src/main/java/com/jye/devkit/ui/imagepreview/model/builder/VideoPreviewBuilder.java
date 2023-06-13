package com.jye.devkit.ui.imagepreview.model.builder;

import android.content.Context;

import com.jye.devkit.ui.imagepreview.DkImagePreview;
import com.jye.devkit.ui.imagepreview.model.VideoPreviewInfo;

import java.util.List;

/**
 * [功能描述]
 *
 * @author jye
 * @since 1.0
 */
public class VideoPreviewBuilder extends PreviewBuilder<VideoPreviewBuilder> {

    public VideoPreviewBuilder(DkImagePreview preview, List<VideoPreviewInfo> videoPreviewInfoList) {
        super(preview);
        mPreviewOptions.previewInfoList = videoPreviewInfoList;
    }

    @Override
    protected void doStart(Context context) {
//        Intent intent = new Intent(context, VideoPreviewActivity.class);
//        context.startActivity(intent);
//        ((Activity) context).overridePendingTransition(R.anim.preview_enter_anim, 0);
    }
}