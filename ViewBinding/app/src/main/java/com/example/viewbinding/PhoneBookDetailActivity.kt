package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewbinding.databinding.ActivityPhoneBookDetailBinding

class PhoneBookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPhoneBookDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPersonInfoAndDraw()

        binding.back.setOnClickListener {
            onBackPressed()
        }


    }

    fun getPersonInfoAndDraw(){
        val binding = ActivityPhoneBookDetailBinding.inflate(layoutInflater)
        val name=intent.getStringExtra("name")
        val number=intent.getStringExtra("number")
        binding.personDetailName.text=name
        binding.personDetailNumber.text=number

    }
}