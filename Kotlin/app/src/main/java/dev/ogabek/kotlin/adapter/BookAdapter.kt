package dev.ogabek.kotlin.adapter

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.model.Book

class BookAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val book: Book = books[position]
        if (holder is BookViewHolder) {
            holder.photo.setImageResource(book.image)
            holder.name.text = book.name
            holder.dollar.text = book.dollar
            holder.cent.text = book.cent
            if (book.oldPrice == 0f) {
                holder.oldPrice.visibility = View.GONE
            } else {
                holder.oldPrice.visibility = View.VISIBLE
            }
            holder.oldPrice.text = "$" + book.oldPrice
            holder.oldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    override fun getItemCount(): Int {
        return books.size
    }

    private class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var photo: ImageView = view.findViewById(R.id.iv_book)
        var name: TextView = view.findViewById(R.id.tv_book_name)
        var dollar: TextView = view.findViewById(R.id.tv_dollar)
        var cent: TextView = view.findViewById(R.id.tv_cent)
        var oldPrice: TextView = view.findViewById(R.id.tv_book_old_price)
    }

}