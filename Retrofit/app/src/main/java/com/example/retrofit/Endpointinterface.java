package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpointinterface {
    //call fun-->get the data from the sub URL,@GET


    @GET ("dayone/country/IN")
    //Call<String> getData();
    Call<List<Repo>> getData();
}
