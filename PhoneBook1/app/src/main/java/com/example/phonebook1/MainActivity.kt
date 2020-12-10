package com.example.phonebook1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val phoneBook = createFakePhoneBook(30)
        createPhoneBookList(phoneBook)
    }
    fun createFakePhoneBook(fakeNumber:Int = 10 , phoneBook: PhoneBook= PhoneBook()):PhoneBook{
        for(i in 0 until fakeNumber){
            phoneBook.addPerson(Person(name=""+i+"번째 사람", number=""+i+"번째 사람의 전화번호"))

        }
        return phoneBook
    }
    fun createPhoneBookList(phoneBook:PhoneBook){
        val layoutInflater=LayoutInflater.from(this@MainActivity)
        val container=findViewById<LinearLayout>(R.id.phonebook_list_container)
        for(i in 0 until phoneBook.personList.size){
            val view = layoutInflater.inflate(R.layout.phonebook,null)
            val personNameView = view.findViewById<TextView>(R.id.person_name)
            personNameView.setText(phoneBook.personList.get(i).name)
            container.addView(view)


        }
    }
}

class PhoneBook(){
    //전화번호부
    val personList=ArrayList<Person>()
    fun addPerson(person: Person){
        personList.add(person)
    }
}
class Person(val name:String,val number:String){

}