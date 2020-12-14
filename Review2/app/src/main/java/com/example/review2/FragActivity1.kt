package com.example.review2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_frag1.*

class FragActivity1 : AppCompatActivity(),Frag1.OnDataPassListener {

    override fun onDataPass(data: String?) {
        Log.d("pass",""+data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag1)
        val fragmentOne:Frag1=Frag1()
        val bundle: Bundle=Bundle()
        bundle.putString("hello","hello")
        fragmentOne.arguments=bundle
        btn1.setOnClickListener {
            val fragmentManager:FragmentManager=supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentOne)
            fragmentTransaction.commit()
        }
        btn2.setOnClickListener {
            val fragmentManager:FragmentManager=supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()
        }
    }
}