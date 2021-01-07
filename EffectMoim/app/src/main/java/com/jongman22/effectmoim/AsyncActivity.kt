package com.jongman22.effectmoim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import com.jongman22.effectmoim.databinding.ActivityAsyncBinding

class AsyncActivity : AppCompatActivity() {
    private lateinit var binding :ActivityAsyncBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityAsyncBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}

class BackgroundAsyncTask(
    val progressBar: ProgressBar,
    val progressText:TextView

)



//비동기 -> Async
//동기 -> Sync


//동기 방식: 작업을 순서대로 진행한다.

//비동기방식: Thread를 만들어서 작업을 따로 처리한다.

//안드로이드에서 Async다루는 방법
// - AsyncTask 상속받기
//장점: Main Thread를 기다리게 할 필요가 없다. & 네트워크에서 응답시간에 다른 걸 할 수 있게 한다.

