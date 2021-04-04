package com.example.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextView iv;
    Button rv;
    ImageView sv;
    TextView tv;
    String myurl="https://pixabay.com/api/?key=20988203-f4a66d9f348d6bc8d291693e5&q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.imagename);
        rv=findViewById(R.id.submit);
        sv=findViewById(R.id.imageview);
        tv=findViewById(R.id.textview);
        rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new imageTask().execute();

            }
        });
    }
    class imageTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url=new URL(myurl);
                /*Internet checking*/
                HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
                /*getting input*/
                InputStream inputStream=urlConnection.getInputStream();
                Scanner scanner=new Scanner(inputStream);
                scanner.useDelimiter("aaa");
                if(scanner.hasNext());
                return scanner.next();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
        }
    }
}