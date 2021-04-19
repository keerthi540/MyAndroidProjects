package com.example.database;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    static Maydatabase database;
List<Data> Datalist;
RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycler);
        database = Room.databaseBuilder(this, Maydatabase.class, "mydb")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
        Datalist=database.mydeo().readDtata();
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Dataadapter(this,Datalist));

        //Toast.makeText(this,"",studentList.size((),Toast.LENGTH_SHORT)).show();
    }


    public void inserdata(View view) {
        Intent i=new Intent(this, Subactivity.class);
        startActivity(i);
    }
}

