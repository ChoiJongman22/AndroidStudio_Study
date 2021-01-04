package com.jongman22.realtodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jongman22.realtodolist.databinding.ActivityTodoListVersion2Binding

class TodoList_version2 : AppCompatActivity() {
    private lateinit var binding :ActivityTodoListVersion2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListVersion2Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
    }


}