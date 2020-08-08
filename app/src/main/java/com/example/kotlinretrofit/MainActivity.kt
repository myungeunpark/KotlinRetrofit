package com.example.kotlinretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName
    lateinit var viewModel : DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)



        button.setOnClickListener {

            viewModel.albumList.observe(this, Observer {

                var ret : List<Album> = it
                extractResponse(ret)
            })
        }
    }

    fun extractResponse(list: List<Album>?) {
        if (list != null) {
            for (album in list) {
                Log.d(TAG, "album id - " + album.albumId)
                Log.d(TAG, "id - " + album.id)
                Log.d(TAG, "title - " + album.title)
                Log.d(TAG, "URL - " + album.url)
                Log.d(TAG, "Thumnail Url - " + album.thumbnailUrl)
                Log.d(TAG, "----------------------------------")
            }
        }
    }
}

