package com.jongman22.todolist_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jongman22.todolist_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val data  = ArrayList<TodoList>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        data.add(TodoList("숙제",false))
        data.add(TodoList("청소",false))
        val recyclerfind =findViewById<RecyclerView>(R.id.recycler_view)

        recyclerfind.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerfind.adapter = TodoAdapter(data)
        binding.addButton.setOnClickListener {
            addTodo()
        }

    }

    private fun addTodo(){
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val todo = TodoList(binding.editText.text.toString(),false)
        data.add(todo)
        val recyclerfind =findViewById<RecyclerView>(R.id.recycler_view)
        recyclerfind.adapter?.notifyDataSetChanged()
    }

}

data class TodoList(val text:String, var isDone :Boolean)

class TodoAdapter(private var Data:ArrayList<TodoList>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    inner class TodoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val todoitem : TextView
        init{
            todoitem = itemView.findViewById(R.id.todo_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemView:View = LayoutInflater.from(parent.context).inflate(R.layout.todolist,parent,false)
        return TodoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.todoitem.text = Data[position].text
    }

    override fun getItemCount(): Int {
        return Data.size
    }
}




