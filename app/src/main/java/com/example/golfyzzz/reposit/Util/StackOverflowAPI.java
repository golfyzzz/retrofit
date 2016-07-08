package com.example.golfyzzz.reposit.Util;

import com.example.golfyzzz.reposit.FooResponse;
import com.example.golfyzzz.reposit.StackOverflowQuestions;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by golfyzzz on 6/28/2016.
 */
public interface StackOverflowAPI {

    @FormUrlEncoded
    @POST("mobile_reqOTP")
    Call<FooResponse> postJson(@Field("versions") String version , @Field("nonce") String nonce, @Field("mobile") String mobile );

    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<StackOverflowQuestions> loadQuestions(@Query("tagged") String tags);
}