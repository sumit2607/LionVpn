package com.cd.lionvpnlite2021.ipaddressapi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApis {
    @GET("/")
    Call<ApiResponse> requestip(@Query("format") String formate);


}
