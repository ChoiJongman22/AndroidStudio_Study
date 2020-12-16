package com.example.review2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager

class AddView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)
        val carList = ArrayList<CarForList>()
        for (i in 0 until 10){
            carList.add(CarForList(""+i+"번째 자동차",""+i+"순위 엔진"))
        }
        val container=findViewById<LinearLayout>(R.id.addview_container)
        val inflater=LayoutInflater.from(this@AddView)
        for (i in 0 until carList.size){
            val itemView=inflater.inflate(R.layout.carview,null)
            val carNameView=itemView.findViewById<TextView>(R.id.car_name)
            val carEngineView=itemView.findViewById<TextView>(R.id.car_engine)
            carNameView.text = carList[i].name
            carEngineView.text = carList[i].engine
            container.addView(itemView)
        }
    }
}

class CarForList(val name: String,val engine: String){

}