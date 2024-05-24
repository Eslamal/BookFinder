package com.example.bookfinder.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookApi {
    @GET("volumes")
    Call<BookResponse> getBooks(@Query("q") String query);
}

