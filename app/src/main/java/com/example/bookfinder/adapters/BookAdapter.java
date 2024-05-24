package com.example.bookfinder.adapters;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookfinder.R;
import com.example.bookfinder.model.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<Book> books;
    private OnBookClickListener listener;

    public BookAdapter(List<Book> books, OnBookClickListener listener) {
        this.books = books;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bind(books.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void updateBooks(List<Book> newBooks) {
        books = newBooks;
        notifyDataSetChanged();
    }

    public interface OnBookClickListener {
        void onBookClick(Book book);
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView authors;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            authors = itemView.findViewById(R.id.authors);
        }

        public void bind(final Book book, final OnBookClickListener listener) {
            title.setText(book.getVolumeInfo().getTitle());
            authors.setText(TextUtils.join(", ", book.getVolumeInfo().getAuthors()));
            itemView.setOnClickListener(v -> listener.onBookClick(book));
        }
    }
}

