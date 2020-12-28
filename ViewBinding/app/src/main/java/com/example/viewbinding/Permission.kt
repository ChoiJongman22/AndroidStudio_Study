package com.example.viewbinding

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.viewbinding.databinding.ActivityPermissionBinding

class Permission : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val cameraPermissionCheck :Int = ContextCompat.checkSelfPermission(
                    this@Permission,
                    android.Manifest.permission.CAMERA
            )
            if(cameraPermissionCheck != PackageManager.PERMISSION_GRANTED){
                //권한이 없는 경우
                ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.CAMERA),
                        1000
                )

            }else{
                //권한이 있는 경우
                Log.d("permissionss","권한이 이미 있음")
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == 1000){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //승낙
                Log.d("permissionss","승낙")
            }
            else{
                //거부
                Log.d("permissionss","거부")

            }
        }
    }
}