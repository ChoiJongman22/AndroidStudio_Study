package com.example.review2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button11.setOnClickListener {
            Toast.makeText(this@MainActivity,"좋은 어플",Toast.LENGTH_SHORT).show()
        }


    }
}
