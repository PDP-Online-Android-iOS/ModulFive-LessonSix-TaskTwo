package dev.ogabek.kotlin.model

class Book(val image: Int, val name: String, price: Float, val oldPrice: Float) {
    val dollar: String = price.toInt().toString()
    val cent: String = price.toString().substring(price.toString().indexOf('.') + 1)
}