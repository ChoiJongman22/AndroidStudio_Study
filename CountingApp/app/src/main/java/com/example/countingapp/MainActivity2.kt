package com.example.countingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var new="0"
        var old="0"
        btn1.setOnClickListener {
            new +="1"
            result.text=new
        }
        btn2.setOnClickListener {
            new +="2"
            result.text=new
        }
        btn3.setOnClickListener {
            new += "3"
            result.text = new
        }
        btn4.setOnClickListener {
            new += "4"
            result.text = new
        }
        btn5.setOnClickListener {
            new += "5"
            result.text = new
        }
        btn6.setOnClickListener {
            new += "6"
            result.text = new
        }
        btn7.setOnClickListener {
            new += "7"
            result.text = new
        }
        btn8.setOnClickListener {
            new += "8"
            result.text = new
        }
        btn9.setOnClickListener {
            new += "9"
            result.text = new
        }
        btn0.setOnClickListener {
            new += "0"
            result.text = new
        }
        btnP.setOnClickListener {
            old=(old.toInt()+new.toInt()).toString()
            new="0"
            result.text=old
        }
        btnC.setOnClickListener{
            new="0"
            old="0"
            result.text="0"
        }
    }
}