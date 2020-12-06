package com.example.a16nov_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        val runnable:Runnable= object:Runnable{
            override fun run() {
                Log.d("thread-1", "Thread is made")
            }
        }
        val thread: Thread =Thread(runnable)

        btn11.setOnClickListener {
            thread.start()
        }

        Thread(object: Runnable{
            override fun run(){
                Log.d("thread-1", "Thread2 is made")
//람다 사용x
            }
        }).start()

        Thread(Runnable {
            Thread.sleep(2000)
            Log.d("thread-1", "Thread3 is made")
            runOnUiThread {
                btn11.setBackgroundColor(getColor(R.color.text_view))
            }
//람다 사용
        }).start()
    }

}