package com.jongman22.realtodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.jongman22.realtodolist.databinding.ActivityMainBinding
import com.jongman22.realtodolist.databinding.DialogFragmentBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var binding2:DialogFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding2= DialogFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)
        binding2.btnSample.setOnClickListener {
            DialogFrag().show(
                    supportFragmentManager,"Sample")
        }
        val dataset = (1..50).toList()
        binding.recyclerView.adapter=SampleAdapter(dataset)
    }
}