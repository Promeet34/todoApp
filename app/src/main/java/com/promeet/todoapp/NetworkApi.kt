package com.promeet.todoapp

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NetworkApi {

    @GET("todo.php")
    fun todoApi(): Single<MutableList<TodoModel>>

    data class TodoModel(val content: String,
                         val url: String)


    companion object {

        const val BASE_URL = "http://xxx.raonnet.com/"

        fun create(): NetworkApi {

            val restAdapter = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient(provideLoggingInterceptor()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


            return restAdapter.create(NetworkApi::class.java)
        }

        private fun okHttpClient(
                interceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
                .run {
                    addInterceptor(interceptor)
                    build()
                }

        private fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }
}