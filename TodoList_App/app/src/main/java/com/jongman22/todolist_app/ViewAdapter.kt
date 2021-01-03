package com.jongman22.todolist_app

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.jongman22.todolist_app.databinding.ItemRecyclerViewBinding


class RecyclerViewAdapter(list: ArrayList<TodoItem>, _context: Context) : RecyclerView.Adapter<CustomViewHolder>() {

    private var todoList: ArrayList<TodoItem> = list
    private val context = _context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view,parent,false)
        return CustomViewHolder(ItemRecyclerViewBinding.bind(view))
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val db = DBHelper(context).writableDatabase
        holder.binding.itemTitle.text = todoList.get(position).title
        holder.binding.itemTitle.setChecked(todoList.get(position).checked)
        holder.binding.itemDelete.setOnClickListener {
            db.execSQL("DELETE FROM todolist WHERE title = ('${todoList[position].title}')")
            todoList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, todoList.size)
        }
    }
}

class CustomViewHolder(val binding:ItemRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {

}
