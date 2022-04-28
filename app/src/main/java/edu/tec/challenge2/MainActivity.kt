package edu.tec.challenge2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.tec.challenge2.Adapter.adapterNoticias
import edu.tec.challenge2.MVVM.librosMVVM
import edu.tec.challenge2.Response.Book
import edu.tec.challenge2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: adapterNoticias
    private lateinit var binding: ActivityMainBinding
    private  val libros = mutableListOf<Book>()
    private lateinit var viewModel: librosMVVM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initViewModel()
        viewModel.newAPICall()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel(){
        //crea un provider que es la clase que resulvel para crear el viewModel
        viewModel = ViewModelProvider(this).get(librosMVVM::class.java)
        viewModel.getLiveDataObserver().observe(this,{
            if(it != null){
                //para poder actulizar ilibros
                    Log.v("libros", it.results.books.toString())
                adapter.setLibro(it.results.books)
                adapter.notifyDataSetChanged()
            }
        })
    }

    //esto es para darle al adapter el layorut y el adaptador
    private fun initAdapter(){
        adapter = adapterNoticias(libros)
        // esto es solo para la conexion del renglon al layout +
        binding.listaLibros.layoutManager =  LinearLayoutManager(this)
        binding.listaLibros.adapter = adapter

        // buscarPerrosPorRaza("labrador")
        //unir o darle el listener a la barra de busqueda



    }




    // este es mejor porque este es cuando ya da el aceptar a la busqueda



    // no es muy recomdable por que es con cada tecleo de letra




}