package com.jongman22.realtodolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide.init
import com.jongman22.realtodolist.databinding.ActivityAppLockBinding

class app_lock : AppCompatActivity() {
    private lateinit var binding: ActivityAppLockBinding
    var lock = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppLockBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        init()

        binding.btnSetLock.setOnClickListener {
            val intent = Intent(this, PasswordFunction::class.java).apply {
                putExtra(AppLockConst.type, AppLockConst.ENABLE_PASSLOCK)
            }
            startActivityForResult(intent, AppLockConst.ENABLE_PASSLOCK)
        }
        binding.btnSetDelLock.setOnClickListener {
            val intent = Intent(this, PasswordFunction::class.java).apply {
                putExtra(AppLockConst.type, AppLockConst.DISABLE_PASSLOCK)
            }
            startActivityForResult(intent, AppLockConst.DISABLE_PASSLOCK)
        }
        binding.btnChangePwd.setOnClickListener {
            val intent = Intent(this, PasswordFunction::class.java).apply {
                putExtra(AppLockConst.type, AppLockConst.CHANGE_PASSWORD)
            }
            startActivityForResult(intent, AppLockConst.CHANGE_PASSWORD)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            AppLockConst.ENABLE_PASSLOCK ->
                if (requestCode == Activity.RESULT_OK) {
                    Toast.makeText(this, "암호설정", Toast.LENGTH_SHORT).show()
                    init()
                    lock = false
                }
            AppLockConst.DISABLE_PASSLOCK ->
                if (requestCode == Activity.RESULT_OK) {
                    Toast.makeText(this, "암호삭제", Toast.LENGTH_SHORT).show()
                    init()
                }
            AppLockConst.CHANGE_PASSWORD ->
                if (requestCode == Activity.RESULT_OK) {
                    Toast.makeText(this, "암호변경", Toast.LENGTH_SHORT).show()

                    lock = false
                }
            AppLockConst.UNLOCK_PASSWORD ->
                if (requestCode == Activity.RESULT_OK) {
                    Toast.makeText(this, "잠금해제", Toast.LENGTH_SHORT).show()

                    lock = false
                }
        }

    }

    override fun onStart() {
        super.onStart()
        if (lock && AppLock(this).isPassLockSet()) {
            val intent = Intent(this, PasswordFunction::class.java).apply {
                putExtra(AppLockConst.type, AppLockConst.UNLOCK_PASSWORD)
            }
            startActivityForResult(intent, AppLockConst.UNLOCK_PASSWORD)
        }
    }

    override fun onPause() {
        super.onPause()
        if (AppLock(this).isPassLockSet()) {
            lock = true
        }
    }

    private fun init() {
        if (AppLock(this).isPassLockSet()) {
            binding.btnSetLock.isEnabled = false
            binding.btnSetDelLock.isEnabled = true
            binding.btnChangePwd.isEnabled = true
            lock = true
        }
        else{
            binding.btnSetLock.isEnabled = true
            binding.btnSetDelLock.isEnabled = false
            binding.btnChangePwd.isEnabled = false
            lock=false
        }
    }
}