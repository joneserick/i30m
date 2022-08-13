package br.com.stefick.i30m.base

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseServiceFactory<T>(private val apiType: Class<T>) {

    protected val api: T = createApi()

    protected abstract fun createOkhttpClient(): OkHttpClient.Builder

    private fun createApi(): T {
        return Retrofit.Builder()
            .client(createOkhttpClient().build())
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(apiType)
    }

}