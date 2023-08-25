package com.quoteoftheday;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FavQuoteAdapter extends RecyclerView.Adapter<FavQuoteAdapter.QuoteViewHolder> {

    private List<String> starredQuotesList;

    public FavQuoteAdapter(List<String> starredQuotesList) {
        this.starredQuotesList = starredQuotesList;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fav_quote, parent, false);
        return new QuoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        String quote = starredQuotesList.get(position);
        holder.favQuoteTextView.setText(quote);
    }

    @Override
    public int getItemCount() {
        return starredQuotesList.size();
    }

    public class QuoteViewHolder extends RecyclerView.ViewHolder {
        TextView favQuoteTextView;

        public QuoteViewHolder(@NonNull View itemView) {
            super(itemView);
            favQuoteTextView = itemView.findViewById(R.id.favQuoteTextView);
        }
    }
}
