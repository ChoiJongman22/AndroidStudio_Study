package com.jongman22.room_viewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jongman22.room_viewmodel.databinding.RvItemBinding

class RecyclerAdapter(val db: MemoDatabase, var items: List<Memo>?) : RecyclerView.Adapter<RecyclerAdapter.MemoViewHolder>() {
    lateinit var mContext: Context

    inner class MemoViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var index: Int? = null

        fun bind(memo:Memo,position: Int){
            index=position
            binding.tvTitle.text = memo.title
            binding.tvContents.setText(memo.contents)
            binding.btnSave.setOnClickListener{
                editData(binding.tvContents.getText().toString())
            }
        }

        fun editData(contents:String) {
            Thread{
                index?.let{items!!.get(it).contents=contents}
                index?.let{items!!.get(it)}?.let{db.memoDao().update(it)};
            }.start()
            Toast.makeText(mContext,"저장완료",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        mContext=parent.context
        return MemoViewHolder(RvItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bind(items!!.get(position),position)
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    fun getItem():List<Memo>?{
        return items
    }
}