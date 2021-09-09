package com.android.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.library.DisplayInputActivity;

public class LifecycleListener implements Application.ActivityLifecycleCallbacks {

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        if (DisplayInputActivity.class.getName().equals(activity.getLocalClassName())) {
            Toast.makeText(activity,
                    "LifecycleListener: Activity " + activity.getLocalClassName() + " started",
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
        if (DisplayInputActivity.class.getName().equals(activity.getLocalClassName())) {
            Toast.makeText(activity,
                "LifecycleListener: Activity " + activity.getLocalClassName() + " stopped",
                Toast.LENGTH_SHORT)
                .show();
        }
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {

    }
}
