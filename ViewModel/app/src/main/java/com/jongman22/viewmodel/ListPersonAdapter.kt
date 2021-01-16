package com.jongman22.viewmodel

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.jongman22.viewmodel.databinding.LowlayoutBinding

class ListPersonAdapter(
    internal val activity: Activity,
    internal val Persons: List<Person>,
    internal val e_id: EditText,
    internal val e_name: EditText,
    internal val e_email: EditText
) : BaseAdapter() {
        lateinit var binding: LowlayoutBinding
        internal var inflater:LayoutInflater
        init{
            inflater=activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater }

    override fun getCount(): Int {
        return Persons.size

    }

    override fun getItem(p0: Int): Any {
        return Persons[p0]
    }

    override fun getItemId(p0: Int): Long {
        return Persons[p0].id.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val rowView:View
        rowView=inflater.inflate(R.layout.lowlayout,null)
        binding= LowlayoutBinding.bind(rowView)
        binding.rowId.text=Persons[p0].id.toString()
        binding.rowName.text=Persons[p0].name.toString()
        binding.rowEmail.text=Persons[p0].email.toString()

        rowView.setOnClickListener {
            e_id.setText(binding.rowId.text.toString())
            e_name.setText(binding.rowName.text.toString())
            e_email.setText(binding.rowEmail.text.toString())
        }
        return rowView
    }
}