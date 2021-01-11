package com.jongman22.realtodolist.Gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.jongman22.realtodolist.R
import com.jongman22.realtodolist.databinding.ActivityGalleryAppBinding

class GalleryApp : AppCompatActivity(), GalleryImageClickListener {
    private lateinit var binding :ActivityGalleryAppBinding
    private val SPAN_COUNT = 2

    private val imageList = ArrayList<Image>()
    lateinit var galleryAdapter: GalleryImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGalleryAppBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        galleryAdapter= GalleryImageAdapter(imageList)
        galleryAdapter.listener=this

        binding.recyclerView.layoutManager=GridLayoutManager(this,SPAN_COUNT)
        binding.recyclerView.adapter=galleryAdapter

        loadImages()
    }

    private fun loadImages() {

        imageList.add(Image("https://i.ibb.co/wBYDxLq/beach.jpg", "Beach Houses"))
        imageList.add(Image("https://i.ibb.co/gM5NNJX/butterfly.jpg", "Butterfly"))
        imageList.add(Image("https://i.ibb.co/10fFGkZ/car-race.jpg", "Car Racing"))
        imageList.add(Image("https://i.ibb.co/ygqHsHV/coffee-milk.jpg", "Coffee with Milk"))
        imageList.add(Image("https://i.ibb.co/7XqwsLw/fox.jpg", "Fox"))
        imageList.add(Image("https://i.ibb.co/L1m1NxP/girl.jpg", "Mountain Girl"))
        imageList.add(Image("https://i.ibb.co/wc9rSgw/desserts.jpg", "Desserts Table"))
        imageList.add(Image("https://i.ibb.co/wdrdpKC/kitten.jpg", "Kitten"))
        imageList.add(Image("https://i.ibb.co/dBCHzXQ/paris.jpg", "Paris Eiffel"))
        imageList.add(Image("https://i.ibb.co/JKB0KPk/pizza.jpg", "Pizza Time"))
        imageList.add(Image("https://i.ibb.co/VYYPZGk/salmon.jpg", "Salmon "))
        imageList.add(Image("https://i.ibb.co/JvWpzYC/sunset.jpg", "Sunset in Beach"))

        galleryAdapter.notifyDataSetChanged()
    }

    override fun onClick(position: Int) {
        // handle click of image

        val bundle = Bundle()
        bundle.putSerializable("images", imageList)
        bundle.putInt("position", position)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val galleryFragment = GalleryFullscreenFragment()
        galleryFragment.arguments = bundle
        galleryFragment.show(fragmentTransaction, "gallery")
    }
}
