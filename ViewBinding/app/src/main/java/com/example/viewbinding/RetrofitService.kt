package com.example.viewbinding

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService{
    @GET("json/students/")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>//Call import Retrofit2
    @POST("json/students/")
    fun createStudent(
        @Body params:HashMap<String, Any>
    ):Call<PersonFromServer>//return type 정보에 맞게
    @POST("json/students/")
    fun createStudentEasy(
        @Body person: PersonFromServer
    ):Call<PersonFromServer>

}