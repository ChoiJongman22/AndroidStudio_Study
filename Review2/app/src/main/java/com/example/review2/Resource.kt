package com.example.review2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_frag1.*

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        val ment=getString(R.string.blo)
        Log.d("mentt","ment: "+ment)

        val color1=getColor(R.color.textview)
        btn2.setBackgroundColor(getColor(R.color.textview))
    }
}