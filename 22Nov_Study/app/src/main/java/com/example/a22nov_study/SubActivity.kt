package com.example.a22nov_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)



        hello.setOnClickListener {
            Log.d("Hello!","뜌앙")
            hello.text="GoodBye"
        }

        btn1.setOnClickListener {
            Toast.makeText(this, "버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show()
        }

        btn2.setOnClickListener {
            Toast.makeText(this, "버튼을 눌렀어.", Toast.LENGTH_SHORT).show()
        }
    }
}

