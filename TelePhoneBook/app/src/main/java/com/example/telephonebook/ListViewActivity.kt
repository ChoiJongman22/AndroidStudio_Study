package com.example.telephonebook

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*
import org.w3c.dom.Text

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)


        val carList=ArrayList<CarForList>()
        for(i in 0 until 50){
            carList.add(CarForList(""+i+" 번째 자동차",""+i+"순위 엔진"))
        }
        val adapter=ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
        listView.adapter=adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val carName= (adapter.getItem(position) as CarForList).name
            val carEngine=(adapter.getItem(position)as CarForList).engine
            Toast.makeText(this@ListViewActivity,carName+""+carEngine,Toast.LENGTH_SHORT).show()
        }
    }
}

class ListViewAdapter(
        val carForList:ArrayList<CarForList>,
        val layoutInflater: LayoutInflater
      ): BaseAdapter(){
    override fun getCount(): Int {
        return carForList.size
    }

    override fun getItem(position: Int): Any {
        //그리고자 하는 아이템 리스트의 하나
        return carForList.get(position) //listview의 인덱스==position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view :View
        val holder: ViewHolder
        if(convertView == null){
            Log.d("convert","1")
            view=layoutInflater.inflate(R.layout.add_carview,null)
            holder= ViewHolder()
            holder.carName=view.findViewById(R.id.car_name)
            holder.carEngine=view.findViewById((R.id.car_engine))
            view.tag=holder
        }else{
            Log.d("convert","2")
            holder=convertView.tag as ViewHolder
            view=convertView
        }
        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)
        return view
    }
}

class ViewHolder{
    var carName: TextView?=null
    var carEngine:TextView?=null
}