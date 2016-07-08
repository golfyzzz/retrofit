package com.example.golfyzzz.reposit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by golfyzzz on 7/6/2016.
 */
public class FooResponse {

    @SerializedName("success") public String success;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @SerializedName("error_code") public String error;

    List<Question> title;

    public FooResponse() {}




}


