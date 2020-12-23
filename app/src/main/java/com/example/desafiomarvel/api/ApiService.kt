package com.example.desafiomarvel.api

import com.example.desafiomarvel.utils.Constants.Api.BASE_URL
import com.example.desafiomarvel.utils.Constants.Api.PRIVATE_KEY
import com.example.desafiomarvel.utils.Constants.Api.PUBLIC_KEY
import com.example.desafiomarvel.utils.md5
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object ApiService {
    val marvelApi = getMarvevelApiClient().create(MarvelApi::class.java)
}

private fun getMarvevelApiClient(): Retrofit{
       return Retrofit.Builder()
               .baseUrl(BASE_URL)
               .client(getIntercepetorClient())
               .addConverterFactory(GsonConverterFactory.create())
               .build()
}

private fun getIntercepetorClient(): OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    val ts = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
        val interceptor = OkHttpClient.Builder()
                .connectTimeout(5,java.util.concurrent.TimeUnit.SECONDS)
                .readTimeout(10,java.util.concurrent.TimeUnit.SECONDS)
                .writeTimeout(10,java.util.concurrent.TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor {chain ->
                    val original = chain.request()
                    val originalHtppUrl = original.url()

                    val url = originalHtppUrl.newBuilder()
                            .addQueryParameter("apikey",PUBLIC_KEY)
                            .addQueryParameter("ts",ts)
                            .addQueryParameter("hash","$ts$PRIVATE_KEY$PUBLIC_KEY".md5())
                            .build()
                            chain.proceed(original.newBuilder().url(url).build())

                }
    return interceptor.build()

}