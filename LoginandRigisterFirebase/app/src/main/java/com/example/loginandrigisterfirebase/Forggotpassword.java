package com.example.loginandrigisterfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class Forggotpassword extends AppCompatActivity {
EditText et;
Button fire;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forggotpassword);
        et=findViewById(R.id.et);
        mAuth=FirebaseAuth.getInstance();

    public void forgotpassword(View view) {
        String s=et.getText().toString();
        mAuth.sendPasswordResetEmail(s).addOnCompleteListener();
        


    }
}