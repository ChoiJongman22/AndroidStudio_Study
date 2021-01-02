package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding.databinding.ActivityRecyclerViewBinding


class RecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val carList = ArrayList<CarForList>()
        for(i in 0 until 50){
            carList.add(CarForList(""+ i +"번째 자동차",""+i+"순위 엔진"))
        }
        val adapter = RecyclerAdapter(carList, LayoutInflater.from(this@RecyclerView))
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(this@RecyclerView)
        //binding.recyclerView.layoutManager= GridLayoutManager(this@RecyclerView,2)
    }
}

class RecyclerAdapter(
        val itemList:ArrayList<CarForList>,
        val inflater: LayoutInflater
):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val carName:TextView = itemView.findViewById(R.id.car_name)
        val carEngine:TextView = itemView.findViewById(R.id.car_engine)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=inflater.inflate(R.layout.car_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.text=itemList[position].name
        holder.carEngine.text=itemList[position].engine
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
