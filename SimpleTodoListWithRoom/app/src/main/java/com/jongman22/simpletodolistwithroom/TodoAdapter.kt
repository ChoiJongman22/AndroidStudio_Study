package com.jongman22.simpletodolistwithroom

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jongman22.simpletodolistwithroom.databinding.ItemTodoBinding

class TodoAdapter(
    private val list: List<Todo>,
    private val click: (Long) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(ItemTodoBinding.bind(view))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item=list[position]
        holder.binding.text1.text=item.title
        holder.binding.text2.text= DateFormat.format("yyyy/MM/dd",item.date)
        holder.itemView.setOnClickListener{
            click(item.id)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

}