package com.jongman22.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jongman22.todolistapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val BASE_URL_NAVER_API = "https://openapi.naver.com/"
        val CLIENT_ID = "네이버_개발자센터_아이디"
        val CLIENT_SECRET = "네이버_개발자센터_비밀번호"

        val retrofit =Retrofit.Builder()
            .baseUrl(BASE_URL_NAVER_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api =retrofit.create(NaverAPI::class.java)
        val callGetSearchNews =api.getSearchNews(CLIENT_ID,CLIENT_SECRET,"테스트")

        callGetSearchNews.enqueue(object:Callback<ResultGetSearchNews>{
            override fun onResponse(
                call: Call<ResultGetSearchNews>,
                response: Response<ResultGetSearchNews>
            ) {
               Log.d("NAVERRR","성공 : ${response.raw()}")
            }
            override fun onFailure(call: Call<ResultGetSearchNews>, t: Throwable) {
                Log.d("NAVERRR","실패 : $t")
            }


        })
    }
}

