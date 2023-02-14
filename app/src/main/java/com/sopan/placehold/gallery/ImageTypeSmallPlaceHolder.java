package com.sopan.placehold.gallery;

import android.content.Context;

import com.sopan.placeholderview.Animation;
import com.sopan.placeholderview.PlaceHolderView;
import com.sopan.placeholderview.annotations.Animate;
import com.sopan.placeholderview.annotations.Layout;
import com.sopan.placeholderview.annotations.NonReusable;
import com.sopan.placeholderview.annotations.Resolve;
import com.sopan.placeholderview.annotations.View;
import com.sopan.placehold.Image;
import com.sopan.placehold.R;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * Created by Sopan on 19/08/16.
 */
@Animate(Animation.CARD_TOP_IN_DESC)
@NonReusable
@Layout(R.layout.gallery_item_small_placeholder)
public class ImageTypeSmallPlaceHolder {

    @View(R.id.placeholderview)
    private PlaceHolderView mPlaceHolderView;

    private Context mContext;
    private List<Image> mImageList;

    public ImageTypeSmallPlaceHolder(Context context, List<Image> imageList) {
        mContext = context;
        mImageList = imageList;
    }

    @Resolve
    private void onResolved() {
        mPlaceHolderView.getBuilder()
                .setHasFixedSize(false)
                .setItemViewCacheSize(10)
                .setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

        for(Image image : mImageList) {
            mPlaceHolderView.addView(new ImageTypeSmall(mContext, mPlaceHolderView, image.getUrl()));
        }
    }
}
