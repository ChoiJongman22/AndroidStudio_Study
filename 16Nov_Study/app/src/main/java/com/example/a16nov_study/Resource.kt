package com.example.a16nov_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_resource.*

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        val ment = resources.getString(R.string.hello)
        Log.d("mentt","ment : "+ment)

        val ment2 = getString(R.string.hello)
        Log.d("mentt","ment : "+ment2)

        val color = getColor(R.color.text_view)
        Log.d("mentt","color : "+color)

        btn1.setBackgroundColor(getColor(R.color.text_view))

    }
}