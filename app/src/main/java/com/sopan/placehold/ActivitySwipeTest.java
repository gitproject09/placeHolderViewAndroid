package com.sopan.placehold;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sopan.placeholderview.SwipeDecor;
import com.sopan.placeholderview.SwipePlaceHolderView;
import com.sopan.placehold.swipe.SwipeCard;

public class ActivitySwipeTest extends AppCompatActivity {

    private SwipePlaceHolderView mSwipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.sopan.placehold.R.layout.activity_swipe_test);
        mSwipView = (SwipePlaceHolderView) findViewById(com.sopan.placehold.R.id.swipeView);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipView.getBuilder()
                .setSwipeType(SwipePlaceHolderView.SWIPE_TYPE_HORIZONTAL)
                .setDisplayViewCount(3)
                .setSwipeDecor(
                        new SwipeDecor()
                                .setPaddingTop(20)
                                .setRelativeScale(0.01f)
                                .setSwipeInMsgLayoutId(com.sopan.placehold.R.layout.swipe_in_msg_view)
                                .setSwipeOutMsgLayoutId(R.layout.swipe_out_msg_view));

        mSwipView.addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView));
    }
}
