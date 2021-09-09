package com.android.library;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        Toast.makeText(this,
                "Activity " + getLocalClassName() + " started",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,
                "Activity " + getLocalClassName() + " stopped",
                Toast.LENGTH_SHORT)
                .show();
    }
}