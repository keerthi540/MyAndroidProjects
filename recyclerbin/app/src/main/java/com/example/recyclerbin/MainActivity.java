
package com.example.recyclerbin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rec;
    String titles[];
    String dirNames[];
    int posters[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec = findViewById(R.id.recycler);

        MyAdapter adapter = new MyAdapter(this, titles, dirNames, posters);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);
        titles = getResources().getStringArray(R.array.movieTitles);
        dirNames = getResources().getStringArray(R.array.directorNames);
        posters = new int[]{
                R.drawable.aa,
                R.drawable.bahubali,
                R.drawable.chirutha,
                //R.drawable.dookudu,
                //R.drawable.eega,
                //R.drawable.fidha,
                R.drawable.sardaargabbarsingh,
                R.drawable.hello,
                MyAdapter adapter= new MyAdapter(this, titles, dirNames, posters);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);

    }
    }
}