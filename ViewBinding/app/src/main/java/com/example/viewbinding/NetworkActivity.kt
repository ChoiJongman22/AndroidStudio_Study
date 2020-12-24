package com.example.viewbinding

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding.databinding.ActivityNetworkBinding
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNetworkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NetworkTask(
            binding.recyclerPerson,
            LayoutInflater.from(this@NetworkActivity),
            this@NetworkActivity
        ).execute()

    }
}

class NetworkTask(
    val recyclerView:RecyclerView,
    val inflater: LayoutInflater,
    val context: Context//layoutmanager를 위해서
):AsyncTask<Any?,Any?,Array<PersonFromServer>>(){

    //onPostExecute는 MainThread에서 실행이 가능하다.
    //그래서 UI에 접근이 가능하다.
    override fun onPostExecute(result: Array<PersonFromServer>?) {
        val adapter=PersonAdapter(result!!,inflater)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(context)
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: Any?): Array<PersonFromServer> {
        val urlString: String = "http://mellowcode.org/json/students/"
        val url: URL = URL(urlString)
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type", "application/json")
        var buffer = ""
        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            Log.d("connn", "inputstream: " + connection.inputStream)
            val reader = BufferedReader(
                    InputStreamReader(
                            connection.inputStream,
                            "UTF-8"
                    )
            )
            buffer = reader.readLine() //얘가 우리가 읽을 수 있게 줄을 읽어준다는 것.


        }
        val data = Gson().fromJson(buffer,Array<PersonFromServer>::class.java)
        return data
    }
}

class PersonAdapter(
        val personList:Array<PersonFromServer>,
        val inflater:LayoutInflater
):RecyclerView.Adapter<PersonAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name: TextView
        val age: TextView
        val intro: TextView
        init{
            name=itemView.findViewById(R.id.name)
            age=itemView.findViewById(R.id.age)
            intro=itemView.findViewById(R.id.ment)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=inflater.inflate(R.layout.person_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text=personList[position].name?:"" //null타입일 수도 있으니까.
        holder.age.text=personList[position].age.toString()
        holder.intro.text= personList[position].intro?:""

    }
}
