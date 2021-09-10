package com.android.application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.Serializable;

public class MyBroadcastReciver extends BroadcastReceiver {

    private final MainActivity mainActivity;

    public MyBroadcastReciver(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String text = intent.getStringExtra("Message");
        Serializable state = intent.getSerializableExtra("State");
        mainActivity.showToast(text + ".\n<" + state.toString() + ">");
    }
}
