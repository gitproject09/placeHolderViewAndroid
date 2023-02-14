package com.sopan.placehold.swipe;

import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.sopan.placeholderview.annotations.Click;
import com.sopan.placeholderview.annotations.Layout;
import com.sopan.placeholderview.annotations.NonReusable;
import com.sopan.placeholderview.annotations.Resolve;
import com.sopan.placeholderview.annotations.View;
import com.sopan.placeholderview.annotations.swipe.SwipeCancelState;
import com.sopan.placeholderview.annotations.swipe.SwipeHead;
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
public class TinderCard {

    private static int count;

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

    @Resolve
    private void onResolve(){
        nameAgeTxt.setText("Name " + count++);
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

    @SwipeHead
    private void onSwipeHead() {
        profileImageView.setBackgroundColor(Color.BLUE);
        Log.d("DEBUG", "onSwipeHead");
    }
}
