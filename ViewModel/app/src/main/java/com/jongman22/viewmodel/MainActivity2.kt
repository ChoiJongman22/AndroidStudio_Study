package com.jongman22.viewmodel

import android.app.ActivityOptions
import android.content.Intent
import android.content.IntentFilter.create
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import com.jongman22.viewmodel.databinding.ActivityMain2Binding
import java.net.URI.create

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.mainCard.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            var options : ActivityOptions=ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair.create(binding.nameTxt,"nameTransition"),
                Pair.create(binding.contentTxt,"contentTransition"),
                Pair.create(binding.profileImg,"imageTransition")
            )
            startActivity(intent, options.toBundle())
        }
    }
}