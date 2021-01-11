package com.jongman22.realtodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jongman22.realtodolist.databinding.ActivityMain2Binding
import com.jongman22.realtodolist.databinding.DialogFragmentBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding1:ActivityMain2Binding
    private lateinit var binding2:DialogFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1= ActivityMain2Binding.inflate(layoutInflater)
        binding2= DialogFragmentBinding.inflate(layoutInflater)
        val view = binding1.root
        setContentView(view)

        binding1.btnSample.setOnClickListener {
            DialogFrag().show(
                supportFragmentManager,"Sample")
        }
    }
}