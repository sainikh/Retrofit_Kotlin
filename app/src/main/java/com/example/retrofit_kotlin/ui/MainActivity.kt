package com.example.retrofit_kotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.retrofit_kotlin.NorrisClient
import com.example.retrofit_kotlin.NorrisData
import com.example.retrofit_kotlin.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var t1 = findViewById<TextView>(R.id.joke)


        //retrofit
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.chucknorris.io/")
            .build()
            .create(NorrisClient::class.java)

        val retrofitData  = retrofitBuilder.getData()

        //CTRL +shifT + SPACE
        retrofitData.enqueue(object : Callback<NorrisData?> {
            override fun onResponse(call: Call<NorrisData?>, response: Response<NorrisData?>) {
               val responseBody = response.body()!!
              t1.text = responseBody.value
            }

            override fun onFailure(call: Call<NorrisData?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}