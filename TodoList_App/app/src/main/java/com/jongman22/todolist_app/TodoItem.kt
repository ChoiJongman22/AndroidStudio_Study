package com.jongman22.todolist_app

class TodoItem {

    var title = "Default"
    var checked = false

    constructor(_title: String, _isCheck: Boolean){
        title = _title
        checked = _isCheck
    }

    fun title() : String = title
    fun checked() : Boolean = checked
}