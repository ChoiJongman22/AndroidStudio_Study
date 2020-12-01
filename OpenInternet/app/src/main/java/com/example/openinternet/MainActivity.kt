package com.example.openinternet

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        open.setOnClickListener {
            val address = address_edit_test.text.toString()
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse(address))
            startActivity(intent)
        }

        address_edit_test.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("edit", "beforeTextChanged: $s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("edit", "OnTextChanged: $s")
            }


            override fun afterTextChanged(s: Editable?) {
                if(s.toString()=="abc"){
                    Log.d("edit", "Text is abc")
                }
                Log.d("edit", "afterTextChanged: $s")
            }
        })


    }
}