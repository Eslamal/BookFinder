package com.example.bookfinder.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.bookfinder.R;
import com.example.bookfinder.adapters.BookAdapter;
import com.example.bookfinder.viewmodel.BookViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bookAdapter = new BookAdapter(new ArrayList<>(), book -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("BOOK", book);
            startActivity(intent);
        });

        recyclerView.setAdapter(bookAdapter);

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getBooks("android").observe(this, books -> bookAdapter.updateBooks(books));
    }
}
