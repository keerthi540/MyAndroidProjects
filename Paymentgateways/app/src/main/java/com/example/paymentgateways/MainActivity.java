package com.example.paymentgateways;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {
String APIKEY="rzp_test_dMyLviBzgWapaF";
Checkout checkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Checkout.preload(getApplicationContext());
    }

    public void payment(View view) {
        //intializtion checkout
        checkout=new Checkout();
        checkout.setKeyID(APIKEY);
        final Activity activity=this;

        try {
            JSONObject object=new JSONObject();
            object.put("Name","keerthi");
            object.put("Amount","1000");
            object.put("theme color","#000");
            object.put("image","https://lh3.googleusercontent.com/proxy/sAz6oEM5ka2yLBwlh1zMy__BPu_x2HGYDdz-WEiUOcSNAf7GfKMZsOnCrAHI_cS7jjE4n50bDimmi0UB0zlXwFWHOLYSPVzdIUT0e0IAMuJ9Cz3d6CMMa3pIgEBcXuEQDkW-");
            object.put("currency","INR");
            checkout.open(activity,object);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Fail"+s, Toast.LENGTH_SHORT).show();
    Log.i("error",s);
    }
}