package com.example.himanishah.uwatch.Retrofit;

import com.example.himanishah.uwatch.POJO.MovieId;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by himanishah on 9/16/17.
 */

public interface ExampleApi {

    @GET("movie?api_key=f268210d8cf90cbc81040df1466d853c&")
    Call<List<MovieId>> getMovieId(@Query("query") String name);
}
