package com.example.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class Mynewmodel extends AndroidViewModel {
    paint paint;
    LiveData<List<Data>> readData;
    public Mynewmodel(@NonNull Application application) {
        super(application);
        paint=new  Data(application);
        readData
    }
}
