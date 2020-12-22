package com.example.viewbinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.viewbinding.databinding.ActivityIntent1Binding

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityIntent1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.change.setOnClickListener {
            val intent=Intent(this@Intent1,Intent2::class.java)
            intent.apply{
                this.putExtra("number1",1)
                this.putExtra("number2",2)
            }

            startActivityForResult(intent,200)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==200){
            Log.d("number","" +requestCode)
            Log.d("number","" +resultCode)
            val result=data?.getIntExtra("result",0)
            Log.d("number",""+result)

        }

    }
}