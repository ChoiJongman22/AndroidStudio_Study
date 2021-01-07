package com.jongman22.todolistapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {
    @GET("json/students")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>
    @POST("json/students")
    fun createStudentEasy(
        @Body person:PersonFromServer
    ):Call<PersonFromServer>

    @POST("user/signup/")
    fun register(
        @Body register: Register
    ):Call<User>
}