package com.example.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities= {Data.class},version = 1,exportSchema = false)
public abstract class Maydatabase extends RoomDatabase {
    //create abstract method for tewo class
  public abstract Mydeo mydeo();
    //create database
}
