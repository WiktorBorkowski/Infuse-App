package com.example.homepage;

import com.example.homepage.ericssonNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface{

    String BASE_URL = "https://newsapi.org/v2/";
    String HARD_URL = "everything?q=ericsson&sortBy=popularity&apiKey=c6ab9f0172164417ac9b5c0aaa524e2a";

    @GET("everything")
    Call<ericssonNews> getNews(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apikey

    );

    @GET("everything")
    Call<ericssonNews> getCategoryNews(
            @Query("q") String keyword,
            @Query("language") String lang,
            @Query("pageSize") int pagesize,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apikey

    );
}
