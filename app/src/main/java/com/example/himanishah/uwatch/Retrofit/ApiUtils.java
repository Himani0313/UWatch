package com.example.himanishah.uwatch.Retrofit;

/**
 * Created by himanishah on 9/16/17.
 */

public class ApiUtils {
    public static final String BASE_URL = "https://api.themoviedb.org/3/search/";

    public static ExampleApi getExampleApi() {
        return RestClient.getClient(BASE_URL).create(ExampleApi.class);
    }
}
