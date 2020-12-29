package com.example.movieintroduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TokenWatcher
import android.widget.Toast
import com.example.movieintroduction.databinding.ActivityActionViewBinding

class ActionViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActionViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActionViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.Floating1.setOnClickListener{
            Toast.makeText(this,"플로팅",Toast.LENGTH_SHORT).show()
        }

        binding.horrible.setOnClickListener {
            Toast.makeText(this,"호러블",Toast.LENGTH_SHORT).show()
        }
    }
}