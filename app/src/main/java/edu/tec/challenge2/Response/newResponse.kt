package edu.tec.challenge2.Response

import com.google.gson.annotations.SerializedName

//data class newResponse(@SerializedName("books") var books : List<Books>)

data class Book(val rank: Int,
                val title: String,
                val description: String,
                val book_image: String)

//data class Books(var libros: List<Book>)

data class newResponse(
    val status: String,
    val results: Books
)

data class Books(
    val books: List<Book>
)

