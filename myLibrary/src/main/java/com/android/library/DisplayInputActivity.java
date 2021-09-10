package com.android.library;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_input);

        TextView textView = findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra("USER_INPUT"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(Library.START_ACTIVITY_NOTIFICATION);
        intent.putExtra("State", getLifecycle().getCurrentState());
        intent.putExtra("Message", "Activity " + getLocalClassName() + " started");
        sendBroadcast(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Intent intent = new Intent(Library.STOP_ACTIVITY_NOTIFICATION);
        intent.putExtra("State", getLifecycle().getCurrentState());
        intent.putExtra("Message", "Activity " + getLocalClassName() + " stopped");
        sendBroadcast(intent);
    }
}