package com.example.satoukanae.amiga;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Item> itemList = new ArrayList<Item>();
//        itemList.add(new Item(R.drawable.kanaimage));

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), 0, itemList);
        ListView listView = new ListView(this);
        listView.setAdapter(adapter);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("2017年10月8日")
                .setView(listView).create();
        dialog.show();
    }

    // ListViewで使用するItemClass
    public class Item{
        private int timeIcon;
        private int faceIcon;
        private String name;

        public Item(){

        }

        public Item(int timeIcon, int faceIcon, String name){
            this.timeIcon = timeIcon;
            this.faceIcon = faceIcon;
            this.name = name;
        }

        public int getTimeIcon() {
            return timeIcon;
        }

        public void setTimeIcon(int timeIcon) {
            this.timeIcon = timeIcon;
        }

        public int getFaceIcon() {
            return faceIcon;
        }

        public void setFaceIcon(int faceIcon) {
            this.faceIcon = faceIcon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    // ListViewで使用するadapter
    public class CustomAdapter extends ArrayAdapter<Item> {
        private LayoutInflater inflater;

        public CustomAdapter(Context context, int resource, List<Item> objects) {
            super(context, resource, objects);
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public View getView(int position, View v, ViewGroup parent) {
            Item item = (Item)getItem(position);
            if (null == v) v = inflater.inflate(R.layout.custom_listview, null);

            ImageView time = (ImageView)v.findViewById(R.id.timeIcon);
            time.setImageResource(item.getTimeIcon());

            ImageView face = (ImageView)v.findViewById(R.id.faceIcon);
            face.setImageResource(item.getFaceIcon());


            TextView stringTextView = (TextView)v.findViewById(R.id.name);
            stringTextView.setText(item.getName());
            return v;
        }
    }
}
