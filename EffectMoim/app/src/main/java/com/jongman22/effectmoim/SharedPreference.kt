package com.jongman22.effectmoim

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jongman22.effectmoim.databinding.ActivitySharedPreferenceBinding

class SharedPreference : AppCompatActivity() {
    private lateinit var binding : ActivitySharedPreferenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySharedPreferenceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //1번
        //저장하는 방법

        //2번

        binding.save.setOnClickListener {
            //editor를 사용해서 데이터를 넣어야 한다.
            val sharedPreference=getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor:SharedPreferences.Editor=sharedPreference.edit()
            editor.putString("hello","안녕하세요")
            editor.putString("goodbye","안녕히가세요")
            editor.commit()
        }


        binding.load.setOnClickListener {
            //값을 불러오는 방법
            val sharedPreference=getSharedPreferences("sp1", Context.MODE_PRIVATE)
            //editor를 사용해서 데이터를 넣어야 한다.
            val value=sharedPreference.getString("hello","데이터없음1")
            val value2=sharedPreference.getString("goodbye","데이터없음2")
            Log.d("key-value","Value : "+value)
            Log.d("key-value","Value2 : "+value2)

        }

        binding.delete.setOnClickListener {
            val sharedPreference=getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor:SharedPreferences.Editor=sharedPreference.edit()
            editor.remove("hello")
            editor.commit()
        }

        binding.deleteall.setOnClickListener {
            val sharedPreference=getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor:SharedPreferences.Editor=sharedPreference.edit()
            editor.clear()
            editor.commit()
        }



    }
}

//데이터 베이스
//- 데이터를 저장하기 위함

//데이더 저장 방식
//- RDB(Relational Database)
//  - 관계형 데이터 베이스
//  - 엑셀처럼 생겼다.
// 이름 학번 학교 성별
//  종만 15  숭실 남자

//- Key-Value
//  - 쌍으로 저장하는 방식

//RDBMS
// - Relational Database Management System
// - RDB를 관리하기 위한 툴
// - MySQL
// - Oracle
// - PostgreSQL

//SQL
// - RDBMS를 위한 언어

//NoSQL
// - SQL말고 다르게 해보자!
// - key-value방식


//안드로이드 DB
//- SQLiteDatabase
//- SharedPreference
// - key/Value 방식
// - 목적: 공유된 사용자의 기호
// - 하드하게 DB를 구축할 수 없다. 그냥 간단하게 사용하기 위함.


