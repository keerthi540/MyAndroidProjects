package com.example.firebaseloginlogout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText u,p,cp;
    Button l,r;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        u=findViewById(R.id.un);
        p=findViewById(R.id.pwd);
        firebaseAuth= FirebaseAuth.getInstance();
    }

    public void login(View view) {
        String username=u.getText().toString();
        String userpassword=p.getText().toString();
        String s2=cp.getText().toString();
        if(username.isEmpty()||userpassword.isEmpty()){
            Toast.makeText(this, "please enter deatails", Toast.LENGTH_SHORT).show();

        }
        else {
            firebaseAuth.createUserWithEmailAndPassword(username,userpassword)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Toast.makeText(RegisterActivity.this,"register successfull",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext().);
                            startActivity(intent);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(RegisterActivity.this,"failed",Toast.LENGTH_SHORT).show();
                }
            });
    }

   // public void register(View view) {

       // }
    }
}