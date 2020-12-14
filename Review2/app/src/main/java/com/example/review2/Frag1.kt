package com.example.review2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_frag1.*
import kotlinx.android.synthetic.main.fragment_one.*

class Frag1: Fragment() {

    interface OnDataPassListener{
        fun onDataPass(data:String?)
    }

    lateinit var datapassListener:OnDataPassListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        datapassListener=context as OnDataPassListener

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pass.setOnClickListener {
            datapassListener.onDataPass("GoodBye")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        val data = arguments?.getString("hello")
        Log.d("data",data)
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDetach() {
        super.onDetach()
    }

}