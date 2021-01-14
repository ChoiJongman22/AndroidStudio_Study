package com.jongman22.simpletodolistwithroom

import android.app.Application
import androidx.lifecycle.LiveData
import io.reactivex.Observable


class TodoRepository(application: Application) {

    private val todoDao:TodoDao by lazy{
        val db=TodoRoomDatabase.getInstance(application)!!
        db.todoDao()
    }
    private val todos:LiveData<List<Todo>> by lazy {
        getAllTodos()
    }

    fun getAllTodos():LiveData<List<Todo>>{
        return todos
    }

    fun getTodoById(id:Long):LiveData<Todo>{
        return getTodoById(id)
    }

    fun insert(todo:Todo):Observable<Unit>{
        return Observable.fromCallable { todoDao.insert(todo) }
    }
    fun delete(id:Long):Observable<Unit>{
        return Observable.fromCallable { todoDao.deleteById(id) }
    }

}