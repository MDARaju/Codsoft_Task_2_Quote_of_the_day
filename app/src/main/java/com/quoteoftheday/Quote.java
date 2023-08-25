package com.quoteoftheday;

import com.google.gson.Gson;
import android.content.Context;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Quote {

    private static final String STARRED_QUOTES_JSON_FILE = "starred_quotes.json";

    private static List<String> quoteList = new ArrayList<>();
    private static List<String> starredQuotesList = new ArrayList<>();

    static {
        quoteList.add("The only way to do great work is to love what you do.");
        quoteList.add("Success is not final, failure is not fatal: It is the courage to continue that counts.");
        quoteList.add("For we live by faith, not by sight.\n");
        quoteList.add("If God is for us, who can be against us?\n");
        quoteList.add("There is no fear in love. But perfect love drives out fear, because fear has to do with punishment. The one who fears is not made perfect in love.\n");
        quoteList.add(" But you, Lord, are a shield around me, my glory, the One who lifts my head high.\n");
        quoteList.add(" Ask, and it shall be given you; seek, and you shall find.\n");
        quoteList.add(" There's no place like home.\n");// Add more quotes here
    }

    public static List<String> getQuoteList() {
        return quoteList;
    }

    public static List<String> getStarredQuotesList() {
        return starredQuotesList;
    }

    public static void starQuote(String quote) {
        starredQuotesList.add(quote);
    }

    public static void removeStarredQuote(String quote, Context context) {
        starredQuotesList.remove(quote);
        saveStarredQuotesToJson(context); // Save the changes to JSON
    }

    public static void saveStarredQuotesToJson(Context context) {
        Gson gson = new Gson();
        String starredQuotesJson = gson.toJson(starredQuotesList);

        try {
            FileWriter fileWriter = new FileWriter(new File(context.getFilesDir(), STARRED_QUOTES_JSON_FILE));
            fileWriter.write(starredQuotesJson);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
