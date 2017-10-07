package com.example.satoukanae.amiga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {

    static final int RESULT_SUBACTIVITY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.edit_text);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
//インテントの作成
                Intent intent = new Intent(getApplication(), SubActivity.class);
//                Bundle bundle = new Bundle();
                if(editText.getText() != null){
//                    bundle.put
                    String str = editText.getText().toString();

                    intent.putExtra("DATA1", str);
                    editText.setText("");
                }
                startActivityForResult(intent, RESULT_SUBACTIVITY );
            }
        });
    }



    protected void onActivityResult( int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(resultCode == RESULT_OK && requestCode == RESULT_SUBACTIVITY && null != intent) {
            String res = intent.getStringExtra("DATA2");
            ((TextView)findViewById(R.id.text_view)).setText(res);
        }
// 受け取るためのコード
    }
}
