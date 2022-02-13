package dev.ogabek.java.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.model.Book;

public class BookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Book> books;

    public BookAdapter(List<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Book book = books.get(position);

        if (holder instanceof BookViewHolder) {
            ((BookViewHolder) holder).photo.setImageResource(book.getImage());
            ((BookViewHolder) holder).name.setText(book.getName());
            ((BookViewHolder) holder).dollar.setText(String.valueOf(book.getDollar()));
            ((BookViewHolder) holder).cent.setText(String.valueOf(book.getCent()));
            if (book.getOldPrice() == 0F) {
                ((BookViewHolder) holder).oldPrice.setVisibility(View.GONE);
            } else {
                ((BookViewHolder) holder).oldPrice.setVisibility(View.VISIBLE);
            }
            ((BookViewHolder) holder).oldPrice.setText("$" + book.getOldPrice());
            ((BookViewHolder) holder).oldPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    private static class BookViewHolder extends RecyclerView.ViewHolder {

        ImageView photo;
        TextView name, dollar, cent, oldPrice;

        public BookViewHolder(View view) {
            super(view);

            photo = view.findViewById(R.id.iv_book);
            name = view.findViewById(R.id.tv_book_name);
            dollar = view.findViewById(R.id.tv_dollar);
            cent = view.findViewById(R.id.tv_cent);
            oldPrice = view.findViewById(R.id.tv_book_old_price);

        }
    }
}
