package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,mbl,email,pwd,cfpwd;
    Button reg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        mbl=findViewById(R.id.mbl);
        email=findViewById(R.id.email);
        pwd=findViewById(R.id.pwd);
        cfpwd=findViewById(R.id.cfpwd);

    }

    public void rigister(View view) {
    }
}