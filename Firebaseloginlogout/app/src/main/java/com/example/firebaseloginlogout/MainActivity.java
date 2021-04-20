package com.example.firebaseloginlogout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {
    EditText u,p;
    Button l,r;
    FirebaseAuth authentication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u=findViewById(R.id.un);
        p=findViewById(R.id.pwd);
        l=findViewById(R.id.sw);
        r=findViewById(R.id.reg);
authentication= FirebaseAuth.getInstance();
    }

    public void register(View view) {
        Intent i=new Intent(this,RegisterActivity.class);
        startActivity(i);
    }

    public void login(View view) {
        String name=u.getText().toString();
        String password=p.getText().toString();
        authentication.signInWithEmailAndPassword(name,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"successful",Toast.LENGTH_SHORT).show();
                     // Intent intent=new Inte;


                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,"failure",Toast.LENGTH_SHORT).show();
            }
        });
    }
}