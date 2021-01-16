package com.jongman22.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter
import com.jongman22.viewmodel.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    internal lateinit var db: DBhelper
    internal var Persons: List<Person> = ArrayList<Person>()
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DBhelper(this)
        refreshData()

        binding.add.setOnClickListener {
            val person = Person(
                Integer.parseInt(binding.person.text.toString()),
                binding.name.toString(),
                binding.email.toString()
            )
            db.addPerson(person)
            refreshData()
        }

        binding.upup.setOnClickListener {
            val person = Person(
                Integer.parseInt(binding.person.text.toString()),
                binding.name.toString(),
                binding.email.toString()
            )
            db.updatePerson(person)
            refreshData()
        }
        binding.delete.setOnClickListener {
            val person = Person(
                Integer.parseInt(binding.person.text.toString()),
                binding.name.toString(),
                binding.email.toString()
            )
            db.deletePerson(person)
            refreshData()
        }

    }

    private fun refreshData() {
        Persons = db.allPerson
        val adapter = ListPersonAdapter(
            this@MainActivity3,
            Persons,
            binding.person,
            binding.name,
            binding.email
        )
        binding.list.adapter = adapter
    }
}