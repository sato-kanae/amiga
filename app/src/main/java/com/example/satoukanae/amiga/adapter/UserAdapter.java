package com.example.satoukanae.amiga.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.satoukanae.amiga.R;
import com.example.satoukanae.amiga.model.User;

import java.util.List;

/**
 * Created by tester0333 on 2017/10/07.
 */

public class UserAdapter extends ArrayAdapter<User> {
    private LayoutInflater inflater;

    public UserAdapter(Context context, int resource, List<User> objects) {
        super(context, resource, objects);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        User item = (User)getItem(position);
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