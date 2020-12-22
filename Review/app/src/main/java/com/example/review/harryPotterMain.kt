package com.example.review

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_harry_potter_char.*
import kotlinx.android.synthetic.main.activity_harry_potter_main.*
import org.w3c.dom.Text
import java.nio.file.Files.size

class harryPotterMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harry_potter_main)

        character.setOnClickListener {
            val intent = Intent(this@harryPotterMain,HarryRecyclerViewActivity::class.java)
            startActivity(intent)
        }




    }
}



