package com.jongman22.todolist_app

import android.graphics.Paint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jongman22.todolist_app.databinding.ActivityMainBinding
import com.jongman22.todolist_app.databinding.TodolistBinding

class MainActivity : AppCompatActivity() {
    private val data = ArrayList<TodoList>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TodoAdapter(data,
                    onClickDeleteIcon = {
                        deleteTodo(it)
            },
                    onClickItem = {
                        toggleTodo(it)
                    }

            )
        }


        binding.addButton.setOnClickListener {
            addTodo()
        }



    }

    private fun toggleTodo(todo: TodoList) {
        todo.isDone = !todo.isDone
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun addTodo() {
        val todo = TodoList(binding.editText.text.toString())
        data.add(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun deleteTodo(todo: TodoList) {
        data.remove(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()

    }
}


data class TodoList(
        val text: String,
        var isDone: Boolean=false
)

class TodoAdapter(
        private val myDataset: ArrayList<TodoList>,
        val onClickDeleteIcon: (todo: TodoList) -> Unit,
        val onClickItem: (todo: TodoList) -> Unit) :
        RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: TodolistBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.todolist, parent, false)
        return TodoViewHolder(TodolistBinding.bind(view))

    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = myDataset[position]
        holder.binding.todoText.text = todo.text

        if (todo.isDone) {
            holder.binding.todoText.apply {
                paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                setTypeface(null, Typeface.ITALIC)
            }
        } else {
            holder.binding.todoText.apply {
                paintFlags = 0
                setTypeface(null, Typeface.NORMAL)
            }

        }

        holder.binding.deleteImageView.setOnClickListener {
            onClickDeleteIcon.invoke(todo)
        }
        holder.binding.root.setOnClickListener {
            onClickItem.invoke(todo)
        }
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

}





