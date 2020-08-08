package com.example.kotlinretrofit

class Repository {

    var service: iService = RetrofitInstance.getRetrofitInstance()!!.create(iService::class.java)

    suspend fun getAlbum() = service.getAlbum()
}
