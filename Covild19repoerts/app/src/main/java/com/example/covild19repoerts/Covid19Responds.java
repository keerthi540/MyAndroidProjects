package com.example.covild19repoerts;

import retrofit2.Retrofit;

public class Covid19Responds {
    static Retrofit retrofit;
    public static final String URL="https://api.covid19api.com/dayone/country/IN";
    public static Retrofit getInstance(){
        if (retrofit==null){
            retrofit=new Retrofit().Builder()
            .baseUrl(URL);
            .add
        }
    }

}
