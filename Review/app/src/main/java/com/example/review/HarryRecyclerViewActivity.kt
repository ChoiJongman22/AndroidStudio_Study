package com.example.review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_harry_potter_char.*
import kotlinx.android.synthetic.main.activity_harry_recycler_view.*
import java.nio.file.Files.size

class HarryRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harry_recycler_view)
        val charList=ArrayList<CharList>()
        charList.add(CharList("Harry Potter","영화의 주인공, 볼드모트 생존자"))
        charList.add(CharList("Ronald","영화의 조연, 해리의 조력자"))
        charList.add(CharList("Hermionne","영화의 조연, 똑똑하고 예쁨"))
        charList.add(CharList("Draco","영화의 조연, Shut Up, MalFoy"))
        val adapter=RecyclerViewAdapter(charList, LayoutInflater.from(this@HarryRecyclerViewActivity))
        recyclerview.adapter=adapter
        recyclerview.layoutManager= LinearLayoutManager(this@HarryRecyclerViewActivity)
    }
}



class RecyclerViewAdapter(
        val itemList:ArrayList<CharList>,
        val inflater:LayoutInflater
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val charName: TextView
        val charDetail:TextView
        init{
            charName=itemView.findViewById(R.id.char_name)
            charDetail=itemView.findViewById(R.id.char_detail)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=inflater.inflate(R.layout.charlist,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.charName.setText(itemList.get(position).name)
        holder.charDetail.setText(itemList.get(position).detail)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
