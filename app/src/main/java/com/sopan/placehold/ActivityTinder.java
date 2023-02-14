package com.sopan.placehold;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.util.Log;

import com.sopan.placeholderview.SwipeDecor;
import com.sopan.placeholderview.SwipePlaceHolderView;
import com.sopan.placeholderview.listeners.ItemRemovedListener;
import com.sopan.placehold.swipe.TinderCard;

public class ActivityTinder extends AppCompatActivity {

    private static final String TAG = "ActivityTinder";

    @BindView(R.id.swipeView)
    public SwipePlaceHolderView mSwipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinder_swipe);
        ButterKnife.bind(this);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipView.disableTouchSwipe();
        mSwipView.addItemRemoveListener(new ItemRemovedListener() {

            @Override
            public void onItemRemoved(int count) {
                Log.d(TAG, "onItemRemoved: " + count);
                if(count == 0){
                    mSwipView.addView(new TinderCard())
                            .addView(new TinderCard())
                            .addView(new TinderCard())
                            .addView(new TinderCard())
                            .addView(new TinderCard())
                            .addView(new TinderCard())
                            .addView(new TinderCard())
                            .addView(new TinderCard())
                            .addView(new TinderCard())
                            .addView(new TinderCard());
                }
            }
        });
        mSwipView.getBuilder()
//                .setSwipeType(SwipePlaceHolderView.SWIPE_TYPE_VERTICAL)
                .setDisplayViewCount(3)
                .setIsUndoEnabled(true)
                .setWidthSwipeDistFactor(4)
                .setHeightSwipeDistFactor(6)
                .setSwipeDecor(new SwipeDecor()
//                        .setMarginTop(300)
//                        .setMarginLeft(100)
//                        .setViewGravity(Gravity.TOP)
                        .setPaddingTop(20)
                        .setSwipeMaxChangeAngle(2f)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        mSwipView.addView(new TinderCard())
                .addView(new TinderCard())
                .addView(new TinderCard())
                .addView(new TinderCard())
                .addView(new TinderCard())
                .addView(new TinderCard())
                .addView(new TinderCard())
                .addView(new TinderCard())
                .addView(new TinderCard())
                .addView(new TinderCard());
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(8000);
                    mSwipView.enableTouchSwipe();
//                    mSwipView.lockViews();
//                    Thread.currentThread().sleep(4000);
//                    mSwipView.unlockViews();
//                    Thread.currentThread().sleep(4000);
//                    mSwipView.lockViews();
//                    Thread.currentThread().sleep(4000);
//                    mSwipView.unlockViews();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @OnClick(R.id.rejectBtn)
    public void onRejectClick(){
        mSwipView.doSwipe(false);
    }

    @OnClick(R.id.acceptBtn)
    public void onAcceptClick(){
        mSwipView.doSwipe(true);
    }

    @OnClick(R.id.undoBtn)
    public void onUndoClick(){
        mSwipView.undoLastSwipe();
    }
}
