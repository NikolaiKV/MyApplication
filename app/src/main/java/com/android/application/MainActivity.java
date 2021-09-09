package com.android.application;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.library.Library;

public class MainActivity extends AppCompatActivity {

    private Library library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // эта строчка включит LifecycleListener для отслеживания
        // статусов ВСЕХ активити в приложении
//        getApplication().registerActivityLifecycleCallbacks(new LifecycleListener());

        library = new Library(MainActivity.this);

        registerSubmitUserTextButton();

        registerChooseImageButton();
    }

    private void registerSubmitUserTextButton() {
        EditText userInputText = findViewById(R.id.userInputText);
        Button submitUserInputButton = findViewById(R.id.submitTextBtn);
        submitUserInputButton.setOnClickListener(
                view -> library.showInput(userInputText.getText().toString()));
    }

    private void registerChooseImageButton() {
        ActivityResultLauncher<String> selectImageActivity = createGetContentActivityLauncher();
        Button chooseImageButton = findViewById(R.id.chooseImgBtn);
        chooseImageButton.setOnClickListener(view -> library.selectImage(selectImageActivity));
    }

    @NonNull
    private ActivityResultLauncher<String> createGetContentActivityLauncher() {
        return getActivityResultRegistry().register("key", this,
                                                     new ActivityResultContracts.GetContent(),
                                                     this::setImageToDisplay);
    }

    private void setImageToDisplay(Uri chosenImageUri) {
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageURI(chosenImageUri);
    }
}