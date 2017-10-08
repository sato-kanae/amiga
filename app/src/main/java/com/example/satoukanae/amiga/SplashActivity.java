package com.example.satoukanae.amiga;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by yusukato on 2017/10/08.
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        new Handler().postDelayed(new SplashHandler(), 2000);
    }

    class SplashHandler implements Runnable {
        @Override
        public void run() {
            // Start home activity
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            // close splash activity
            SplashActivity.this.finish();
        }
    }
}


