package com.example.golfyzzz.reposit;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.golfyzzz.reposit.Util.StackOverflowAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends ListActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<Question> arrayAdapter =
                new ArrayAdapter<Question>(this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        new ArrayList<Question>());
        setListAdapter(arrayAdapter);
    }

    public void onClick (View view){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.34:3300/service/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // prepare call in Retrofit 2.0
        StackOverflowAPI stackOverflowAPI = retrofit.create(StackOverflowAPI.class);

        Call<FooResponse> call = stackOverflowAPI.postJson("1.0.0", "20160706212200000025","0828484345");

       // Call<StackOverflowQuestions> call = stackOverflowAPI.loadQuestions("android");
        //asynchronous call
        call.enqueue(new Callback<FooResponse>() {
            @Override
            public void onResponse(Call<FooResponse> call, Response<FooResponse> response) {


                Log.d("success",response.body().getSuccess());

            }

            @Override
            public void onFailure(Call<FooResponse> call, Throwable t) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setProgressBarIndeterminateVisibility(true);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // prepare call in Retrofit 2.0
        StackOverflowAPI stackOverflowAPI = retrofit.create(StackOverflowAPI.class);

        Call<StackOverflowQuestions> call = stackOverflowAPI.loadQuestions("android");
        //asynchronous call
        //call.enqueue(this);

        // synchronous call would be with execute, in this case you
        // would have to perform this outside the main thread
        // call.execute()

        // to cancel a running request
        // call.cancel();
        // calls can only be used once but you can easily clone them
        //Call<StackOverflowQuestions> c = call.clone();
        //c.enqueue(this);

        return true;
    }
}
