package com.jongman22.realtodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.jongman22.realtodolist.databinding.ActivityInOutFreeBinding

class InOutFree : AppCompatActivity() {
    private lateinit var binding: ActivityInOutFreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInOutFreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val calendarFragment: FragmentInOut = FragmentInOut()

        binding.button.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager

            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,calendarFragment)
            fragmentTransaction.commit()
        }

        binding.button2.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.detach(calendarFragment)
            fragmentTransaction.commit()
        }
    }
}