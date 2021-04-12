package com.example.database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Subactivity extends AppCompatActivity {

    EditText Name,Rollnumber,MailId,PhoneNumber;
    RadioButton Female,Male;
    CheckBox English,Hindi,Telugu;
    Spinner dept;
String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);
        Name=findViewById(R.id.username);
        Rollnumber=findViewById(R.id.userroll);
        MailId=findViewById(R.id.usermail);
        PhoneNumber=findViewById(R.id.userphn);
        Female=findViewById(R.id.female);
        Male=findViewById(R.id.male);
        English=findViewById(R.id.english);
        Hindi=findViewById(R.id.hindi);
        Telugu=findViewById(R.id.telugu);
        dept=findViewById(R.id.department);
    }
    public void save(View view){
        String name=Name.getText().toString();
        String roll=Rollnumber.getText().toString();
        String phone=PhoneNumber.getText().toString();
        String mail=MailId.getText().toString();
        //read values from RadioButtons

        if (Male.isChecked()) {
            gender=Male.getText().toString();
        }
        if (Female.isChecked()) {
            gender=Female.getText().toString();
        }
        //Read values from checkbox
        StringBuilder sb=new StringBuilder();
        if (Telugu.isChecked()){
            sb.append(Telugu.getText().toString()+".");

        }
        if (Hindi.isChecked()){
            sb.append(Hindi.getText().toString()+".");
        }
        if (English.isChecked()){
            sb.append(English.getText().toString()+".");
        }
        //read values from spinner
        String department=dept.getSelectedItem().toString();

       // Toast.makeText(this, Name + "\n" + MailId + "\n" + Rollnumber+ "\n" + PhoneNumber +
                       // "\n" + gender + "\n" + dept + "\n" + sb.toString(), Toast.LENGTH_SHORT).show();m


        Data student=new Data();
        student.setName(name);
        student.setMailid(mail);
        student.setPhonenumber(phone);
        student.setRollnumber(roll);
        student.setGrnder(gender);
        student.setDepartment(department);
        student.setLanguage(sb.toString());
        MainActivity.database.mydeo().insertStudent(student);
        Toast.makeText(this,"data saved successfully",Toast.LENGTH_SHORT).show();
        finish();
    }


}