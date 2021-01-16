package com.jongman22.instagram

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.jongman22.instagram.databinding.ActivityEmailSignUpBinding
import retrofit2.Call
import retrofit2.Response


class EmailSignUpActivity : AppCompatActivity() {
    lateinit var usernameView: EditText
    lateinit var Password1: EditText
    lateinit var Password2: EditText
    lateinit var registerBtn: TextView
    private lateinit var binding: ActivityEmailSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView(this@EmailSignUpActivity)
        setUpListener()//initView로 먼저하고


    }

    fun initView(activity: Activity) {
        usernameView = activity.findViewById(R.id.name)
        Password1 = activity.findViewById(R.id.password)
        Password2 = activity.findViewById(R.id.password2)
        registerBtn = activity.findViewById(R.id.register)
    }

    fun setUpListener() {
        registerBtn.setOnClickListener {
            registerMember(this@EmailSignUpActivity)
        }
    }

    fun registerMember(activity: Activity) {
        val username = usernameView.text.toString()
        val password1 = Password1.text.toString()
        val password2 = Password2.text.toString()

        (application as MasterApplication).service.registerUser(username, password1, password2)
            .enqueue(object :
                retrofit2.Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        Toast.makeText(activity, "가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
                        val user = response.body()
                        val token = user!!.token!!
                        saveUserToken(token, activity)
                    }


                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(activity, "가입에 실패 했습니다.", Toast.LENGTH_SHORT).show()

                }
            })
    }

    fun saveUserToken(token: String, activity: Activity) {
        val sp = activity.getSharedPreferences("login-sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login-sp", token)
        editor.commit()

    }

    fun getUserName(): String {
        return usernameView.text.toString()
    }

    fun getPassword(): String {
        return Password1.text.toString()
    }

    fun getPassword2(): String {
        return Password2.text.toString()
    }
}