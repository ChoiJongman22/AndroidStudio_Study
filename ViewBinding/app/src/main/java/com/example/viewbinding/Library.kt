package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.viewbinding.databinding.ActivityLibraryBinding

class Library : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLibraryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this@Library)
            .asGif()//gif이미지 로딩
            .load("https://cafeptthumb-phinf.pstatic.net/20131231_186/treeholder_1388480033486T296Q_PNG/1795705547.png?type=w740")
            .thumbnail(0.1f)//원본이미지를 썸네일로 보여줌. 0.1f로 지정하면 실제 이미지 크기중에서 10%만 먼저 가져옴
            .centerCrop()
            .placeholder(R.drawable.startuf) //로딩하는 동안 보여주는 이미지
            .error(R.drawable.startuf) //에러시 대체 이미지

            .into(binding.glide)

    }
}