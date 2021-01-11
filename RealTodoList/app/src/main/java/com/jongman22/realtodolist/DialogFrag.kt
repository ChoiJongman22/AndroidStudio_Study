package com.jongman22.realtodolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.jongman22.realtodolist.databinding.DialogFragmentBinding

class DialogFrag:DialogFragment() {

    private lateinit var binding:DialogFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable=true
        //false로 설정해주면 화면밖 혹은 뒤로가기 버튼시 다이얼로그라 dismiss되지 않는다.
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DialogFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val text="Hello, Welcom"
        binding.tvSample.text=text
        binding.btnSample.setOnClickListener {
            Toast.makeText(requireContext(),text,Toast.LENGTH_SHORT).show()
        }
    }
}