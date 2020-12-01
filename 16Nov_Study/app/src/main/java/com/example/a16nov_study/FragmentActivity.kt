package com.example.a16nov_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*


class FragmentActivity : AppCompatActivity(),FragmentOne.OnDataPassListener {
    override fun onDataPass(data: String?) {
        Log.d("pass",""+data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("Life-Cycle","onCreate")
        val fragmentOne:FragmentOne=FragmentOne()
        val bundle:Bundle=Bundle()
        bundle.putString("hello","hello")
        fragmentOne.arguments=bundle
        button.setOnClickListener {

            val fragmentManager:FragmentManager = supportFragmentManager

            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentOne)
            fragmentTransaction.commit()
        }

        button2.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            //fragmentTransaction.detach(fragmentOne)
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()

        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("Life-Cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life-Cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life-Cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Life-Cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life-Cycle","onDestroy")
    }

}