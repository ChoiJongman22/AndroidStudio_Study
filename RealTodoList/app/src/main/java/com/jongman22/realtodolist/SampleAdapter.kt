package com.jongman22.realtodolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jongman22.realtodolist.databinding.ItemBinding

class SampleAdapter(private val dataset: List<Int>) :
    RecyclerView.Adapter<NumViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumViewHolder {
        val View: LinearLayout=LayoutInflater.from(parent.context)
            .inflate(R.layout.item,parent,false) as LinearLayout
        return NumViewHolder(ItemBinding.bind(View))
    }

    override fun onBindViewHolder(holder: NumViewHolder, position: Int) {
        if(position<dataset.size){
            holder.Number.text=dataset[position].toString()
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}

class NumViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val Number = binding.number

}