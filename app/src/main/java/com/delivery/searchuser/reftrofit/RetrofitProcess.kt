package com.delivery.searchuser.reftrofit

import com.delivery.searchuser.reftrofit.CustomGsonBuilder.getCustomConverter
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import pl.gumyns.retrofit_progress.ProgressConverterFactory
import pl.gumyns.retrofit_progress.ProgressInterceptor
import pl.gumyns.retrofit_progress.ProgressListenerPool
import retrofit2.Response
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object RetrofitProcess {
    var baseUrl = "https://api.github.com"
    fun retrofit(): ApiService {
        var builder = Retrofit.Builder()
            .addConverterFactory(getCustomConverter())
            .baseUrl(baseUrl)
        var client = OkHttpClient.Builder().apply {
            connectTimeout(40, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            protocols(listOf(Protocol.HTTP_2, Protocol.HTTP_1_1))
            retryOnConnectionFailure(false)
        }.build()
        builder.client(client)
        return builder.build().create(ApiService::class.java)
    }

    fun <T : Any> callApi(block: () -> Response<T>) : T?{
        var result = block()
        if(result.isSuccessful) {
            return result.body()
        }else {
            return null
        }
    }

}