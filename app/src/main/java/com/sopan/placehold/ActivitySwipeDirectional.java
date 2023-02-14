package com.sopan.placehold;

import android.os.Bundle;
import android.util.Log;

import com.sopan.placeholderview.SwipeDecor;
import com.sopan.placeholderview.SwipeDirectionalView;
import com.sopan.placeholderview.listeners.ItemRemovedListener;
import com.sopan.placehold.swipe.TinderDirectionalCard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Sopan on 09/08/17.
 */

public class ActivitySwipeDirectional extends AppCompatActivity {

    private static final String TAG = "ActivityTinder";

    @BindView(R.id.swipeView)
    public SwipeDirectionalView mSwipeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinder_directional_swipe);
        ButterKnife.bind(this);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipeView.addItemRemoveListener(new ItemRemovedListener() {

            @Override
            public void onItemRemoved(int count) {
                Log.d(TAG, "onItemRemoved: " + count);
                if (count == 0) {
                    mSwipeView.addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard());
                }
            }
        });
        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setIsUndoEnabled(true)
                .setSwipeVerticalThreshold(Utils.dpToPx(50))
                .setSwipeHorizontalThreshold(Utils.dpToPx(50))
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        mSwipeView.addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard());
    }

    @OnClick(R.id.rejectBtn)
    public void onRejectClick() {
        mSwipeView.doSwipe(false);
    }

    @OnClick(R.id.acceptBtn)
    public void onAcceptClick() {
        mSwipeView.doSwipe(true);
    }

    @OnClick(R.id.undoBtn)
    public void onUndoClick() {
        mSwipeView.undoLastSwipe();
    }
}
