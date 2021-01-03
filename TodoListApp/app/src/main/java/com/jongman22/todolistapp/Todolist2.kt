package com.jongman22.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.jongman22.todolistapp.databinding.ActivityTodolist2Binding

class Todolist2 : AppCompatActivity() {
    var todoList: ArrayList<TodoItem> = arrayListOf()
    var todoListAdapter: RecyclerViewAdapter? = null
    private lateinit var binding : ActivityTodolist2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTodolist2Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = "TO Do List"

        binding.fab.setOnClickListener { view ->
            showAddListDialog()
        }

        initRecyclerView()
    }

    fun initRecyclerView() {

        todoListAdapter = RecyclerViewAdapter(initTodoData(), this)

        binding.mainTodolist.layoutManager = LinearLayoutManager(applicationContext)
        binding.mainTodolist.adapter = todoListAdapter
    }

    fun initTodoData(): ArrayList<TodoItem> {

        val dbHelper = DBHelper(this)
        dbHelper.onCreate(dbHelper.writableDatabase)
        val db = dbHelper.writableDatabase
        val cursor = db.rawQuery("select * from todolist", null)

        val count = cursor.count
        if (count >= 1) {
            while (cursor.moveToNext()) {
                val title = cursor.getString(0)
                todoList.add(TodoItem(title, false))
            }
        }
        cursor.close()

        return todoList
    }

    fun showAddListDialog() {

        val db = DBHelper(this).writableDatabase
        val titleEdit: EditText = EditText(this)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("할 일 추가")
        builder.setMessage("할 일을 적으세요.")
        builder.setView(titleEdit)
        builder.setPositiveButton("확인") { _, _ ->
            db.execSQL("insert into todolist values (\'${titleEdit.text}\')")
            Toast.makeText(this, "Todo 생성 완료", Toast.LENGTH_LONG).show()
            todoList.add(TodoItem(titleEdit.text.toString(), false))
            todoListAdapter!!.notifyItemInserted(todoList.size)
        }
        builder.setNegativeButton("취소") { _, _ -> }
        builder.show()
    }
}