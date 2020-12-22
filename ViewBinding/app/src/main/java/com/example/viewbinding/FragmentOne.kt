package com.example.viewbinding

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewbinding.databinding.FragmentOneBinding

class FragmentOne:Fragment() {




    interface OnDataPassListener{
        fun onDataPass(data:String?)
    }
    lateinit var dataPasser:OnDataPassListener


    override fun onAttach(context: Context) {
        Log.d("Life-cycle","onAttach")
        super.onAttach(context)
        dataPasser = context as OnDataPassListener

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Life-cycle","onCreate")
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one,container,false)
        //프라그먼트가 인터페이스를 처음으로 그릴 때 호출한다.
        //inflater는 뷰를 그려주는 역할
        //container는 부모뷰입니다.
        Log.d("Life-cycle","onCreateView")
    }

    //Activity의 onCreate에서 했던 작업을 여기에서 한다.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Life-cycle","onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentOneBinding.inflate(layoutInflater)
        binding.pass.setOnClickListener {
            dataPasser.onDataPass("good-Bye")
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Life-cycle","onActivityCreated")
        val data = arguments?.getString("hello")
        Log.d("dataa",data)
        super.onActivityCreated(savedInstanceState)
    }
    override fun onStart() {
        Log.d("Life-cycle","onStart")
        super.onStart()
    }
    override fun onResume() {
        Log.d("Life-cycle","onResume")
        super.onResume()
    }
    override fun onPause() {
        Log.d("Life-cycle","onPause")
        super.onPause()
    }
    override fun onStop() {
        Log.d("Life-cycle", "onStop")
        super.onStop()
    }
    override fun onDestroyView() {
        Log.d("Life-cycle","onDestroyView")
        super.onDestroyView()
    }
    override fun onDetach() {
        Log.d("Life-cycle","onDetach")
        super.onDetach()

    }
}