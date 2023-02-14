package com.sopan.placehold;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sopan.placeholderview.SwipeDecor;
import com.sopan.placeholderview.SwipePlaceHolderView;
import com.sopan.placehold.R;
import com.sopan.placehold.swipe.TinderCard2;

public class ActivityTinderSwipeInScroll extends AppCompatActivity implements TinderCard2.CardCallback {

    private SwipePlaceHolderView mSwipView;

    private CustomScrollview scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_in_scroll);
        mSwipView = (SwipePlaceHolderView) findViewById(R.id.swipeView);
        scroll = (CustomScrollview) findViewById(R.id.scroll);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeType(SwipePlaceHolderView.SWIPE_TYPE_HORIZONTAL)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        mSwipView.addView(new TinderCard2(this))
                .addView(new TinderCard2(this))
                .addView(new TinderCard2(this))
                .addView(new TinderCard2(this))
                .addView(new TinderCard2(this))
                .addView(new TinderCard2(this))
                .addView(new TinderCard2(this))
                .addView(new TinderCard2(this))
                .addView(new TinderCard2(this))
                .addView(new TinderCard2(this));
    }

    @Override
    public void onSwiping() {
        scroll.setScrollable(false);
    }

    @Override
    public void onSwipingEnd() {
        scroll.setScrollable(true);
    }
}
