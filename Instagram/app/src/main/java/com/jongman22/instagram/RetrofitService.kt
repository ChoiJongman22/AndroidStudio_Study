package com.jongman22.instagram


import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @GET("json/students/")
    fun getStudentList(): Call<ArrayList<PersonFromServer>>

    @POST("json/students/")
    fun createStudent(
        @Body params: HashMap<String, Any>
    ): Call<PersonFromServer>

    @POST("json/students/")
    fun createStudentEasy(
        @Body person: PersonFromServer
    ): Call<PersonFromServer>

    @POST("user/signup/")
    @FormUrlEncoded
    //Field를 통째로 보내줄때 위 아래걸로 추가해주세요!
    fun registerUser(
        @Field("username") username: String,
        @Field("password1") password1: String,
        @Field("password2") password2: String
    ): Call<User>
}