package com.example.firebasedatabaseexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.ActionMode;
import android.widget.ImageView;

public class LoginSuccessActivity extends AppCompatActivity {
AnimationDrawable drawable;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        imageView=findViewById(R.id.iv);
        imageView.setBackgroundResource(R.drawable.ic_launcher_background);
//        drawable=(AnimationDrawable) imageView.getBackground();
    }

 /*   @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        drawable.start();
    }*/
}