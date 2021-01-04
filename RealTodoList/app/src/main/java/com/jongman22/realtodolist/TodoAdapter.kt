package com.jongman22.realtodolist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jongman22.realtodolist.databinding.TodoitemBinding

class TodoAdapter(list:ArrayList<TodoItem>,context: Context):RecyclerView.Adapter<TodoAdapter.TodoViewholder>() {
    private var todolist:ArrayList<TodoItem> = list
    private var _context = context
    inner class TodoViewholder(val binding:TodoitemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewholder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.todoitem,parent,false)
        return TodoViewholder(TodoitemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: TodoViewholder, position: Int) {
        val db = DB(_context).writableDatabase
        holder.binding.itemTitle.text=todolist[position].title
        holder.binding.itemTitle.setChecked(todolist.get(position).checked)
        holder.binding.itemDelete.setOnClickListener {
            db.execSQL("DELETE FROM todolist WHERE title =('${todolist[position].title}')")
            todolist.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,todolist.size)
        }
    }

    override fun getItemCount(): Int {
        return todolist.size
    }
}