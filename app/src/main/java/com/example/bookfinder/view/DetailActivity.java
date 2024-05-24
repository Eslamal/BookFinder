package com.example.bookfinder.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookfinder.R;
import com.example.bookfinder.model.Book;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private TextView title;
    private TextView authors;
    private TextView description;
    private ImageView thumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = findViewById(R.id.title);
        authors = findViewById(R.id.authors);
        description = findViewById(R.id.description);
        thumbnail = findViewById(R.id.thumbnail);


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("BOOK")) {
            Book book = (Book) intent.getSerializableExtra("BOOK");
            displayBookDetails(book);
        }
    }

    private void displayBookDetails(Book book) {
        if (book != null) {
            title.setText(book.getVolumeInfo().getTitle());
            authors.setText(TextUtils.join(", ", book.getVolumeInfo().getAuthors()));
            description.setText(book.getVolumeInfo().getDescription());
            String thumbnailUrl = book.getVolumeInfo().getImageLinks().getThumbnail();
            if (thumbnailUrl != null && !thumbnailUrl.isEmpty()) {
                Picasso.get().load(thumbnailUrl).into(thumbnail);
            } else {
                thumbnail.setImageResource(R.drawable.ic_launcher_foreground);
            }
        }
    }
}
