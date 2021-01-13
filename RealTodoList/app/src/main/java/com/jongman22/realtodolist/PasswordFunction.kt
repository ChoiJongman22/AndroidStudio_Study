package com.jongman22.realtodolist

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.jongman22.realtodolist.databinding.ActivityPasswordFunctionBinding

class PasswordFunction : AppCompatActivity() {
    private lateinit var binding: ActivityPasswordFunctionBinding
    private var oldPwd = ""
    private var changePwdUnlock = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordFunctionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val buttonArray = arrayListOf<Button>(
            binding.btn0,
            binding.btn1,
            binding.btn2,
            binding.btn3,
            binding.btn4,
            binding.btn5,
            binding.btn6,
            binding.btn7,
            binding.btn8,
            binding.btn9,
            binding.btnclear,
            binding.btnErase
        )
        for (button in buttonArray) {
            button.setOnClickListener(btnListener)
        }
    }

    private val btnListener = View.OnClickListener { view ->
        var currentValue = -1
        when (view.id) {
            R.id.btn0 -> currentValue = 0
            R.id.btn1 -> currentValue = 1
            R.id.btn2 -> currentValue = 2
            R.id.btn3 -> currentValue = 3
            R.id.btn4 -> currentValue = 4
            R.id.btn5 -> currentValue = 5
            R.id.btn6 -> currentValue = 6
            R.id.btn7 -> currentValue = 7
            R.id.btn8 -> currentValue = 8
            R.id.btn9 -> currentValue = 9
            R.id.btnclear -> onClear()
            R.id.btnErase -> onDeleteKey()
        }

        val strCurrentValue = currentValue.toString()
        if (currentValue != -1) {
            when {
                binding.passcode1.isFocused -> {
                    setEditText(binding.passcode1, binding.passcode2, strCurrentValue)
                }
                binding.passcode2.isFocused -> {
                    setEditText(binding.passcode2, binding.passcode3, strCurrentValue)
                }
                binding.passcode3.isFocused -> {
                    setEditText(binding.passcode3, binding.passcode4, strCurrentValue)
                }
                binding.passcode4.isFocused -> {
                    binding.passcode4.setText(strCurrentValue)
                }
            }
        }
        if (binding.passcode4.text.isNotEmpty() && binding.passcode3.text.isNotEmpty() && binding.passcode2.text.isNotEmpty() && binding.passcode1.text.isNotEmpty()) {
            inputType(intent.getIntExtra("type", 0))
        }
    }

    private fun onDeleteKey() {
        when {
            binding.passcode1.isFocused -> {
                binding.passcode1.setText("")
            }
            binding.passcode2.isFocused -> {
                binding.passcode1.setText("")
                binding.passcode1.requestFocus()
            }
            binding.passcode3.isFocused -> {
                binding.passcode2.setText("")
                binding.passcode2.requestFocus()
            }
            binding.passcode4.isFocused -> {
                binding.passcode3.setText("")
                binding.passcode3.requestFocus()
            }
        }
    }

    private fun onClear() {
        binding.passcode1.setText("")
        binding.passcode2.setText("")
        binding.passcode3.setText("")
        binding.passcode4.setText("")
        binding.passcode1.requestFocus()
    }

    private fun inputedPassword(): String {
        return "${binding.passcode1.text}${binding.passcode2.text}${binding.passcode3.text}${binding.passcode4.text}"
    }

    private fun setEditText(
        currentEditText: EditText,
        nextEditText: EditText,
        strCurrentValue: String
    ) {
        currentEditText.setText(strCurrentValue)
        nextEditText.requestFocus()
        nextEditText.setText("")
    }

    private fun inputType(type: Int) {
        when (type) {
            AppLockConst.ENABLE_PASSLOCK -> {
                if (oldPwd.isEmpty()) {
                    oldPwd = inputedPassword()
                    onClear()
                    binding.inputinfo.text = "다시 입력하세요."
                } else {
                    if (oldPwd == inputedPassword()) {
                        AppLock(this).setPassLock(inputedPassword())
                        setResult(Activity.RESULT_OK)
                        finish()
                    } else {
                        onClear()
                        oldPwd = ""
                        binding.inputinfo.text = "비밀번호 입력"
                    }
                }
            }
            AppLockConst.DISABLE_PASSLOCK -> {
                if (AppLock(this).isPassLockSet()) {
                    if (AppLock(this).checkPassLock(inputedPassword())) {
                        AppLock(this).removePassLock()
                        setResult(Activity.RESULT_OK)
                        finish()
                    } else {
                        binding.inputinfo.text = "비밀번호가 틀립니다."
                        onClear()
                    }
                } else {
                    setResult(Activity.RESULT_CANCELED)
                    finish()
                }
            }
            AppLockConst.UNLOCK_PASSWORD -> {
                if (AppLock(this).checkPassLock(inputedPassword())) {
                    setResult(Activity.RESULT_OK)
                    finish()
                } else {
                    binding.inputinfo.text = "비밀번호가 틀립니다."
                    onClear()
                }
            }
            AppLockConst.CHANGE_PASSWORD -> {
                if (AppLock(this).checkPassLock(inputedPassword())&&!changePwdUnlock) {
                    onClear()
                    changePwdUnlock=true
                    binding.inputinfo.text="새로운 비밀번호 입력"
                } else if (changePwdUnlock){
                   if(oldPwd.isEmpty()){
                       oldPwd=inputedPassword()
                       onClear()
                       binding.inputinfo.text="새로운 비밀번호 다시 입력"
                   }else{
                       if(oldPwd==inputedPassword()){
                           AppLock(this).setPassLock(inputedPassword())
                           setResult(Activity.RESULT_OK)
                           finish()
                       }else{
                           onClear()
                           oldPwd=""
                           binding.inputinfo.text="현재비밀번호 다시 입력"
                           changePwdUnlock=false
                       }

                   }
                }else{
                    binding.inputinfo.text="비밀번호가 틀립니다."
                    changePwdUnlock=false
                    onClear()
                }
            }

        }


    }
}


