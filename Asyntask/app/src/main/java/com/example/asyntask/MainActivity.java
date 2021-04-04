package com.example.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView iv;
    Button rv;
    ImageView sv;
    TextView tv;
    String myurl="https://pixabay.com/api/?key=20988203-f4a66d9f348d6bc8d291693e5&q=";
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.imagename);
        rv=findViewById(R.id.submit);
        sv=findViewById(R.id.imageview);
        tv=findViewById(R.id.textview);
        progressBar=findViewById(R.id.progress);
        rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new imageTask().execute();

            }
        });
    }
    class imageTask extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(String... strings) {
            String data=et.getText().toString();
            //Toast.makeText(MainActivity.this, ""+strings, Toast.LENGTH_SHORT).show();
            try {
                URL url=new URL(myurl+data);
                Log.i("mydata",url.toString());
               // Internet checking
                HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
               // getting input
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
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            /*to read JSON object*/
            progressBar.setVisibility(View.GONE);
            try {
                JSONObject imagedata = new JSONObject(s);
                JSONArray hitArray = imagedata.getJSONArray("hits");
                JSONObject hitObject = hitArray.getJSONObject(10);
                String image = hitObject.getString("largeImageURL");
                String user=hitObject.getString("user");
                Picasso.get().load(image).into(sv);
 tv.setText(user);
            }
            catch (JSONException e){
                e.printStackTrace();
            }
        }
    }
}