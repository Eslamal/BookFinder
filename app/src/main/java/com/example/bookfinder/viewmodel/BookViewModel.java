package com.example.bookfinder.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookfinder.model.Book;
import com.example.bookfinder.model.BookRepository;

import java.util.List;

public class BookViewModel extends ViewModel {
    private MutableLiveData<List<Book>> books;
    private BookRepository repository;

    public BookViewModel() {
        repository = new BookRepository();
    }

    public LiveData<List<Book>> getBooks(String query) {
        if (books == null) {
            books = new MutableLiveData<>();
            loadBooks(query);
        }
        return books;
    }

    private void loadBooks(String query) {
        repository.getBooks(query, new BookRepository.OnBooksReceivedCallback() {
            @Override
            public void onReceived(List<Book> bookList) {
                books.setValue(bookList);
            }
        });
    }
}

