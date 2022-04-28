package edu.tec.challenge2.Service

import edu.tec.challenge2.Response.Book
import edu.tec.challenge2.Response.Books
import edu.tec.challenge2.Response.newResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface newsAPIService {
    @GET("hardcover-fiction.json?api-key=mEelBm9BnACiHwCmZ3ec4VUdBpPA5jWW")
    fun getBooks():
            //ESTO ES COMO LO VA A MANDAR, LA RESPUESTA
            Call<newResponse>
}