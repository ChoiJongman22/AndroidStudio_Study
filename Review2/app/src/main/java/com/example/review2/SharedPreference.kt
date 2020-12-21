package com.example.review2


import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        //SharedPreference에 저장하는 방법



        //MODE
        // - MODE_PRIVATE: 생성한 app에서만 사용가능 습관적으로 이거 사용
        // - MODE_WORLD_READABLE : 다른 app 사용가능 : 읽을 수만 있다.
        // - MODE_WORLD_WRITABLE : 다른 app 사용가능 : 기록도 가능
        // - MODE_MULTI_PROCESS: 이미 호출되어 사용중인지 체크
        // - MODE_APPEND: 기존 preference에 신규로 추가


        //데이터 베이스에 한번 저장하면 계속사용가능하다.

        //데이터를 삭제하는 방법
        //에뮬레이터- 가상기기의 settings - apps - 해당 프로젝트 이름 - storage - 삭제

        //저장하는 버튼

        button13.setOnClickListener {
            val sharedPreference= getSharedPreferences("sp1", MODE_PRIVATE)
            val editor:SharedPreferences.Editor=sharedPreference.edit()
            editor.putString("hello","안녕하세요")
            editor.putString("goodBye","안녕히계세요")
            editor.commit()
        }


        //불러오는 버튼
        button12.setOnClickListener {
            //sharedPreference에서 불러오는 방법
            val sharedPreference=getSharedPreferences("sp1", MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello","데이터 없음1")
            val value2 = sharedPreference.getString("goodBye","데이터 없음2")
            Log.d("key-value","Value:" + value1)
            Log.d("key-value","Value:" + value2)
        }


        //삭제하는 버튼
        button14.setOnClickListener {
            val sharedPreference=getSharedPreferences("sp1", MODE_PRIVATE)
            val editor=sharedPreference.edit()
            editor.remove("hello")
            editor.commit()

        }
        button15.setOnClickListener {
            val sharedPreference=getSharedPreferences("sp1", MODE_PRIVATE)
            val editor=sharedPreference.edit()
            editor.clear()
            editor.commit()
        }





    }


}