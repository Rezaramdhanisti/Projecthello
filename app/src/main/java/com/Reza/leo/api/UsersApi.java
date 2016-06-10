package com.Reza.leo.api;



import com.Reza.leo.models.User;

import retrofit.Callback;

import retrofit.http.GET;

import retrofit.http.POST;
import retrofit.http.Query;


public interface UsersApi {

    @GET("/users")
//    Callback<User> userLogin(Callback<User> callback);
    void userLogin(@Query("email") String email, @Query("password") String password, Callback<User> callback);

//    @POST("/users)
////    Callback<User> userLogin(Callback<User> callback);
//    void syncTransaction (@Query("id") String id, @Query("description") String description, @Query("amount") String amount,Callback<User> callback);


}
