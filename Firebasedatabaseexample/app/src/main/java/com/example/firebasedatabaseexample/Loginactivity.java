package com.example.firebasedatabaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Loginactivity extends AppCompatActivity {
    EditText e_name, e_id;
    FirebaseDatabase database;
    DatabaseReference reference;
    List<employee> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        e_name = findViewById(R.id.et_empname);
        e_id = findViewById(R.id.et_empid);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("employees");
    }

    public void LoginEvent(View view) {
        String ename = e_name.getText().toString();
        String eid = e_id.getText().toString();

        list = new ArrayList<>();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    //employee emp=ds.getValue(employee.class);
                    if (ename.isEmpty() && eid.isEmpty()) {
                        Toast.makeText(Loginactivity.this, "fill the details", Toast.LENGTH_SHORT).show();
                    } else {
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot ds : snapshot.getChildren()) {
                                    employee emp = ds.getValue(employee.class);
                                    if ((ename.equals(emp.getEid())) && (eid.equals(emp.getEid()))) {
                                        Intent successintent = new Intent(getApplicationContext(), LoginSuccessActivity.class);
                                        startActivity(successintent);
                                    } else {
                                        Toast.makeText(Loginactivity.this, "not found", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
       /*reference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               list=new ArrayList<>();
               for(int i=0;i<=list.size();i++){
                   if(ename.equals(list.get(i).getEname())&&
                           eid.equals(list.get(i).getEid())){
                       Toast.makeText(Loginactivity.this, "welcome", Toast.LENGTH_SHORT).show();
                   }
                   Toast.makeText(Loginactivity.this, ""+list.size(), Toast.LENGTH_SHORT).show();
               }

               startActivity(new Intent(Loginactivity.this,LoginSuccessActivity.class));



           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {
                   Toast.makeText(Loginactivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();

           }
       });*/

        startActivity(new Intent(Loginactivity.this, LoginSuccessActivity.class));
    }
}