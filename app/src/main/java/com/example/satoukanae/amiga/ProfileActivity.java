package com.example.satoukanae.amiga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.TextView;

import com.example.satoukanae.amiga.model.User;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    private SwipePlaceHolderView swipeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        final User user = (User) intent.getSerializableExtra("user");
        this.swipeView = (SwipePlaceHolderView) findViewById(R.id.swipeView);
        this.swipeView.getBuilder()
                .setDisplayViewCount(1)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f));

        this.swipeView.addView(new TinderCard(this, user, this.swipeView));

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeView.doSwipe(false);
                finish();
            }
        });


        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeView.doSwipe(true);
                finish();
            }
        });

        this.swipeView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            @Override
            public void onChildViewAdded(View view, View view1) {
                Log.d("EVENT", "onChildViewAdded");
                finish();
            }

            @Override
            public void onChildViewRemoved(View view, View view1) {
                Log.d("EVENT", "onChildViewRemoved");
                finish();
            }
        });
    }
}
