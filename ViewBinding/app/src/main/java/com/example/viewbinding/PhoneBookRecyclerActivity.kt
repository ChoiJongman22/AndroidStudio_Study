package com.example.viewbinding

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding.databinding.ActivityPhoneBookRecyclerBinding

class PhoneBookRecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPhoneBookRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

      //  val phoneBook=createPhoneBook(30)
     //   val phoneBookRecyclerAdapter=PhoneBookRecyclerAdapter(
         //   phoneBookList=phoneBook,
        //    inflater= LayoutInflater.from(this@PhoneBookRecyclerActivity),
        //    activity=this
       // )
       // binding.phoneBookRecyclerview.adapter=phoneBookRecyclerAdapter
        //binding.phoneBookRecyclerview.layoutManager= LinearLayoutManager(this@PhoneBookRecyclerActivity)
        with(binding.phoneBookRecyclerview){
            this.adapter=PhoneBookRecyclerAdapter(

                //변수를 많이 만드는 것은 관리포인트가 많아지는 것 -> 그래서 관리포인트를 줄이기 위해서
                phoneBookList = createPhoneBook(30),
                inflater = LayoutInflater.from(this@PhoneBookRecyclerActivity),
                activity = this@PhoneBookRecyclerActivity)

            this.layoutManager =LinearLayoutManager(this@PhoneBookRecyclerActivity)
        }



    }
    fun createPhoneBook(fakeNumber:Int = 10 ,phoneBook:PhoneBook=PhoneBook()):PhoneBook{
        for(i in 0 until fakeNumber){
            phoneBook.addPerson(
                Person(name=""+i+"번째 사람", number=""+i+"번째 사람의 전화번호")
            )
        }
        return phoneBook
    }
}

class PhoneBookRecyclerAdapter(
    val phoneBookList:PhoneBook,
    val inflater:LayoutInflater,
    val activity: Activity
):RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val personName: TextView
        init{
            personName=itemView.findViewById(R.id.person_name)
            itemView.setOnClickListener{
                val intent= Intent(activity,PhoneBookDetailActivity::class.java)
                intent.putExtra("name",phoneBookList.personList[adapterPosition].name)
                intent.putExtra("number",phoneBookList.personList[adapterPosition].number)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=inflater.inflate(R.layout.phonebook_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.text=phoneBookList.personList[position].name
    }

    override fun getItemCount(): Int {
        return phoneBookList.personList.size
    }
}