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
        final User user = (User)intent.getSerializableExtra("user");

        String name = user.getName();
//      String faculty = user.getFaculty();
//      String language = user.getLanguage();
//      String place = user.getPlace();
//      String school = user.getSchool();
//      String station = user.getStation();
//       String hobby = user.getHobby()

        ((TextView)findViewById(R.id.name)).setText(name);



        Intent intent = getIntent();
        final User user = (User) intent.getSerializableExtra("user");
    }
}
