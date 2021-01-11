package com.jongman22.realtodolist.Gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.jongman22.realtodolist.R
import com.jongman22.realtodolist.databinding.ItemGalleryImageBinding

class GalleryImageAdapter(private val itemList: List<Image>) :
    RecyclerView.Adapter<GalleryImageAdapter.GalleryViewHolder>() {
    private var context: Context? = null
    var listener: GalleryImageClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_gallery_image, parent, false)
        return GalleryViewHolder(ItemGalleryImageBinding.bind(view))
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class GalleryViewHolder(val binding: ItemGalleryImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val image = itemList.get(adapterPosition)

            Glide.with(context!!)
                .load(image.imageUrl)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivGalleryImage)
        }
    }

}