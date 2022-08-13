package br.com.stefick.i30m.base.interceptors

import br.com.stefick.i30m.shared.base.DeveloperKey
import okhttp3.Interceptor
import okhttp3.Response

class DefaultInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val oldRequest = chain.request()

        val newRequest = oldRequest.newBuilder()
            .addHeader("x-api-key", DeveloperKey.catKey)
            .build()

        return chain.proceed(newRequest)
    }
}