package com.easyapps.eventbustesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class InterstatialAdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial_ad);

        //Create some event
        CustomMessageEvent event = new CustomMessageEvent();
        // Now post this event
        EventBus.getDefault().post(event);

    }

}