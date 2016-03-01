package com.kodrindonesia.mokes.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andriansandi on 2/27/16.
 */
public class User {

    @SerializedName("token")
    private String token;
    private String email;
    private String name;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
