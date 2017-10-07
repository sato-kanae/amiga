package com.example.satoukanae.amiga;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;



public class SubActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        final String data = intent.getStringExtra("DATA1");

//        if (data != null){
//            TextView textView = (TextView) findViewById(R.id.text_view);
//            textView.setText(data);
//        }


        editText = (EditText) findViewById(R.id.edit_text);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                if (editText.getText() != null) {
                    String str = data + editText.getText().toString();
                    intent.putExtra("DATA2", str);
                    editText.setText("");
                }

                setResult(RESULT_OK, intent);
                finish();
            }
        });

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


                finish();
            }
        });
    }


}
