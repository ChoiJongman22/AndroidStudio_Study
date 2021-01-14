package com.jongman22.simpletodolistwithroom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")

data class Todo(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var title: String = "",
    var date: Long = 0

)

