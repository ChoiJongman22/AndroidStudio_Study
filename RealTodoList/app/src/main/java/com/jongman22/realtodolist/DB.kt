package com.jongman22.realtodolist

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DB(
    context: Context?,
    name:String?,
    factory:SQLiteDatabase.CursorFactory?,
    version:Int
    ):SQLiteOpenHelper(context,name,factory, VERSION) {

    companion object{
        private const val VERSION = 1
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val sql:String="CREATE TABLE if not exist mytable (" +
                "_id integer primary key autoincrement, "+
                "txt text);";
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}