package com.example.viewbinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.viewbinding.databinding.ActivityResourceBinding


class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResourceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context:Context
        val ment = resources.getString(R.string.my_name)
        Log.d("mentt","ment : "+ment)

        val ment2 = getString(R.string.my_name)
        Log.d("mentt","ment : "+ment2)

        val color = getColor(R.color.mycolor)
        Log.d("mentt","color : "+color)

        binding.btn1.setBackgroundColor(getColor(R.color.mycolor))

    }
}