package com.example.a26nov_study

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent2.*


class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)



        result1.setOnClickListener {
            val number1=intent.getIntExtra("number1",0)
            val number2=intent.getIntExtra("number2",0)

            Log.d("number","" + number1)
            Log.d("number",""+ number2)

            val result=number1+number2
            val resultIntent= Intent()
            resultIntent.putExtra("result",result)
            setResult(Activity.RESULT_OK,resultIntent)//RESULT_OK는 -1을 나타냄. 잘 받았어.
            finish()//Activity 종료

            //스택의 개념
            //Intent2 -> 종료
            //Intent1        Intent1

        }

    }
}