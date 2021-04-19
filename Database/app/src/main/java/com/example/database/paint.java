package com.example.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class paint {
    LiveData<List<Data>> readData;
    Maydatabase maydatabase;

public paint(Application application){
    maydatabase=Maydatabase.getDataBase(application);
    readData=maydatabase.mydeo().readDtata();
}
public void insert(Data student);
    {
        new inserttask().exec
class InsertList extends AsyncTask<Data,void,vo
    }
}
