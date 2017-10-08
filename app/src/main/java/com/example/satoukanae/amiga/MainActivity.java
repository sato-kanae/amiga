package com.example.satoukanae.amiga;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.satoukanae.amiga.adapter.UserAdapter;
import com.example.satoukanae.amiga.model.User;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Shows off the most basic usage
 */
public class MainActivity extends AppCompatActivity implements OnDateSelectedListener, OnMonthChangedListener, AdapterView.OnItemClickListener {

    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();

    private MaterialCalendarView widget;
    private ListView listView;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widget =(MaterialCalendarView)findViewById(R.id.calendarView);
        widget.setOnDateChangedListener(this);
        widget.setOnMonthChangedListener(this);

        this.listView = new ListView(this);
        setDialogContents();
        this.listView.setOnItemClickListener(this);
        this.dialog =new AlertDialog.Builder(this)
                .setTitle("2017年10月8日")
                .setView(this.listView).create();
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @Nullable CalendarDay date, boolean selected) {
        showDialog();
    }

    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
        //noinspection ConstantConditions
        getSupportActionBar().setTitle(FORMATTER.format(date.getDate()));
    }

    private void showDialog(){
        this.dialog.show();
    }

    private void setDialogContents(){
        List<User> users = new ArrayList<User>();
        users.add(new User(R.drawable.morningimage,R.drawable.nanaimage,"柴田菜々子"));
        users.add(new User(R.drawable.noonimage,R.drawable.kanaimage,"佐藤かなえ"));
        users.add(new User(R.drawable.eveningimage,R.drawable.momoimage,"住田桃子"));

        UserAdapter adapter = new UserAdapter(getApplicationContext(), 0, users);

        this.listView.setAdapter(adapter);
    }

    private String getSelectedDatesString() {
        CalendarDay date = widget.getSelectedDate();
        if (date == null) {
            return "No Selection";
        }
        return FORMATTER.format(date.getDate());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ListView lv  = (ListView)adapterView;
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("user", (User)lv.getItemAtPosition(i));
        startActivityForResult(intent, 1000);
    }
}