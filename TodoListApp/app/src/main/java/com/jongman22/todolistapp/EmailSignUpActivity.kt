package com.jongman22.todolistapp

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.jongman22.todolistapp.databinding.ActivityEmailSignUpBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class EmailSignUpActivity : AppCompatActivity() {
    lateinit var userNameView: EditText
    lateinit var password1View: EditText
    lateinit var password2View: EditText
    lateinit var registerBtn: TextView
    private lateinit var binding: ActivityEmailSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailSignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initView(this@EmailSignUpActivity)
        setUpListener()

    }

    fun setUpListener() {
        registerBtn.setOnClickListener{
            register(this@EmailSignUpActivity)
        }
    }
    fun register(activity: Activity){
        val username = getUserName()
        val password1=getUserPassword1()
        val password2=getUserPassword2()
        val register=Register(username,password1,password2)

        (application as MasterApplication).service.register(register).enqueue(object :
            retrofit2.Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    Toast.makeText(activity,"가입에 성공했습니다.",Toast.LENGTH_SHORT).show()
                    val user = response.body()
                    val token =user!!.token!!
                    saveUserToken(token,activity)

                }

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(activity,"가입에 실패했습니다.",Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun saveUserToken(token:String,activity: Activity){
        val sp=activity.getSharedPreferences("login-sp", Context.MODE_PRIVATE)
        val editor =sp.edit()
        editor.putString("login-sp",token)
        editor.commit()
    }


    fun initView(activity: Activity) {
        userNameView = activity.findViewById(R.id.username_inputbox)
        password1View = activity.findViewById(R.id.username_password1)
        password2View = activity.findViewById(R.id.username_password2)
        registerBtn=activity.findViewById(R.id.signup)
    }

    fun getUserName(): String {
        return userNameView.text.toString()
    }

    fun getUserPassword1(): String {
        return password1View.text.toString()
    }

    fun getUserPassword2(): String {
        return password2View.text.toString()
    }

}