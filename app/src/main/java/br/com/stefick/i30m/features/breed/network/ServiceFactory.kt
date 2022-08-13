package br.com.stefick.i30m.features.breed.network

import br.com.stefick.i30m.base.BaseServiceFactory
import br.com.stefick.i30m.base.interceptors.DefaultInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

abstract class ServiceFactory<T>(apiType: Class<T>) : BaseServiceFactory<T>(apiType) {

    override fun createOkhttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addInterceptor(DefaultInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
    }

}