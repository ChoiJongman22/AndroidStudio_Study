package com.example.newproject_and_delete

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent1.*


class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)

        val intent=Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==200){
            Log.d("number",""+requestCode)
            Log.d("number",""+resultCode)
            val result=data?.getIntExtra("result",0) //null type 때문에 ? 사용
            Log.d("number",""+result)
        }
    }
}