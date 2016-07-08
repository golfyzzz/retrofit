package com.example.golfyzzz.reposit;

/**
 * Created by golfyzzz on 7/6/2016.
 */
public class FooRequest {
    String versions;
    String nonce;
    String mobile;



    FooRequest(String versions, String nonce, String mobile) {
        this.versions = versions;
        this.nonce = nonce;
        this.mobile = mobile;
    }


}