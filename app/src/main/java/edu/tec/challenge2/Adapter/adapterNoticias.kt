package edu.tec.challenge2.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.tec.challenge2.R
import edu.tec.challenge2.Response.Book
import edu.tec.challenge2.Response.newResponse

// esta es la propiedad que se le da al adapter, lo que te regresa el servicio es un objeto book
class adapterNoticias(var libros: List<Book>): RecyclerView.Adapter<bookViewHolder>() {

    fun setLibro(books: List<Book>){
        libros = books.take(10)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bookViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.renglon_new_york, parent, false )
        return bookViewHolder(view)

    }

    override fun onBindViewHolder(holder: bookViewHolder, position: Int) {
        val libroURl = libros[position]
        holder.bind(libroURl)
    }

    override fun getItemCount(): Int {

        return  libros.size
    }
}