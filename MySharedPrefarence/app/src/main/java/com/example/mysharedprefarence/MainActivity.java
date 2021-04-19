package com.example.mysharedprefarence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText username,password;
        Button show;
        SharedPreferences sp;
        SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.un);
        password = findViewById(R.id.pwd);
sp=getSharedPreferences("myname",MODE_PRIVATE);
    }
    public void Savedata(View view){
        String myname=username.getText().toString();
        String mypassword=password.getText().toString();
        Toast.makeText(this,""+myname+"\n"+mypassword, Toast.LENGTH_SHORT).show();
        editor=sp.edit();
        editor.putString("key-name",myname);
        editor.putString("key-password",mypassword);
        editor.commit();
    }
    public void Retrivedata(View view){
        String s=sp.getString("key-name","");
        String s1=sp.getString("key-password","");
        username.setText(s);
        password.setText(s1);
    }
}