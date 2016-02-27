package com.kodrindonesia.mokes.api;


import com.kodrindonesia.mokes.models.User;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by andriansandi on 2/27/16.
 */
public interface UsersApi {

    @GET("/auth/login")
//    Callback<User> userLogin(Callback<User> callback);
    void userLogin(@Query("email") String email, @Query("password") String password, Callback<User> callback);
}
