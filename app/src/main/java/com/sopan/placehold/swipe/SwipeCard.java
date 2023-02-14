package com.sopan.placehold.swipe;

import android.util.Log;

import com.sopan.placeholderview.SwipePlaceHolderView;
import com.sopan.placeholderview.annotations.Click;
import com.sopan.placeholderview.annotations.Layout;
import com.sopan.placeholderview.annotations.NonReusable;
import com.sopan.placeholderview.annotations.Position;
import com.sopan.placeholderview.annotations.swipe.SwipeCancelState;
import com.sopan.placeholderview.annotations.swipe.SwipeIn;
import com.sopan.placeholderview.annotations.swipe.SwipeInState;
import com.sopan.placeholderview.annotations.swipe.SwipeOut;
import com.sopan.placeholderview.annotations.swipe.SwipeOutState;
import com.sopan.placehold.R;

/**
 * Created by Sopan on 19/08/16.
 */
@NonReusable
@Layout(R.layout.swipe_card_view)
public class SwipeCard {

//    @View(R.id.mainView)
//    private LinearLayout mainView;

    @Position
    private int mPosition;

    private SwipePlaceHolderView mSwipePlaceHolderView;

    public SwipeCard(SwipePlaceHolderView swipePlaceHolderView) {
        mSwipePlaceHolderView = swipePlaceHolderView;
    }

    @Click(R.id.rejectBtn)
    private void rejectBtnClick(){
        mSwipePlaceHolderView.doSwipe(this, false);
        Log.d("DEBUG", "rejectBtn");
    }

    @Click(R.id.acceptBtn)
    private void acceptBtnClick(){
        mSwipePlaceHolderView.doSwipe(this, true);
        Log.d("DEBUG", "acceptBtn");
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("DEBUG", "onSwipedOut");
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("DEBUG", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("DEBUG", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("DEBUG", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("DEBUG", "onSwipeOutState");
    }
}
