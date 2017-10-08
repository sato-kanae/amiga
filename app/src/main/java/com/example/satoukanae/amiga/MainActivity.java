package com.example.satoukanae.amiga;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


import com.example.satoukanae.amiga.adapter.UserAdapter;
import com.example.satoukanae.amiga.model.User;
import com.example.satoukanae.amiga.model.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import android.widget.Toast;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Shows off the most basic usage
 */
public class MainActivity extends AppCompatActivity implements OnDateSelectedListener, OnMonthChangedListener {

    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();


    private MaterialCalendarView widget;
    private TextView textView;
    private ListView listView;
    private AlertDialog dialog;
    private Config config = Config.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        widget =(MaterialCalendarView)findViewById(R.id.calendarView);
        textView =(TextView) findViewById(R.id.textView);
        widget.setOnDateChangedListener(this);
        widget.setOnMonthChangedListener(this);

        this.listView = new ListView(this);
        this.dialog =new AlertDialog.Builder(this)
                .setTitle("2017年10月8日")
                .setView(this.listView).create();

        this.config.users.add(new User(R.drawable.morningimage, R.drawable.ayaimage,    "下村綾  " ,"aya", "文科Ｉ類", "中国語",  "桜蔭", "", "", "", ""            ));
        this.config.users.add(new User(R.drawable.eveningimage, R.drawable.haruimage,  "木下波瑠", "haru"  ,  "文科Ⅱ類",  "フランス語", "白百合", "", "", "", ""    ));
        this.config.users.add(new User(R.drawable.noonimage, R.drawable.kanaimage,  "川田加奈"  , "kana",  "文科Ⅲ類",   "スペイン語","豊島丘","", "", "", ""));
        this.config.users.add(new User(R.drawable.eveningimage, R.drawable.mariimage,  "伊藤麻里" , "mari" ,  "理科Ⅲ類",   "ドイツ語", "豊島丘","", "", "", ""   ));
        this.config.users.add(new User(R.drawable.morningimage, R.drawable.mayaimage,  "松本麻耶" , "maya" ,  "文科Ⅲ類", "中国語", "桜蔭","", "", "", ""           ));
        this.config.users.add(new User(R.drawable.noonimage, R.drawable.momoimage,  "田中桃子" , "momo" , "理科Ⅲ類",  "フランス語",  "女子学院","", "", "", ""   ));
        this.config.users.add(new User(R.drawable.noonimage, R.drawable.nanaimage, "小野なな" , "nana" , "文科Ｉ類",   "スペイン語",  "女子学院","", "", "", ""));
        this.config.users.add(new User(R.drawable.morningimage, R.drawable.noaimage,   "山脇乃亜",  "noa"  , "文科Ⅱ類",   "ドイツ語", "桜蔭", "", "", "", ""       ));
        this.config.users.add(new User(R.drawable.noonimage, R.drawable.rikaimage,  "伊藤梨花" , "rika" , "文科Ⅲ類",   "中国語", "桜蔭", "", "", "", "" ));
        this.config.users.add(new User(R.drawable.eveningimage, R.drawable.tomoimage,  "小野友"  , "tomo"  , "理科Ⅲ類",   "フランス語",  "豊島丘", "", "", "", ""));
        this.config.users.add(new User(R.drawable.morningimage, R.drawable.yagiimage,  "八木美沙" , "yagi" , "理科Ⅲ類",   "スペイン語",  "女子学院", "", "", "", ""));
        this.config.users.add(new User(R.drawable.eveningimage, R.drawable.yumiimage,  "奥村由美" , "yumi" , "文科Ⅲ類",   "フランス語",  "豊島丘", "", "", "", "" ));
        
        setDialogContents();
    }

    public List<User> requestRecommendation(int userId){
        List<User> users = this.config.users;
        User ref_user = users.get(userId);
        User user;

        class Pair {
            public float car;
            public User cdr;
            Pair(float score, User user){
                this.car = score;
                this.cdr = user;
            }
        }

        List<Pair> zipped  = new ArrayList<Pair>();
        for(int i=0; i < users.size(); i++) {
            if(i == userId){
                continue;
            }
            user = users.get(i);
            zipped.add(new Pair(ref_user.compare(user), user));
        }
        Collections.sort(zipped, new Comparator<Pair>() {
            public int compare(Pair x, Pair y){
                return x.car < y.car ? -1 : 1;
            }
        });

        List<User> ret_users = new ArrayList<User>();
        for(int i=0; i<3; i++){
            ret_users.add(zipped.get(i).cdr);
        }
        return ret_users;
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @Nullable CalendarDay date, boolean selected) {
        showDialog();
        textView.setText(getSelectedDatesString());
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
        List<User> users = this.requestRecommendation(0);
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
}

