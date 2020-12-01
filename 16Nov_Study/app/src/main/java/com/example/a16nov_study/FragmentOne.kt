package com.example.a16nov_study

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne:Fragment(){

    interface OnDataPassListener{
        fun onDataPass(data: String?)
    }
    lateinit var dataPassListener: OnDataPassListener

    override fun onAttach(context: Context) {
        Log.d("Life-Cycle","F onAttach")
        super.onAttach(context)
        dataPassListener=context as OnDataPassListener
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
        Log.d("Life-Cycle","F onCreateView")

        return inflater.inflate(R.layout.fragment_one,container,false)


    }


    //Activity의 Oncreate에서 했던 작업을 여기에서 한다.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Life-Cycle","F onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        pass.setOnClickListener {
            dataPassListener.onDataPass("Good Bye")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Life-Cycle","F onActivityCreated")

        val data = arguments?.getString("hello")
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