package com.jongman22.instagram

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//activity보다 상위에 있는 MasterApplication
class MasterApplication : Application() {

    lateinit var service: RetrofitService

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)//Stetho작동하기 위한.
        createRetrofit()
    }

    fun createRetrofit() {
        //통신을 가로챈다.
        val head = Interceptor {
            val original = it.request()
            if (checkIsLogin()) {
                getUserToken()?.let { token ->
                    val request = original.newBuilder() //가로챈 오리지날을 개조한다.
                        .header("Authorization", "token " + token)//헤더를 달아준다.
                        .build()
                    it.proceed(request)
                }

            } else {
                it.proceed(original)
            }

        }

        val client = OkHttpClient.Builder()
            .addInterceptor(head) //위에서 만든 head를 넣어준다.
            .addNetworkInterceptor(StethoInterceptor()) //stetho로 낚아채서 보여준다.
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        service = retrofit.create(RetrofitService::class.java)
    }

    //로그인을 했는지 안했는지 확인
    fun checkIsLogin(): Boolean {
        //인증정보를 token으로 sharedpreference에 저장
        val sp = getSharedPreferences("login-sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        if (token != "null") return true
        else return false
    }

    fun getUserToken(): String? {
        val sp = getSharedPreferences("login-sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        if (token == "null") return null
        else return token
    }

}