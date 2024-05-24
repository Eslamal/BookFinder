package com.example.bookfinder.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookRepository {
    private BookApi bookApi;

    public BookRepository() {
        bookApi = RetrofitClient.getRetrofitInstance().create(BookApi.class);
    }

    public void getBooks(String query, final OnBooksReceivedCallback callback) {
        Call<BookResponse> call = bookApi.getBooks(query);
        call.enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onReceived(response.body().getItems());
                }
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {
                callback.onReceived(null);
            }
        });
    }

    public interface OnBooksReceivedCallback {
        void onReceived(List<Book> bookList);
    }
}

