package com.example.movielist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        with(api) {
            fetchAllMovies().enqueue(object : Callback<List<Movies>> {
                override fun onResponse(call: Call<List<Movies>>, response: Response<List<Movies>>) {
                    showData(response.body()!!)
                   // d("original_title", "OnResponse: ${response.body()!![0].original_title}")
                }

                override fun onFailure(call: Call<List<Movies>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun createRetrofit()= Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = createRetrofit().create(ApiService::class.java)

    private fun showData(Movies: List<Movies>) {
        }


        }

