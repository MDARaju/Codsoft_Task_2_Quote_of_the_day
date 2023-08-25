package com.quoteoftheday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private Button refreshButton, shofavquo;
    private ImageButton starButton, shareButton;

    boolean isStarOn = false; // Initial state

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.Teca);
        refreshButton = findViewById(R.id.refreshquote);
        shofavquo = findViewById(R.id.favoritequote);

        starButton = findViewById(R.id.starButton);
        shareButton = findViewById(R.id.shareButton);

        FloatingActionButton fabab = findViewById(R.id.fabAbout);

        setRandomQuote();

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRandomQuote();
                isStarOn = false; // Reset the star button state to off
                starButton.setImageResource(android.R.drawable.btn_star_big_off);
            }
        });

        shofavquo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FavQuo.class);
                startActivity(i);
            }
        });

        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarOn) {
                    starButton.setImageResource(android.R.drawable.btn_star_big_off);
                    Quote.removeStarredQuote(quoteTextView.getText().toString(), MainActivity.this);
                } else {
                    starButton.setImageResource(android.R.drawable.btn_star_big_on);
                    Quote.starQuote(quoteTextView.getText().toString());
                }
                isStarOn = !isStarOn; // Toggle the state

                // Save the starred quotes to JSON after modifying the list
                Quote.saveStarredQuotesToJson(MainActivity.this);
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quoteToShare = quoteTextView.getText().toString();

                // Create a sharing Intent
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Quote of the Day");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, quoteToShare);

                // Start the sharing activity
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        fabab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, about.class);
                startActivity(i);
            }
        });
    }

    private void setRandomQuote() {
        List<String> quoteList = Quote.getQuoteList();
        int randomIndex = new Random().nextInt(quoteList.size());
        String randomQuote = quoteList.get(randomIndex);
        quoteTextView.setText(randomQuote);
    }
}
