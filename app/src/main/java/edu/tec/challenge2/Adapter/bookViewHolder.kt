package edu.tec.challenge2.Adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.tec.challenge2.Response.Book
import edu.tec.challenge2.Response.newResponse
import edu.tec.challenge2.databinding.RenglonNewYorkBinding

class bookViewHolder(view: View):RecyclerView.ViewHolder(view){

    private val  binding = RenglonNewYorkBinding.bind(view)

    fun bind(property: Book){
        val title = binding.tvTitle
        val imageView = binding.imageView
        val description = binding.tvDescription


        Glide.with(binding.root)
            .load(property.book_image)
            .circleCrop()
            .into(imageView)

        // property  la prpiedad del libro
        title.text = property.title
        description.text = property.description

    }

    // pasar datos



}