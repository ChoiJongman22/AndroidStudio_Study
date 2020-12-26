package com.example.movieintroduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movieintroduction.databinding.ActivityCaptainAmericaBinding


class CaptainAmerica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCaptainAmericaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this@CaptainAmerica)
            .load("data:image/jpeg;base64,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")

            .into(binding.captain)

        Glide.with(this@CaptainAmerica)
            .load("data:image/jpeg;base64,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")
            .into(binding.Rogers)

        Glide.with(this@CaptainAmerica)
            .asGif()
            .load("https://giffiles.alphacoders.com/691/6911.gif")
            .into(binding.suitup)
    }
}