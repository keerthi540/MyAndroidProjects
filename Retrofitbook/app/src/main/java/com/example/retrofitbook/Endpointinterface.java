
package com.example.retrofitbook;

        import retrofit2.Call;
        import retrofit2.http.GET;

interface Retrofitinterface {
    static ScalarsConverterFactory getRetrofit() {
        return null;
    }

    @GET("books/v1/volumes?q=twostates")
    Call<String> getData() ;
}