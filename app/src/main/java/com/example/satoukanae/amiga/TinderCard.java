package com.example.satoukanae.amiga;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.satoukanae.amiga.model.User;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

@Layout(R.layout.profile_card)
public class TinderCard {

    @View(R.id.imageView)
    private ImageView profileImageView;

    @View(R.id.name)
    private TextView name;

    private User user;
    private Context context;
    private SwipePlaceHolderView swipeView;

    public TinderCard(Context context, User user, SwipePlaceHolderView swipeView) {
        this.context = context;
        this.user = user;
        this.swipeView = swipeView;
    }

    @Resolve
    private void onResolved() {
        this.name.setText(this.user.getName());
        this.profileImageView.setImageResource(user.getFaceIcon());
    }

    @SwipeOut
    private void onSwipedOut() {
        Log.d("EVENT", "onSwipedOut");
        this.swipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState() {
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn() {
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState() {
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState() {
        Log.d("EVENT", "onSwipeOutState");
    }
}
