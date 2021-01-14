package com.jongman22.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(): ViewModel() {
    //LiveData : 값이 변경되는 경우 MutableLiveData로 선언한다.

    var count = MutableLiveData<Int>()

    init{
        count.value=0
    }

    fun increase(){
        count.value=count.value?.plus(1)
    }
    fun decrease(){
        count.value=count.value?.minus(1)
    }
}