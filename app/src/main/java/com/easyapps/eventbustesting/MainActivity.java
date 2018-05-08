package com.easyapps.eventbustesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InterstatialAdActivity.class);
                startActivity(i);
            }
        });

        // get event bus object first.
        // and register this class to listen for events.
        EventBus.getDefault().register(this);

    }
//-----------------------------------

    @Subscribe
    public void onEvent(CustomMessageEvent event) {
        // this method is called when any event occurs

        Log.i("flow", "onEvent: Event occurred ,This onEvent Method is in MainActivity and event occurred in" +
                "InterstitialAd Activity");
    }
//-------------------------------------------------------

}
