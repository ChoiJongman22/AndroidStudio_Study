package com.jongman22.realtodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.jongman22.realtodolist.databinding.ActivityTodoListVersion2Binding

class TodoList_version2 : AppCompatActivity() {
    private lateinit var binding :ActivityTodoListVersion2Binding
    var todoList: ArrayList<TodoItem> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListVersion2Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        setSupportActionBar(binding.Toolbar)
        binding.Toolbar.title="TodoList"

        var todoListAdapter:TodoAdapter= TodoAdapter(todoList,this)
        binding.recyclerView.adapter=todoListAdapter

        val username = findViewById<EditText>(R.id.edit)
        username.onRightDrawableClicked {
            it.text.clear()
        }

        addRightCancelDrawable(findViewById(R.id.edit))
        binding.add.setOnClickListener {
            val db = DB(this).writableDatabase
            db.execSQL("insert into todolist values (\'${binding.edit.text}\')")
            Toast.makeText(this, "Todo 생성 완료", Toast.LENGTH_LONG).show()
            todoList.add(TodoItem(binding.edit.text.toString(), false))
            todoListAdapter!!.notifyItemInserted(todoList.size)
        }

        binding.clear.setOnClickListener {
            todoList.clear()
            todoListAdapter.notifyDataSetChanged()
        }
    }


    private fun addRightCancelDrawable(editText: EditText) {
        val cancel = ContextCompat.getDrawable(this, R.drawable.ic_baseline_cancel_24)
        cancel?.setBounds(0,0, cancel.intrinsicWidth, cancel.intrinsicHeight)
        editText.setCompoundDrawables(null, null, cancel, null)
    }


    fun EditText.onRightDrawableClicked(onClicked: (view: EditText) -> Unit) {
        this.setOnTouchListener { v, event ->
            var hasConsumed = false
            if (v is EditText) {
                if (event.x >= v.width - v.totalPaddingRight) {
                    if (event.action == MotionEvent.ACTION_UP) {
                        onClicked(this)
                    }
                    hasConsumed = true
                }
            }
            hasConsumed
        }
    }



    fun initTodoData():ArrayList<TodoItem>{
        val dbHelper=DB(this)
        dbHelper.onCreate(dbHelper.writableDatabase)
        val db=dbHelper.writableDatabase
        val cursor=db.rawQuery("select*from todolist",null)

        val count = cursor.count
        if(count>=1){
            while(cursor.moveToNext()){
                val title=cursor.getString(0)
                todoList.add(TodoItem(title,false))
            }
        }
        cursor.close()
        return todoList
    }
}