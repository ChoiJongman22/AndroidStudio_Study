package com.example.a16nov_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafety : AppCompatActivity() {

    lateinit var lateCar : Car
    class Car(var number:Int){

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

        lateCar=Car(10) //반드시 사용하기 전에 초기화 해줘야 한다.
        Log.d("number","late number : "+lateCar.number)


    }

    fun plus(a:Int,b:Int?):Int{
        if(b != null) return a + b
        else return a
    }

    fun plus2(a:Int,b:Int?):Int?
    {
        return b?.plus(a)
    }
}