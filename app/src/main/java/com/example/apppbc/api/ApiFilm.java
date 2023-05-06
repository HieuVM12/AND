package com.example.apppbc.api;

import com.example.apppbc.model.Bill;
import com.example.apppbc.model.Film;
import com.example.apppbc.model.ResUrl;
import com.example.apppbc.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiFilm {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiFilm apiFilm = new Retrofit.Builder()
            .baseUrl("https://a2d9-123-16-162-216.ngrok-free.app/api/film/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiFilm.class);

    @GET("getAllFilm")
    Call<List<Film>> listFilm();
    @GET("getFilm")
    Call <Film> getFilm(@Query("id") Long id);
    @GET("payment")
    Call <ResUrl> getPay(@Query("amount") double amount);
    @POST("addBill")
    Call<Bill> saveBill(@Body Bill bill);
}
