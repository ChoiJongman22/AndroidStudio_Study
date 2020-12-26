package com.example.movieintroduction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock

class AppStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemClock.sleep(300)
        val intent = Intent(this,Avengers::class.java)
        startActivity(intent)
        finish()
    }
}