package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewbinding.databinding.ActivityCountingBinding

class Counting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCountingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var new="0"
        var old="0"
        binding.btn0.setOnClickListener {
            new+="0"
            binding.result.text=new
        }
        binding.btn1.setOnClickListener {
            new+="1"
            binding.result.text=new
        }
        binding.btn2.setOnClickListener {
            new+="2"
            binding.result.text=new
        }
        binding.btn3.setOnClickListener {
            new+="3"
            binding.result.text=new
        }
        binding.btn4.setOnClickListener {
            new+="4"
            binding.result.text=new
        }
        binding.btn5.setOnClickListener {
            new+="5"
            binding.result.text=new
        }
        binding.btn6.setOnClickListener {
            new+="6"
            binding.result.text=new
        }
        binding.btn7.setOnClickListener {
            new+="7"
            binding.result.text=new
        }
        binding.btn8.setOnClickListener {
            new+="8"
            binding.result.text=new
        }
        binding.btn9.setOnClickListener {
            new+="9"
            binding.result.text=new
        }

        binding.btnP.setOnClickListener {
            old=(old.toInt()+new.toInt()).toString()
            new="0"
            binding.result.text=old
        }
        binding.btnE.setOnClickListener {
            new="0"
            old="0"
            binding.result.text="0"
        }
    }
}