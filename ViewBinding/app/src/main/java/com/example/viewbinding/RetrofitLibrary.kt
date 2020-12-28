package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.viewbinding.databinding.ActivityRetrofitLibraryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitLibrary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRetrofitLibraryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            //데이터를 받아서 gson이라는 것으로 바꾸는 과정을 직접했었는데 addconverterFactory를 사용하면 안그래도 된다.
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            //retrofit은 baseurl뒤에 붙는 부분을 쉽게 관리할 수 있도록 해준다. 그래서 그 interface를 만들자
                
        val service = retrofit.create(RetrofitService::class.java)

        //get요청
        service.getStudentsList().enqueue(object: Callback<ArrayList<PersonFromServer>>{
        //enqueue는 대기줄에 올려놓는다는 의미.
            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
            //isSuccessful은 200~299번까지의 statuscode
                if(response.isSuccessful){
                    val PersonList = response.body()
                    Log.d("retrofitt","res : "+PersonList?.get(0)?.age)

                    val code = response.code()
                    Log.d("retrofitt","code : "+code)

                    val error = response.errorBody()
                    //
                    val header = response.headers()
                    Log.d("retrofitt","code : "+header)

                    //header는 인증정보, 데이터의 요약본을 얘기함.

                }


            }
            //호출 성공했을 때 위의 것
            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt","ERROR")
                //call.isCanceled //취소되었는지
                //call.isExecuted //실행되었는지
                //call.cancel()
            }
            //호출 실패했을 때 위의 것
        })

        //post요청
       /* val params = HashMap<String,Any>()
        params.put("name","와우우")
        params.put("age","40")
        params.put("intro","안녕하세요")

        service.createStudent(params).enqueue(object:Callback<PersonFromServer>{
            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if(response.isSuccessful){
                    val person = response.body()
                    Log.d("retrofitt","name: "+person?.name)
                }

            }

            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {

            }
        })*/

        //POST요청2
        val person = PersonFromServer(name= "와우우우",age = 14, intro = "안녕하세유")
        service.createStudentEasy(person).enqueue(object : Callback<PersonFromServer>{
            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if(response.isSuccessful){
                    val person = response.body()
                    Log.d("retrofitt","name: "+person?.name)
                }

            }

            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {

            }
        })

    }
}