package com.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class about extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tv = findViewById(R.id.tv);
        tv.setText("Presenting MDA Raju's CodSoft Internship Creation: 'Quote of the Day' App\n" +
                        "\n" +
                        "I'm excited to introduce a noteworthy creation from my CodSoft Internship— the 'Quote of the Day' app. Crafted by MDA Raju, this app curates inspiring quotes for users, who can mark favorites for easy access anytime. Additionally, users can seamlessly share quotes with their network—be it family, friends, or colleagues—adding a social touch to motivational moments."+
                "\n" +
                        "Sincerely, \n" +
                        "MDA Raju");
    }
}


