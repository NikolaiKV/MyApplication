package com.android.library;

import android.content.Intent;
import android.net.Uri;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;


public class Library implements LifecycleObserver {

    private final AppCompatActivity mainContext;


    public Library(AppCompatActivity mainContext) {
        this.mainContext = mainContext;
    }

    public void showInput(String text) {
        Intent displayUserInput = new Intent(mainContext, DisplayInputActivity.class);
        displayUserInput.putExtra("USER_INPUT", text);

        mainContext.startActivity(displayUserInput);
    }

    public void selectImage(ActivityResultLauncher<String> selectImageActivity) {
        selectImageActivity.launch("image/**");
    }
}
