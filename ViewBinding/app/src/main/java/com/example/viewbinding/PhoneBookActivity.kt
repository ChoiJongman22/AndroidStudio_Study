package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.example.viewbinding.databinding.ActivityPhoneBookBinding
import com.example.viewbinding.databinding.ActivityPhoneBookDetailBinding

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPhoneBookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val phoneBook=createPhoneBook()
        createPhoneBookList(phoneBook)
    }

    fun createPhoneBook(fakeNumber:Int=10,phoneBook:PhoneBook=PhoneBook()):PhoneBook{
        for (i in 0 until fakeNumber){
            phoneBook.addPerson(
                Person(name=""+i+"번째 사람",number=""+i+"번째 전화번호")
            )
        }
        return phoneBook
    }
    fun createPhoneBookList(phoneBook:PhoneBook){
        val layoutInflater=LayoutInflater.from(this@PhoneBookActivity)
        val container = findViewById<LinearLayout>(R.id.phonebook_list_container)
        for(i in 0 until phoneBook.personList.size){
            val view=layoutInflater.inflate(R.layout.phonebook_item,null)
            val personNameView=view.findViewById<TextView>(R.id.person_name)
            personNameView.text=phoneBook.personList[i].name
            container.addView(view)
        }
    }
}

class PhoneBook(){
    val personList=ArrayList<Person>()
    fun addPerson(person:Person){
        personList.add(person)
    }
}
class Person(val name:String,val number:String){

}