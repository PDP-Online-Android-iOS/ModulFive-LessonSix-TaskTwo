package dev.ogabek.java.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.adapter.BookAdapter;
import dev.ogabek.java.adapter.EssentialAdapter;
import dev.ogabek.java.adapter.ImageAdapter;
import dev.ogabek.java.model.Book;
import dev.ogabek.java.model.Essential;
import dev.ogabek.java.model.Image;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView, rv_fashion, rv_popular, rv_books;
    private LinearLayout fashion, popular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_essential);
        rv_fashion = findViewById(R.id.rv_ll_fashion);
        rv_popular = findViewById(R.id.rv_ll_popular);
        rv_books = findViewById(R.id.rv_books);
        fashion = findViewById(R.id.ll_fashion);
        popular = findViewById(R.id.ll_popular);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);

        rv_fashion.setLayoutManager(new GridLayoutManager(this, 2));
        rv_popular.setLayoutManager(new GridLayoutManager(this, 2));
        rv_books.setLayoutManager(new GridLayoutManager(this, 1));

        rv_popular.setAdapter(new ImageAdapter(this, getPopular()));
        rv_fashion.setAdapter(new ImageAdapter(this, getFashion()));
        rv_books.setAdapter(new BookAdapter(getBooks()));


        refreshAdapter(recyclerView, getEssentials());

        setLinearHeight(fashion);
        setLinearHeight(popular);
    }

    private List<Image> getFashion() {
        List<Image> images = new ArrayList<>();
        images.add(new Image(R.drawable.sneaker_1));
        images.add(new Image(R.drawable.sneaker_2));
        images.add(new Image(R.drawable.sneaker_3));
        images.add(new Image(R.drawable.sneaker_2));
        return images;
    }

    private List<Image> getPopular() {
        List<Image> images = new ArrayList<>();
        images.add(new Image(R.drawable.camera_1));
        images.add(new Image(R.drawable.camera_2));
        images.add(new Image(R.drawable.camera_3));
        images.add(new Image(R.drawable.camera_4));
        return images;
    }

    private void setLinearHeight(LinearLayout layout) {
        //Get Screen width programmatically
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightPixels = displayMetrics.heightPixels;

        //Change pixel to dp
        int heightInDp = (int) (heightPixels / getResources().getDisplayMetrics().density);

        //Set layout with programmatically
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.height = heightInDp;
        layout.setLayoutParams(params);
    }

    public void setImageHeight(ImageView image) {
        //Get Screen width programmatically
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightPixels = displayMetrics.heightPixels;

        //Change pixel to dp
        int heightInDp = (int) (heightPixels / getResources().getDisplayMetrics().density);

        //Set layout with programmatically
        ViewGroup.LayoutParams params = image.getLayoutParams();
        params.height = (heightInDp / 2) - 52;
        image.setLayoutParams(params);
    }

    private void refreshAdapter(RecyclerView recyclerView, List<Essential> essentials) {
        EssentialAdapter adapter = new EssentialAdapter(essentials);
        recyclerView.setAdapter(adapter);
    }

    private List<Essential> getEssentials() {
        List<Essential> essentials = new ArrayList<>();
        essentials.add(new Essential("Oculus", R.drawable.game));
        essentials.add(new Essential("Game", R.drawable.game));
        essentials.add(new Essential("Mobile", R.drawable.game));
        return essentials;
    }

    private List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(R.drawable.book_milk_and_honey, "Milk and Honey", 5.06F, 0));
        books.add(new Book(R.drawable.book_wabi_sabi, "Wabi Sabi", 3.55F, 7.99F));
        books.add(new Book(R.drawable.book_thinking_fast_and_slow, "Think fast and slow", 4.59F, 7.99F));
        return books;
    }

}