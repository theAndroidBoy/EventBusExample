package com.easyapps.eventbustesting;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class ChildActivity extends AppCompatActivity {

    EditText eventMessage;
    Button eventTrigger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        eventMessage = findViewById(R.id.eventMessage);
        eventTrigger = findViewById(R.id.triggerEvent);

        eventTrigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomMessageEvent event = new CustomMessageEvent();
                event.setCustomMessage(eventMessage.getText().toString());
                EventBus.getDefault().post(event);
            }
        });
    }

}
