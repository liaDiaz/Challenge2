package edu.tec.challenge2.Pattern

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//"hardcover-fiction.json?api-key=mEelBm9BnACiHwCmZ3ec4VUdBpPA5jWW"
// retrofit es el que hace la llamaday consume el json
object retofitSingelton {
    val constante = "Estoy en singleton"
    fun getRetrofit(): Retrofit {
        //esto es para la conecoioon con ek servicio simpre se debe temrianr con diagonal
        //El converter es para convertir el json al local
        return Retrofit.Builder().baseUrl("https://api.nytimes.com/svc/books/v3/lists/current/").addConverterFactory(
            GsonConverterFactory.create())
            .build()
    }
}

fun main(args: Array<String>) {


}