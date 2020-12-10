package com.example.telephonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("Life-Cycle","onCreate")
        val fragmentOne:FragmentOne= FragmentOne()
        val bundle:Bundle=Bundle()
        bundle.putString("hello","hello")
        fragmentOne.arguments=bundle
        btn1.setOnClickListener {

            val fragmentManager:FragmentManager=supportFragmentManager

            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentOne)
            fragmentTransaction.commit()
        }

        btn2.setOnClickListener {

            val fragmentManager: FragmentManager=supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentOne)
            fragmentTransaction.commit()
        }
    }
}