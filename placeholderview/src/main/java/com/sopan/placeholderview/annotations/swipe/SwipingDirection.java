package com.sopan.placeholderview.annotations.swipe;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Sopan on 09/08/17.
 */

/**
 * This has to be used on method with SwipeDirection members variables
 * : Example : @SwipingDirection private void onSwipingDirection(SwipeDirection direction)
 * {//something here}
 * It is called when the card is swiping with direction
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SwipingDirection {
}
