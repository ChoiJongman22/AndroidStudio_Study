package com.jongman22.realtodolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.applikeysolutions.cosmocalendar.selection.OnDaySelectedListener
import com.applikeysolutions.cosmocalendar.selection.RangeSelectionManager
import com.jongman22.realtodolist.databinding.ActivityMyCalendarBinding

class MyCalendar : AppCompatActivity() {
    private lateinit var binding :ActivityMyCalendarBinding
    var todoList: ArrayList<TodoItem> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMyCalendarBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
        binding.calendarView.isShowDaysOfWeekTitle = false


        binding.calendarView.setOnClickListener{
            val intent = Intent(this@MyCalendar,TodoList_version2::class.java)
            startActivity(intent)
        }

    }
}


