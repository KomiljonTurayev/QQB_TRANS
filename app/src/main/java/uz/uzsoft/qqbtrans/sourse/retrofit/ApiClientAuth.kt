package uz.uzsoft.qqbtrans.sourse.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientAuth {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://2b5ad90acf1d.ngrok.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}