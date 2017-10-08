package com.example.satoukanae.amiga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.satoukanae.amiga.model.User;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        final User user = (User) intent.getSerializableExtra("user");

//        ((TextView)findViewById(R.id.name)).setText(name);
    }
}
