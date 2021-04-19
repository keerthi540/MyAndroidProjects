package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText u,p;
Button l,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u=findViewById(R.id.un);
        p=findViewById(R.id.pwd);

    }

    public void login(View view) {


    }

    public void register(View view) {
        Intent i=new Intent(this,Registeractivity.class);
        startActivity(i);
    }
}