package com.tunatech.mokes;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by User on 17/02/2016.
 */
public interface UserApi {
    @GET("v1/auth/register")

    Call<Users> Register(@Query("name") String name, @Query("email") String email);

    @GET("/api/vl/auth{id}")
    Call<User> getUser(@Path("id") String user_id);

    @PUT("/api/vl/auth{id}")
    Call<User> updateUser(@Path("id") int user_id, @Body User user);

    @POST("/api/vl/auth")
    Call<User> saveUser(@Body User user);

    @DELETE("/api/vl/auth/{id}")
    Call<User> deleteUser(@Path("id") String user_id);



}