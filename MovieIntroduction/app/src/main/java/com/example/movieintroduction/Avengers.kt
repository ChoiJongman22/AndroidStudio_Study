package com.example.movieintroduction

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieintroduction.databinding.ActivityAvengersBinding

class Avengers : AppCompatActivity() {
    private val adapter = AvengersAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityAvengersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movie_recycler = findViewById<RecyclerView>(R.id.recycler_view)
        movie_recycler.layoutManager=LinearLayoutManager(this)
        movie_recycler.adapter=adapter

        adapter.setItems(SampleData().getItems())
    }


}

class AvengersAdapter: RecyclerView.Adapter<AvengersAdapter.MovieViewHolder>(){
    private var items =  ArrayList<AvengersList>()
    inner class MovieViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var char_View: ImageView
        var char_Name: TextView
        var char_Detail: TextView

        init{
            char_View=itemView.findViewById(R.id.char_image)
            char_Name=itemView.findViewById(R.id.char_name)
            char_Detail=itemView.findViewById(R.id.char_detail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView:View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_character, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item=items[position]
        Glide.with(holder.itemView.context)
                .load(item.getUrl())
                .centerCrop()
                .into(holder.char_View)

        holder.char_Name.text=item.getName()
        holder.char_Detail.text=item.getDetail()

        /*if(item.getName() == "Iron Man"){
            holder.itemView.setOnClickListener{
                val intent = Intent(holder.itemView?.context,IronmanActivity::class.java)
                ContextCompat.startActivity(holder.itemView.context,intent,null)
            }
        }
        else if(item.getName() == "Captain America"){
            holder.itemView.setOnClickListener{
                val intent = Intent(holder.itemView?.context,CaptainAmerica::class.java)
                ContextCompat.startActivity(holder.itemView.context,intent,null)
            }
        }*/

        when(position){
            0->{
                holder.itemView.setOnClickListener{
                    val intent = Intent(holder.itemView?.context,IronmanActivity::class.java)
                    ContextCompat.startActivity(holder.itemView.context,intent,null)
                }
            }
            1->{
                holder.itemView.setOnClickListener{
                    val intent = Intent(holder.itemView?.context,CaptainAmerica::class.java)
                    ContextCompat.startActivity(holder.itemView.context,intent,null)
                }
            }
            2->{
                holder.itemView.setOnClickListener{
                    val intent = Intent(holder.itemView?.context,BlackWidowActivity::class.java)
                    ContextCompat.startActivity(holder.itemView.context,intent,null)
                }
            }
            3->{
                holder.itemView.setOnClickListener{
                    val intent = Intent(holder.itemView?.context,HulkActivity::class.java)
                    ContextCompat.startActivity(holder.itemView.context,intent,null)
                }
            }
            4->{
                holder.itemView.setOnClickListener{
                    val intent = Intent(holder.itemView?.context,WandaActivity::class.java)
                    ContextCompat.startActivity(holder.itemView.context,intent,null)
                }
            }

            5->{
                holder.itemView.setOnClickListener{
                    val intent = Intent(holder.itemView?.context,ThorActivity::class.java)
                    ContextCompat.startActivity(holder.itemView.context,intent,null)
                }
            }


        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: ArrayList<AvengersList>) {
        this.items = items
    }

}

class SampleData{
    private var items=ArrayList<AvengersList>()
    fun getItems():ArrayList<AvengersList>{
        val ironman = AvengersList(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1OUc3yyjivFZLOITp22XkH-cQ6rL9PCZuDw&usqp=CAU",
                "Iron Man", "11"
        )
        val captain = AvengersList(
                "https://cdn.britannica.com/30/182830-050-96F2ED76/Chris-Evans-title-character-Joe-Johnston-Captain.jpg",
                "Captain America", "11"
        )
        val nat = AvengersList(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7QirLzkxIjUBpQuRMqmjiQJ8GiXIqdJNb-Q&usqp=CAU",
                "Black Widow", "11"
        )
        val hulk = AvengersList(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3fU0sb_wvdIi3MUsqRUv1SFifr6m_ywA2SA&usqp=CAU",
            "Hulk","11"
        )
        val wanda = AvengersList(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcE0PHCgx3c8n8lEJPIiNrtxY7t-A2F4UQ1Q&usqp=CAU",
            "Scarlet witch","11"
        )
        val thor = AvengersList(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9Wj_xZJvtuvNhXnR0O9qCVrP6P6Ab9CGd3g&usqp=CAU",
            "Thor","11"
        )
        items.add(ironman)
        items.add(captain)
        items.add(nat)
        items.add(hulk)
        items.add(wanda)
        items.add(thor)
        return items
    }
}




class AvengersList(val url: String?, val name: String?, val detail: String?){

    @JvmName("getUrl1")
    fun getUrl(): String? {
        return this.url
    }

    @JvmName("getName1")
    fun getName(): String? {
        return this.name
    }

    @JvmName("getDetail1")
    fun getDetail(): String? {
        return this.detail
    }
}