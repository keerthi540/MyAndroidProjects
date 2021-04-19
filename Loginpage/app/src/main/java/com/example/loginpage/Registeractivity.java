package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registeractivity extends AppCompatActivity {
    EditText u,p,cp;
    Button l,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);
        u=findViewById(R.id.un);
        p=findViewById(R.id.pwd);
cp=findViewById(R.id.cnfpwd);
    }

    public void save(View view) {
        String s=u.getText().toString();
        String s1=p.getText().toString();
        String s2=cp.getText().toString();
        if(s.isEmpty()||s1.isEmpty()||s2.isEmpty()){
            Toast.makeText(this, "please enter deatails", Toast.LENGTH_SHORT).show();

        }
        else if(s1!=s2){
            Toast.makeText(this,"incorrect password",Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
        }
    }
}