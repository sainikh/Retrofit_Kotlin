package com.example.retrofit_kotlin

import retrofit2.Call
import retrofit2.http.GET

interface NorrisClient {

@GET("jokes/random")
    fun getData() : Call<NorrisData>

}

