package com.jongman22.simpletodolistwithroom

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.jongman22.simpletodolistwithroom.databinding.ActivityEditBinding
import java.util.*

class EditActivity : AppCompatActivity() {

    private val calendar = Calendar.getInstance()
    private lateinit var todoViewModel: TodoViewModel
    private lateinit var binding:ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoViewModel=ViewModelProviders.of(this).get(TodoViewModel::class.java)
        val id =intent.getLongExtra("id",-1L)
        if(id==-1L){
            insertMode()
        }else{
            updateMode(id)
        }
        binding.calendarView.setOnDateChangeListener{view, year,month, dayOfMonth->
            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,month)
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
        }
    }
    @SuppressLint("RestrictedApi")
    private fun insertMode(){
        binding.deleteFab.visibility= View.GONE
        binding.doneFab.setOnClickListener {
            insertTodo()
        }
    }
    private fun updateMode(id:Long){
        todoViewModel.getTodoById(id).observe(this, androidx.lifecycle.Observer{ todo->
            todo?.let{
                binding.todoEditText.setText(todo.title)
                binding.calendarView.date=todo.date
            }
        })
        binding.doneFab.setOnClickListener {
            updateTodo(id)
        }
        binding.deleteFab.setOnClickListener {
            deleteTodo(id)
        }
    }
    private fun insertTodo(){
        val todo=Todo(0,
        binding.todoEditText.text.toString(),
        calendar.timeInMillis)
        todoViewModel.insert(todo){finish()}
    }

    private fun updateTodo(id:Long){
        val todo=Todo(id,
        binding.todoEditText.text.toString(),
        calendar.timeInMillis)
        todoViewModel.insert(todo){finish()}
    }
    private fun deleteTodo(id:Long){
        todoViewModel.delete(id){finish()}
    }
}