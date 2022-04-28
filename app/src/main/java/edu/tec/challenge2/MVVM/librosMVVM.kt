package edu.tec.challenge2.MVVM

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.tec.challenge2.Pattern.retofitSingelton
import edu.tec.challenge2.Response.Book
import edu.tec.challenge2.Response.Books
import edu.tec.challenge2.Response.newResponse
import edu.tec.challenge2.Service.newsAPIService

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class librosMVVM: ViewModel() {
    var liveData : MutableLiveData<newResponse>
    //junta lo local con el servicio

    init {
        liveData = MutableLiveData()
    }
    // el observer es para cambios de datos a la vista
    fun getLiveDataObserver(): MutableLiveData<newResponse> {
        return liveData
    }

    fun newAPICall(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = retofitSingelton.getRetrofit().create(newsAPIService::class.java).getBooks()

            call.enqueue(object : Callback<newResponse> {
                override fun onResponse(call: Call<newResponse>, response: Response<newResponse>) {
                    //regresa el new response de lista, ya que tiene el repsonse dentro la lista, esta es cuando ya te respondio el servicio y tienes los datos para contestar
                   Log.v("libro", response.body()?.results?.books.toString())
                    liveData.postValue(response.body() )
                }
                //call : regresa

                override fun onFailure(call: Call<newResponse>, t: Throwable) {
                    liveData.postValue(null)
                    Log.v("libro","no hay resultados")
                    //llega a fallar
                }

            })

        }
    }

}