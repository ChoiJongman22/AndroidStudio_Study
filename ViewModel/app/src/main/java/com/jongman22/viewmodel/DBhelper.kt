package com.jongman22.viewmodel

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBhelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {
    companion object {
        private val DATABASE_NAME = "SAMPLE.db"
        private val DATABASE_VER = 1

        //Table
        private val TABLE_NAME = "Person"
        private val ID = "Id"
        private val NAME = "Name"
        private val EMAIL = "Email"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY =
            ("CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY,$NAME TEXT,$EMAIL TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    val allPerson: List<Person>
        get() {
            val Persons = ArrayList<Person>()
            val selectQueryHandler = "SELECT * FROM $TABLE_NAME"
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQueryHandler, null)
            if (cursor.moveToFirst()) {
                do {
                    val person = Person()
                    person.id = cursor.getInt(cursor.getColumnIndex(ID))
                    person.name = cursor.getString(cursor.getColumnIndex(NAME))
                    person.email = cursor.getString(cursor.getColumnIndex(EMAIL))

                    Persons.add(person)
                } while (cursor.moveToNext())
            }
            db.close()
            return Persons
        }

    fun addPerson(person: Person) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(ID, person.id)
        values.put(NAME, person.name)
        values.put(EMAIL, person.email)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun updatePerson(person: Person): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(ID, person.id)
        values.put(NAME, person.name)
        values.put(EMAIL, person.email)
        return db.update(TABLE_NAME, values, "$ID=?", arrayOf(person.id.toString()))
    }

    fun deletePerson(person: Person) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$ID=?", arrayOf(person.id.toString()))
        db.close()
    }

}