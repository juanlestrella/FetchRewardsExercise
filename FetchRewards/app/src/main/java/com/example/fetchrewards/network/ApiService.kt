package com.example.fetchrewards.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val  BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi)) //convert json to string to kotlin objects
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("hiring.json")
    // suspend to call the method within coroutine
    suspend fun getData() : List<FetchData>
}

// public singleton object, app only need one instance of Retrofit API Service
object Api {
    val retrofitService : ApiService by lazy {
        // init retrofitService
        retrofit.create(ApiService::class.java)
    }
}