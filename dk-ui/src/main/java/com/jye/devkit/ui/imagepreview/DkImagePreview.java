package com.jye.devkit.ui.imagepreview;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jye.devkit.ui.imagepreview.model.ImagePreviewInfo;
import com.jye.devkit.ui.imagepreview.model.VideoPreviewInfo;
import com.jye.devkit.ui.imagepreview.model.builder.ImagePreviewBuilder;
import com.jye.devkit.ui.imagepreview.model.builder.VideoPreviewBuilder;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * [类描述]
 *
 * @author jye
 * @since 1.0
 */
public class DkImagePreview {

    private final WeakReference<Context> context;

    private DkImagePreview(Context context) {
        this.context = new WeakReference<>(context);
    }

    public static DkImagePreview from(Context context) {
        return new DkImagePreview(context);
    }

    public static DkImagePreview from(Activity activity) {
        return new DkImagePreview(activity);
    }

    public static DkImagePreview from(Fragment fragment) {
        return new DkImagePreview(fragment.getActivity());
    }

    public WeakReference<Context> getContext() {
        return context;
    }

    public ImagePreviewBuilder imageList(@NonNull List<ImagePreviewInfo> imageInfoList) {
        return new ImagePreviewBuilder(this, imageInfoList);
    }

    public VideoPreviewBuilder videoList(@NonNull List<VideoPreviewInfo> videoInfoList) {
        return new VideoPreviewBuilder(this, videoInfoList);
    }

    public interface ILoader {

        /**
         * 加载图片
         *
         * @param context      上下文对象
         * @param uri          图片资源URI
         * @param imageView    图片视图控件
         * @param progressView 进度视图控件
         */
        void loadImage(@NonNull Context context, @NonNull Uri uri, @NonNull ImageView imageView, @NonNull View progressView);

        /**
         * 加载GIF图片
         *
         * @param context      上下文对象
         * @param uri          图片资源URI
         * @param imageView    图片视图控件
         * @param progressView 进度视图控件
         */
        void loadGifImage(@NonNull Context context, @NonNull Uri uri, @NonNull ImageView imageView, @NonNull View progressView);
    }

}
