package com.example.apppbc.api;
import com.example.apppbc.model.Post;
import com.example.apppbc.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://a2d9-123-16-162-216.ngrok-free.app/api/user/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @POST("signup")
    Call<User> signUp(@Body User user);
    @POST("posts")
    Call<Post> sendPost(@Body Post post);

    @FormUrlEncoded
    @POST("login")
    Call<User> login(@Field("name") String name,@Field("pass") String pass);



}
