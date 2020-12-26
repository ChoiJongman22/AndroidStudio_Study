package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewbinding.databinding.ActivityRetrofitLibraryBinding

class RetrofitLibrary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRetrofitLibraryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}