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
    private String code;
    private String message;
    private String userId;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
