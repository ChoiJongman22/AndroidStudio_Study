package com.jongman22.simpletodolistwithroom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: Todo)

    @Query("DELETE FROM todo WHERE id = :id")
    fun deleteById(id: Long)

    @Query("SELECT * FROM todo ORDER BY date DESC")
    fun getAllTodos(): LiveData<List<Todo>>

    @Query("SELECT * FROM todo WHERE id = :id")
    fun getTodoById(id: Long): LiveData<Todo>
}