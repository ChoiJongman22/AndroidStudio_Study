package com.example.telephonebook

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentOne: Fragment() {

    interface OnDataPassListener{
        fun onDataPass(data:String?)
    }

    lateinit var dataPassListener: OnDataPassListener


    override fun onAttach(context: Context) {
        Log.d("Life-Cycle","F onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Life-Cycle","F onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_one,container,false)
        Log.d("Life-Cycle","F onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Life-Cycle","F onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Life-Cycle","F onActivityCreated")
        val data=arguments?.getString("hello")
        Log.d("data",data)
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("Life-Cycle","F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Life-Cycle","F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Life-Cycle","F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Life-Cycle","F onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Life-Cycle","F onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("Life-Cycle","F onDetach")
        super.onDetach()
    }
}