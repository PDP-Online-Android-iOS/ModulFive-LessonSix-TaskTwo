package dev.ogabek.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.adapter.BookAdapter
import dev.ogabek.kotlin.adapter.EssentialAdapter
import dev.ogabek.kotlin.adapter.ImageAdapter
import dev.ogabek.kotlin.model.Book
import dev.ogabek.kotlin.model.Essential
import dev.ogabek.kotlin.model.Image

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rv_fashion: RecyclerView
    private lateinit var rv_popular: RecyclerView
    private lateinit var rv_books: RecyclerView
    private lateinit var fashion: LinearLayout
    private lateinit var popular: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.rv_essential)
        rv_fashion = findViewById(R.id.rv_ll_fashion)
        rv_popular = findViewById(R.id.rv_ll_popular)
        rv_books = findViewById(R.id.rv_books)
        fashion = findViewById(R.id.ll_fashion)
        popular = findViewById(R.id.ll_popular)
        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = manager
        rv_fashion.layoutManager = GridLayoutManager(this, 2)
        rv_popular.layoutManager = GridLayoutManager(this, 2)
        rv_books.layoutManager = GridLayoutManager(this, 1)
        rv_popular.adapter = ImageAdapter(this, getPopular())
        rv_fashion.adapter = ImageAdapter(this, getFashion())
        rv_books.adapter = BookAdapter(books())
        refreshAdapter(recyclerView, essentials())
        setLinearHeight(fashion)
        setLinearHeight(popular)
    }

    private fun getFashion(): List<Image> {
        val images: MutableList<Image> = ArrayList()
        images.add(Image(R.drawable.sneaker_1))
        images.add(Image(R.drawable.sneaker_2))
        images.add(Image(R.drawable.sneaker_3))
        images.add(Image(R.drawable.sneaker_2))
        return images
    }

    private fun getPopular(): List<Image> {
        val images: MutableList<Image> = ArrayList()
        images.add(Image(R.drawable.camera_1))
        images.add(Image(R.drawable.camera_2))
        images.add(Image(R.drawable.camera_3))
        images.add(Image(R.drawable.camera_4))
        return images
    }

    private fun setLinearHeight(layout: LinearLayout?) {
        //Get Screen width programmatically
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightPixels = displayMetrics.heightPixels

        //Change pixel to dp
        val heightInDp = (heightPixels / resources.displayMetrics.density).toInt()

        //Set layout with programmatically
        val params = layout!!.layoutParams
        params.height = heightInDp
        layout.layoutParams = params
    }

    fun setImageHeight(image: ImageView) {
        //Get Screen width programmatically
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightPixels = displayMetrics.heightPixels

        //Change pixel to dp
        val heightInDp = (heightPixels / resources.displayMetrics.density).toInt()

        //Set layout with programmatically
        val params = image.layoutParams
        params.height = heightInDp / 2 - 52
        image.layoutParams = params
    }

    private fun refreshAdapter(recyclerView: RecyclerView?, essentials: List<Essential>) {
        val adapter = EssentialAdapter(essentials)
        recyclerView!!.adapter = adapter
    }

    private fun essentials(): List<Essential> {
        val essentials: MutableList<Essential> = ArrayList()
        essentials.add(Essential("Oculus", R.drawable.game))
        essentials.add(Essential("Game", R.drawable.game))
        essentials.add(Essential("Mobile", R.drawable.game))
        return essentials
    }

    private fun books(): List<Book> {
        val books: MutableList<Book> = ArrayList()
        books.add(Book(R.drawable.book_milk_and_honey, "Milk and Honey", 5.06f, 0F))
        books.add(Book(R.drawable.book_wabi_sabi, "Wabi Sabi", 3.55f, 7.99f))
        books.add(Book(R.drawable.book_thinking_fast_and_slow, "Think fast and slow", 4.59f, 7.99f))
        return books
    }

}