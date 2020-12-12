package com.example.review

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_harry_potter_char.*
import kotlinx.android.synthetic.main.activity_harry_potter_main.*

class HarryPotterChar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harry_potter_char)

        val charList=ArrayList<CharList>()
        charList.add(CharList("Harry Potter","영화의 주인공, 볼드모트 생존자"))
        charList.add(CharList("Ronald","영화의 조연, 해리의 조력자"))
        charList.add(CharList("Hermionne","영화의 조연, 똑똑하고 예쁨"))
        charList.add(CharList("Draco","영화의 조연, Shut Up, MalFoy"))
        val adapter=CharListAdapter(charList, LayoutInflater.from(this@HarryPotterChar))
        listView.adapter=adapter
    }
}


class CharList(val name:String,val detail:String){

}

class CharListAdapter(
        val charList:ArrayList<CharList>,
        val layoutInflater: LayoutInflater
): BaseAdapter(){
    override fun getCount(): Int {
        return charList.size
    }

    override fun getItem(position: Int): Any {
        return charList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view=layoutInflater.inflate(R.layout.charlist,null)
        val charNameTextview=view.findViewById<TextView>(R.id.char_name)
        val charDetailTextview=view.findViewById<TextView>(R.id.char_detail)
        charNameTextview?.text = charList.get(position).name
        charDetailTextview?.text = charList.get(position).detail
        return view
    }
}
