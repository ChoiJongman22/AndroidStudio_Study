package com.jongman22.room_viewmodel

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MemoDao{
    @Query("SELECT * FROM memoTable ORDER BY id DESC")
    fun getAll(): LiveData<List<Memo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memo: Memo)

    @Update
    fun update(memo: Memo)

    @Delete
    fun delete(memo: Memo)

    @Query("DELETE FROM memoTable")
    fun deleteAll()
}