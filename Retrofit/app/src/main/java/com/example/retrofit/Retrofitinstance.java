package com.example.retrofit;

import android.text.Editable;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Retrofitinstance {
    //1.retrofit,2.URL,3.return the retofit class after initialize
    static Retrofit retrofit;
    public static final String URL="https://api.covid19api.com/";
    public static Retrofit getRetrofit(){
        if (retrofit==null)
        {
          /*  retrofit=new Retrofit.Builder().baseUrl((URL)
                    .add(ScalarsConverterFactory.create()).build();*/
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
