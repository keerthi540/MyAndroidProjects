package com.example.covild19repoerts;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.usb.UsbEndpoint;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView country,date,active,recovered,deaths,confirmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        country=findViewById(R.id.tv_country);
        date=findViewById(R.id.tv_date);
        active=findViewById(R.id.tv_active);
        recovered=findViewById(R.id.tv_recovered);
        deaths=findViewById(R.id.tv_deaths);
        confirmed=findViewById(R.id.tv_confirmed);
        covid19reports
                ei=Covid19Responds.getInstance().create(covid19reports.class);
        Call<String> c=ei.getData();
        c.enqueue
    }
}