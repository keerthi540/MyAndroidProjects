package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
RecyclerView rv;
String[] names={"keerthi","roy","raj","sai","indhu"};
String[] roll={"540","512","544","567","527"};
 String[] mail={"keerthi@gmail.com","roy@gmail.com","raj@gmail.com","sai@gmail.com","indhu@gmail.com"};
 String[] phone={"123","3445","890","901","383"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Myadapter(this,names,mail,phone,roll));
    }
}