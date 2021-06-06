package uz.uzsoft.qqbtrans.data.sourse.retrofit

import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.uzsoft.qqbtrans.app.App
import uz.uzsoft.qqbtrans.data.sourse.local.sharedPreference.LocalStorage

object ApiClientAuthConfirm {
    private val logging =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    private val data = LocalStorage.getInstance()
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .addInterceptor(ChuckInterceptor(App.instance))
        .addInterceptor {
            val requestOld = it.request()
            val request = requestOld.newBuilder()
                .removeHeader("token_uuid")
                .addHeader("token_uuid", data.getTokenUuid()!!)
                .build()
            val response = it.proceed(request)
            response
        }
        .build()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://2b5ad90acf1d.ngrok.io")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}