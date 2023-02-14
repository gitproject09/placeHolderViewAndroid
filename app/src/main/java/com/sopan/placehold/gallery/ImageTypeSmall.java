package com.sopan.placehold.gallery;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sopan.placeholderview.Animation;
import com.sopan.placeholderview.PlaceHolderView;
import com.sopan.placeholderview.annotations.Animate;
import com.sopan.placeholderview.annotations.Layout;
import com.sopan.placeholderview.annotations.LongClick;
import com.sopan.placeholderview.annotations.NonReusable;
import com.sopan.placeholderview.annotations.Resolve;
import com.sopan.placeholderview.annotations.View;
import com.sopan.placehold.R;

/**
 * Created by Sopan on 19/08/16.
 */
@Animate(Animation.CARD_TOP_IN_DESC)
@NonReusable
@Layout(R.layout.gallery_item_small)
public class ImageTypeSmall {

    @View(R.id.imageView)
    private ImageView imageView;

    private String mUlr;
    private Context mContext;
    private PlaceHolderView mPlaceHolderView;

    public ImageTypeSmall(Context context, PlaceHolderView placeHolderView, String ulr) {
        mContext = context;
        mPlaceHolderView = placeHolderView;
        mUlr = ulr;
    }

    @Resolve
    private void onResolved() {
        Glide.with(mContext).load(mUlr).into(imageView);
    }

    @LongClick(R.id.imageView)
    private void onLongClick(){
        mPlaceHolderView.removeView(this);
    }

}
