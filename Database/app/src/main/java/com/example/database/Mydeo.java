package com.example.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Mydeo {
    //creating insert query
    @Insert
    public void insertStudent(Data data);
    @Delete
    public void deleteStudent(Data data);
    @Query("SELECT * FROM STUDENTINFO")
    public List<Data> readDtata();
    @Update
   public void updateStudent(Data data);

}
