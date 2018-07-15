package com.example.root.submission1catalougemovie.Rest.GAS;

import com.example.root.submission1catalougemovie.Model.MovieModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie?api_key=0dde3e9896a8c299d142e214fcb636f8&language=en-US")
    Call<MovieModel>getMovie(@Query("query") String query);
}
