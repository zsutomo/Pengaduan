package com.digitalcreative.pengaduan;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_screen extends AppCompatActivity {
    private  static int SPLASH_SCREEN = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =  new Intent(Splash_screen.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
            }
        },SPLASH_SCREEN);
//        Thread myThread = new Thread(){
//            @Override
//            public void run() {
//                try {
//                    sleep(3000);
//                    Intent intent =  new Intent(getApplicationContext(),HomeActivity.class);
//                    startActivity(intent);
//                    finish();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        myThread.start();
    }
}
