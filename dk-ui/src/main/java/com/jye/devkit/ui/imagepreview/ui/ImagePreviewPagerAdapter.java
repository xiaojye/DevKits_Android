package com.jye.devkit.ui.imagepreview.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.jye.devkit.ui.R;
import com.jye.devkit.ui.imagepreview.PreviewOptions;
import com.jye.devkit.ui.imagepreview.model.ImagePreviewInfo;
import com.jye.devkit.ui.imagepreview.model.PreviewInfo;
import com.jye.devkit.ui.widget.photoview.DkPhotoView;
import com.jye.devkit.ui.widget.photoview.OnViewTapListener;

import java.util.List;

/**
 * [功能描述]
 *
 * @author jye
 * @since 1.0
 */
public class ImagePreviewPagerAdapter extends PagerAdapter {

    private Context mContext;

    private PreviewOptions<ImagePreviewInfo> mPreviewOptions;

    private List<ImagePreviewInfo> mImagePreviewInfoList;

    private View mCurrentView;

    private LayoutInflater mLayoutInflater;

    public ImagePreviewPagerAdapter(Context context, PreviewOptions<ImagePreviewInfo> previewOptions) {
        mContext = context;
        mPreviewOptions = previewOptions;
        mImagePreviewInfoList = mPreviewOptions.previewInfoList;

        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mImagePreviewInfoList != null ? mImagePreviewInfoList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);
        mCurrentView = (View) object;
    }

    public View getPrimaryItem() {
        return mCurrentView;
    }

    public DkPhotoView getPrimaryImageView() {
        return mCurrentView.findViewById(R.id.image_preview_page_photo_view);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = mLayoutInflater.inflate(R.layout.image_preview_page, container, false);
        final ProgressBar progressBar = view.findViewById(R.id.image_preview_page_progress_bar);
        final DkPhotoView photoView = view.findViewById(R.id.image_preview_page_photo_view);

        final PreviewInfo previewInfo = mImagePreviewInfoList.get(position);

        //设置图片点击事件，点击关闭预览界面
        photoView.setOnViewTapListener(new OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                ((Activity) mContext).finish();
            }
        });

        //获取进度视图
        final View progressView;
        if (mPreviewOptions.customProgressView != null) {
            progressView = mPreviewOptions.customProgressView;
        } else {
            progressView = progressBar;
        }

        //调用加载器加载图片
        if (previewInfo.getUri().toString().toLowerCase().contains(".gif")) {
            mPreviewOptions.loader.loadGifImage(mPreviewOptions.context, previewInfo.getUri(), photoView, progressView);
        } else {
            mPreviewOptions.loader.loadImage(mPreviewOptions.context, previewInfo.getUri(), photoView, progressView);
        }

        container.addView(view);

        return view;
    }

}
