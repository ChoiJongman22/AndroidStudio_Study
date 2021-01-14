package com.jongman22.simpletodolistwithroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jongman22.simpletodolistwithroom.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var todoViewModel: TodoViewModel
    private val list: ArrayList<Todo> by lazy { arrayListOf<Todo>() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val adapter = TodoAdapter(list) { id ->
            startActivity(Intent(this@MainActivity, EditActivity::class.java).putExtra("id", id))
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        todoViewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)
        todoViewModel.getAllTodos().observe(this, Observer {
            list.clear()
            list.addAll(it!!)
            adapter.notifyDataSetChanged()
        })
        binding.fab.setOnClickListener {
            startActivity(Intent(this@MainActivity, EditActivity::class.java))
        }
    }
}