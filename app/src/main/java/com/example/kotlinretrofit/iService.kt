package com.example.kotlinretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface iService {

   // @GET("albums/1/photos")
   // fun getAlbum(): Call<List<Album>>
   @GET("albums/1/photos")
   suspend fun getAlbum(): List<Album>

    @GET("albums/{id}/photos")
    fun getUserAlbum(@Path("id") userId: Int): Call<List<Album>>
}