package com.jongman22.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jongman22.todolistapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.mainEt.setText(App.prefs.myEditText)

        binding.mainBtn.setOnClickListener {
            App.prefs.myEditText=binding.mainEt.text.toString()
            val msg=App.prefs.myEditText
            if(msg==""){
                Toast.makeText(this,"텍스트 초기화",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"저장 : $msg",Toast.LENGTH_SHORT).show()
            }
        }


    }
}