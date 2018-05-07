package com.easyapps.eventbustesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    EditText result;
    Button launchChildActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        launchChildActivity = findViewById(R.id.launchChild);

        launchChildActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        ChildActivity.class);
                startActivity(intent);
            }
        });

        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEvent(CustomMessageEvent event) {
        result.setText(event.getCustomMessage());
    }
}
