package com.example.exhttp

import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

// init 키워드 , object 키워드, 빌더 패턴, 레트로핏 생성 방법
object HttpCore {
    val api: Retrofit
    val baseUrl = "http://httpbin.org"

    init {
        var okHttpClient = OkHttpClient()
                .newBuilder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY }
                )
                .build()

        api = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    //1.
    fun getHttpCore() = api.create(SampleApi::class.java)

    inline fun <reified T>getUsingGeneric1()  = api.create(T::class.java)
    fun getUsingGeneric2(clazz: Class<*>) = api.create(clazz::class.java)
}


interface SampleApi{
    //TODO http://httpbin.org/get  [url]로 요청을 보냄
    @GET("/get")
    fun getSample() : Single<Model>
}



data class Model(
    var url : String,
    var header : Header,
    var args :Args,
    var origin : String
)

//ex
data class Header(
    var some : String? = null
)

data class Args(
    var some : String?= null
)