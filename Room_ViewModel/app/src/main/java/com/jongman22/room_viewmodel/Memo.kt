package com.jongman22.room_viewmodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memoTable")
data class Memo(
    @PrimaryKey
    var id: Long?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "contents")
    var contents: String?
)