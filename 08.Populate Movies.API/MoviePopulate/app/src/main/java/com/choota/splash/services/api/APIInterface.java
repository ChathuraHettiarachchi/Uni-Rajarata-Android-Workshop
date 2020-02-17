package com.choota.splash.services.api;

import com.choota.splash.services.api.response.PopularMoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    // get popular movies
    @GET("movie/popular")
    Call<PopularMoviesResponse> popularMovies(@Query("api_key") String api_key);
}
