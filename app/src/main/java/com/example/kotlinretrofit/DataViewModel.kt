package com.example.kotlinretrofit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers



class DataViewModel(application :Application) : AndroidViewModel(application) {

    private val repository : Repository = Repository()
    val albumList : LiveData<List<Album>> = liveData(Dispatchers.IO){
        val result = repository.getAlbum()
        emit(result)
    }
}