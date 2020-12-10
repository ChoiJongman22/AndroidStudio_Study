package com.example.telephonebook

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent1.*

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)

        change_activity.setOnClickListener {
            val intent= Intent(this@Intent1,Intent2::class.java)
            intent.apply{
                this.putExtra("number1",1)
                this.putExtra("number2",2)
            }

            startActivityForResult(intent,200)
        }

        open.setOnClickListener {
            val address=address_edit.text.toString()
            val intent2=Intent(Intent.ACTION_VIEW,Uri.parse(address))
            startActivity(intent2)
        }
        address_edit.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("edit","beforeTextChanged: $s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("edit","OnTextChanged: $s")
            }

            override fun afterTextChanged(s: Editable?) {
                if(s.toString()=="abc"){
                    Log.d("edit","Text is abc")
                }
                Log.d("edit","afterTextChanged: $s")
            }
        })
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==200){
            Log.d("number","111")
            Log.d("number",""+resultCode)
            Log.d("number",""+requestCode)
            val result=data?.getIntExtra("result",0)

        }


    }
}