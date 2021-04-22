package com.example.firebasedatabaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText empName, empId, empSalary;
    Button save;
    FirebaseDatabase database;
    DatabaseReference reference;
    RecyclerView recycle;
    EmplyoyeeAdapter adapter;
    List<employee> list;
    employee emp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empName = findViewById(R.id.empname);
        empId = findViewById(R.id.empid);
        recycle = findViewById(R.id.rec);
        empSalary = findViewById(R.id.empsalary);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("employees");

    }

    public void savedatatofirebase(View view) {
        String ename = empName.getText().toString();
        String eid = empId.getText().toString();
        String esalary = empSalary.getText().toString();
        if (ename.isEmpty() && eid.isEmpty() && esalary.isEmpty()) {
            Toast.makeText(this, "please fill the details", Toast.LENGTH_LONG).show();
        } else {
           emp = new employee(ename, eid, esalary);
            reference.child(ename).push().setValue(emp)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            empName.setText("");
                            empId.setText("");
                            empSalary.setText("");

                            Toast.makeText(MainActivity.this, "saved successfully", Toast.LENGTH_LONG).show();
                            //Intent intent = new Intent(getApplicationContext(), Loginactivity.class);
                            //startActivity(intent);
                        }
                    });
            // reference.setValue(ename);
            // reference.setValue(eid);
            // reference.setValue(esalary);

        }
        //reference.child(ename);

    }

    public void retrivedatatofirebasee(View view) {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                list.add(emp);
                adapter = new EmplyoyeeAdapter(MainActivity.this, list);
                recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recycle.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}