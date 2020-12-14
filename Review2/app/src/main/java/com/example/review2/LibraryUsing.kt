package com.example.review2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_library_using.*

class LibraryUsing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library_using)

        Glide.with(this@LibraryUsing)
            .load("https://cafeptthumb-phinf.pstatic.net/20131231_186/treeholder_1388480033486T296Q_PNG/1795705547.png?type=w740")
            .override(1000,1000)
            .into(glide)

    }
}