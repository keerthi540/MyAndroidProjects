package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
TextView Country,Date,Active,Recovery,Deaths,Confirmed;
ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Data Fetching..");
        dialog.setMessage("Please Wait ...");
        dialog.show();
        Country=findViewById(R.id.tv_country);
        Date=findViewById(R.id.tv_date);
        Active=findViewById(R.id.tv_active);
        Recovery=findViewById(R.id.tv_recovery);
        Deaths=findViewById(R.id.tv_deaths);
        Confirmed=findViewById(R.id.tv_confirmed);
Endpointinterface ei= Retrofitinstance.getRetrofit().create(Endpointinterface.class);
Call<String> c=ei.getData();
c.enqueue(new Callback<String>() {
    @Override
    public void onResponse(Call<String> call, Response<String> response) {
      Log.i("ding",response.body());
        //Toast.makeText(MainActivity.this,""+response.body(),Toast.LENGTH_SHORT).show();
        dialog.cancel();
        try {
            JSONArray rootarray=new JSONArray(response.body());
            JSONObject rootobj=rootarray.getJSONObject(rootarray.length()-1);
            String res_Country=rootobj.getString("Country");
            String res_Date=rootobj.getString("Date");
            String res_Active=rootobj.getString("Active");
            String res_Recovery=rootobj.getString("Recovered");
            String res_Deaths=rootobj.getString("Deaths");
            String res_Confirmed=rootobj.getString("Confirmed");
            Confirmed.setText("Confirmed:"+res_Confirmed);
            Deaths.setText("Deaths:"+res_Deaths);
            Recovery.setText("Recovery:"+res_Recovery);
            Active.setText("Active:"+res_Active);
            Date.setText("Date:"+properDateFormat(res_Date));
        Country.setText("Country:"+res_Country);
        } catch (JSONException e) {

            e.printStackTrace();
        }
    }
private String properDateFormat(String res_Deaths){
        String inputPattern="yy-mm-dd";
        String outputPattern="yy-mm-dd";
    SimpleDateFormat inputDate=new SimpleDateFormat(inputPattern);
    SimpleDateFormat outputtDate=new SimpleDateFormat(outputPattern);
    Date d=null;
    String str=null;
    try {
        String resDate;
        d=inputDate.parse(res_Deaths);
        str=outputtDate.format(d);

    }catch (ParseException e){
        e.printStackTrace();
    }
    return str;
}
    @Override
    public void onFailure(Call<String> call, Throwable t) {
        Toast.makeText(MainActivity.this,"failed to load",Toast.LENGTH_SHORT).show();;

    }
});
    }
}