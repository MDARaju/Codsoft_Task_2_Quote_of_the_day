package com.quoteoftheday;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavQuo extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_quo);

        recyclerView = findViewById(R.id.favRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load starred quotes from JSON or other storage
        List<String> starredQuotesList = Quote.getStarredQuotesList();

        FavQuoteAdapter adapter = new FavQuoteAdapter(starredQuotesList);
        recyclerView.setAdapter(adapter);
    }
}
