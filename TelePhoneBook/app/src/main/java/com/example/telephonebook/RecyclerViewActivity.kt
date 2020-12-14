package com.example.telephonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val carList=ArrayList<CarForList>()
        for(i in 0 until 50){
            carList.add(CarForList(""+i+" 번째 자동차",""+i+"순위 엔진"))
        }
        val adapter=RecyclerViewAdapter(carList, LayoutInflater.from(this@RecyclerViewActivity))
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(this@RecyclerViewActivity)

    }
}

class RecyclerViewAdapter(
    val itemList: ArrayList<CarForList>,
    val inflater:LayoutInflater
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val carName: TextView
        val carEngine: TextView
        init{ //시작하자 마자 불러오는 것
            carName=itemView.findViewById(R.id.car_name)
            carEngine=itemView.findViewById(R.id.car_engine)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view=inflater.inflate(R.layout.add_carview,parent,false)
            return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.carName.setText(itemList.get(position).name)
            holder.carEngine.setText(itemList.get(position).engine)
    }

    override fun getItemCount(): Int {
            return itemList.size
    }
}