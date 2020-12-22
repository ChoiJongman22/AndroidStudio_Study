package com.example.viewbinding

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import com.example.viewbinding.databinding.ActivityAsyncBinding
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {
    var task:BackgroundAsyncTask?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAsyncBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.start.setOnClickListener {
            task = BackgroundAsyncTask(binding.progressbar,binding.ment)
            task?.execute()
        }

        binding.stop.setOnClickListener {
           //task?.cancel(true)
            startActivity(Intent(this,Intent2::class.java))
            //다음 인텐트로 가더라도 percent가 멈추지 않는다.
        }
    }

    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }
}

class BackgroundAsyncTask(
    val progressBar: ProgressBar,
    val progressText:TextView
):AsyncTask<Int,Int, Int>(){
    //<params, progress, result>순으로 override했을 때 담당구역
    //params -> doInBackground에서 사용할 type
    //progress -> onProgressUpdata에서 사용할 type
    //result -> onPostExcute에서 사용할 type


    var percent:Int =0

    override fun onPreExecute() {
        percent = 0
        progressBar.setProgress(percent)

    }

    override fun doInBackground(vararg params: Int?): Int {
        while(!isCancelled){
            percent++
            Log.d("async",""+percent)
            if(percent>100){
                break
            }
            else{
                publishProgress(percent)
            }
            try{
                Thread.sleep(100)
            }
            catch(e:Exception){
                e.printStackTrace()
            }
        }
        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressBar.progress = values[0]?:0
        progressText.text = "퍼센트: " + values[0]
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressText.text="작업이 완료되었습니다."
    }

    override fun onCancelled() {
        progressBar.progress = 0
        progressText.text = "작업이 취소 되었습니다."
    }
}