package com.example.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "studentinfo")
public class Data {

    @ColumnInfo(name = "Studentname")
    String Name;
    String Mailid;
    String Phonenumber;
    @PrimaryKey
    @NonNull
    String Rollnumber;
    String Grnder;
    String Language;
    String Department;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMailid() {
        return Mailid;
    }

    public void setMailid(String mailid) {
        Mailid = mailid;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    @NonNull
    public String getRollnumber() {
        return Rollnumber;
    }

    public void setRollnumber(@NonNull String rollnumber) {
        Rollnumber = rollnumber;
    }

    public String getGrnder() {
        return Grnder;
    }

    public void setGrnder(String grnder) {
        Grnder = grnder;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}