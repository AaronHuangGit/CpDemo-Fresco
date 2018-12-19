package com.aaron.demo.fresco.adapter

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.aaron.demo.common.base.widget.recycleview.BaseRecycleViewAdapter
import com.aaron.demo.common.base.widget.recycleview.BaseRecycleViewHolder
import com.aaron.demo.fresco.R
import com.soybean.framework.imageloader.FrescoImageView
import com.soybean.framework.imageloader.ImageConfig
import com.soybean.framework.imageloader.ImageLoader
import com.soybean.framework.imageloader.ImageLoaderCallback
import kotlinx.android.synthetic.main.layout_fresco_recycler_item.view.*

/**
 * Created on 16/8/18.
 *
 * @author aaron.huang
 * @version 1.0.0
 */
class FrescoRecyclerAdapter(context: Context) : BaseRecycleViewAdapter<FrescoRecyclerAdapter.FrescoViewHolder, String>(context) {
    private val TAG = "FrescoRecyclerAdapter"
    private val mImageLoaderCallback = object : ImageLoaderCallback() {
        override fun finish(bitmap: Bitmap) {
            Log.e(TAG, "width: " + bitmap.width + " height: "
                    + bitmap.height + " size: " + bitmap.byteCount / 1024 + "kb")
        }
    }

    override fun createViewHolder(parent: ViewGroup): FrescoViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.layout_fresco_recycler_item, parent, false)
        return FrescoViewHolder(itemView)
    }

    inner class FrescoViewHolder(itemView: View) : BaseRecycleViewHolder<String>(itemView) {
        private val mImageView: FrescoImageView = itemView.frescoImageView

        override fun bindViews(url: String) {
            ImageLoader.instance.loadImage(mImageView, url, ImageConfig.Builder()
                    .defaultImage(context.resources.getDrawable(R.drawable.default_image_background))
                    .fadeDuration(500)
                    .scaleType(ImageView.ScaleType.CENTER_CROP)
                    .defaultImageScaleType(ImageView.ScaleType.CENTER_CROP)
                    .retryImageScaleType(ImageView.ScaleType.CENTER_CROP)
                    .progressImageScaleType(ImageView.ScaleType.CENTER_CROP)
                    .supportPlayGif(true)
                    .width(-1)
                    .height(-1)
                    .roundRadius(20)
                    .isCircle(false)
                    .create(), mImageLoaderCallback)
        }
    }
}
