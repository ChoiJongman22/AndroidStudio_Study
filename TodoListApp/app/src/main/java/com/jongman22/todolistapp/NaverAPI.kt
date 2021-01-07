package com.jongman22.todolistapp

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverAPI {
    @GET("v1/search/news.json")
    fun getSearchNews(
        @Header("X-Naver-Client-Id")clientId:String,
        @Header("X-Naver-Client-Secret") clientSecret: String,

        //Query는 질의라는 뜻
        @Query("query") query: String,
        @Query("display") display: Int? = null,
        @Query("start") start: Int? = null
    ): retrofit2.Call<ResultGetSearchNews>
}

