package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)

        binding.title.text="hello"
        binding.subtitle.text="goodbye"
        binding.button.setOnClickListener {
            Toast.makeText(this,"안녕하세요",Toast.LENGTH_SHORT).show()
        }
        setContentView(binding.root)
    }
}