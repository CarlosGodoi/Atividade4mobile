package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
    @Override
    protected void onStart() {
        super.onStart();

        Thread timer = new Thread(){
            public void run(){
                try {
                    //Display for 3 sec
                    sleep(3000);
                    System.out.println("Acordei");
                }
                catch (InterruptedException e){
                    // Todo Handle exception
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(getApplicationContext(),principalActivity.class);
                    startActivity(intent);
                }

            }
        };
        timer.start();
    }

}