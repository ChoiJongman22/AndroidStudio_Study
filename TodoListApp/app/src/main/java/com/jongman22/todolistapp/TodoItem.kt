package com.jongman22.todolistapp

class TodoItem {

    var title = "Default"
    var checked = false

    constructor(_title: String, _isCheck: Boolean){
        this.title = _title
        this.checked = _isCheck
    }

    fun title() : String = title
    fun checked() : Boolean = checked
}