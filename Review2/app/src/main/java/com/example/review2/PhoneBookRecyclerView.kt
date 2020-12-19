package com.example.review2

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
import kotlinx.android.synthetic.main.activity_phone_book_recycler_view.*

class PhoneBookRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_recycler_view)

        //val phoneBook=createPhoneBook(30) //이걸 그냥 선언하지 말고 만들기
        //val phoneBookRecyclerAdapter=PhoneBookRecyclerAdapter(
            //phonebookList = createPhoneBook(30), //이렇게
            //변수를 많이 만드는 것은 관리포인트가 많아지는 것 -> 그래서 관리포인트를 줄이기 위해서
            //phonebookList = phoneBook,
            //inflater = LayoutInflater.from(this@PhoneBookRecyclerView),
            //activity = this)


        //phone_book_recyclerview.adapter=phoneBookRecyclerAdapter
        //phone_book_recyclerview.layoutManager=LinearLayoutManager(this@PhoneBookRecyclerView)

        //위의 것들을 다음과 같이 간단하게 선언해버리자
        with(phone_book_recyclerview){
            this.adapter=PhoneBookRecyclerAdapter(

                //변수를 많이 만드는 것은 관리포인트가 많아지는 것 -> 그래서 관리포인트를 줄이기 위해서
                phonebookList = createPhoneBook(30),
                inflater = LayoutInflater.from(this@PhoneBookRecyclerView),
                activity = this@PhoneBookRecyclerView)

            this.layoutManager =LinearLayoutManager(this@PhoneBookRecyclerView)
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
    val phonebookList:PhoneBook,
    val inflater:LayoutInflater,
    val activity : Activity
):RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val personName : TextView
        init{
            personName= itemView.findViewById(R.id.person_name)
            itemView.setOnClickListener {
                val intent= Intent(activity,PhoneBookDetailAcitivty::class.java)
                intent.putExtra("name",phonebookList.personList.get(adapterPosition).name)
                intent.putExtra("number",phonebookList.personList.get(adapterPosition).number)
                activity.startActivity(intent)
                //startActivity는 Appcompat이 있기 때문에 사용가능하지만 해당 클래스는 상속받지 않았다.
                //그래서 acitivty라는 변수가 이미 해당 액티비티이기때문에 이 액티비티를 통해 접근해야한다.
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=inflater.inflate(R.layout.phonebook_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(phonebookList.personList.get(position).name)
    }

    override fun getItemCount(): Int {
        return phonebookList.personList.size
    }
}