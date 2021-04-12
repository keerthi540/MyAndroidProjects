package com.example.database;



import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static Maydatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = Room.databaseBuilder(this, Maydatabase.class, "mydb")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
    }


    public void inserdata(View view) {
        Intent i=new Intent(this, Subactivity.class);
        startActivity(i);
    }
}

