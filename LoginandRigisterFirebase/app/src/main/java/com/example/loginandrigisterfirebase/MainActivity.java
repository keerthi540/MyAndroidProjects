package com.example.loginandrigisterfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

TextView fp;
private FirebaseAuth mAuth;
    EditText u,p;
    Button l,r,sn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u=findViewById(R.id.un);
        p=findViewById(R.id.pwd);
        mAuth=FirebaseAuth.getInstance();
    }

    public void forgotpassword(View view) {

    }

    public void register(View view) {
        String s=l.getText().toString();
        String s1=p.getText().toString();
        mAuth.createUserWithEmailAndPassword(s,s1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void login(View view) {
        String s=l.getText().toString();
        String s1=p.getText().toString();
        mAuth.signInWithEmailAndPassword(s,s1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            signout();
                            /*new AlertDialog.Builder(getApplicationContext())
                               .setTitle("login successful")
                               .setMessage("congrats you got job")
                               .show();*/
                        }
                    }
                });
    }

    public void signout(View view) {
        mAuth.signOut();
    }
}