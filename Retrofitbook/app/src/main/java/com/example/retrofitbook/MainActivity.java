package com.example.retrofitbook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.atomic.AtomicReference;

import javax.security.auth.callback.Callback;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView author,title,desc;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        author=findViewById(R.id.authorname);
        title=findViewById(R.id.titlename);
        desc=findViewById(R.id.desc);
        Retrofitinterface ei= (Retrofitinterface) Retrofitinterface.getRetrofit().create(Retrofitinterface.class);
        retrofit2.Call<String> c=ei.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(retrofit2.Call<String> call, Response<String> response) {
                Log.i("ding",response.body());
                Toast.makeText(MainActivity.this, ""+response.body(), Toast.LENGTH_SHORT).show();
                try {
                    JSONArray rootArray=new JSONArray(response.body());
                    JSONObject rootobj=rootArray.getJSONObject(rootArray.length()-1);
                    String res_name=rootobj.getString("authorname");
                    String res_title=rootobj.getString("titlename");
                    String res_descr=rootobj.getString("desc");

                    author.setText("Name:"+res_name);
                    title.setText("Title:"+res_title);
                    desc.setText("Desc:"+res_descr);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed to load",Toast.LENGTH_LONG).show();



            }
        });
    }
}
