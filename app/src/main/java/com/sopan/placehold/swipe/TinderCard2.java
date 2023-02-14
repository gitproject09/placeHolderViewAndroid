package com.sopan.placehold.swipe;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.sopan.placeholderview.annotations.Click;
import com.sopan.placeholderview.annotations.Layout;
import com.sopan.placeholderview.annotations.NonReusable;
import com.sopan.placeholderview.annotations.Resolve;
import com.sopan.placeholderview.annotations.View;
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
@Layout(R.layout.tinder_card_view)
public class TinderCard2 {

    private static int count;
    private CardCallback callback;

    @View(R.id.profileImageView)
    private ImageView profileImageView;

    @View(R.id.nameAgeTxt)
    private TextView nameAgeTxt;

    @View(R.id.locationNameTxt)
    private TextView locationNameTxt;

    @Click(R.id.profileImageView)
    private void onClick(){
        Log.d("DEBUG", "profileImageView");
    }

    public TinderCard2(CardCallback callback) {
        this.callback = callback;
    }

    @Resolve
    private void onResolve(){
        nameAgeTxt.setText("Name " + count++);
    }

    @SwipeOut
    private void onSwipedOut(){
        callback.onSwipingEnd();
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        callback.onSwipingEnd();
    }

    @SwipeIn
    private void onSwipeIn(){
        callback.onSwipingEnd();
    }

    @SwipeInState
    private void onSwipeInState(){
        callback.onSwiping();
    }

    @SwipeOutState
    private void onSwipeOutState(){
        callback.onSwiping();
    }

    public interface CardCallback{
        void onSwiping();
        void onSwipingEnd();
    }
}
