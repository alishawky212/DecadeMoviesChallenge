package com.example.decademovieschallenge.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.decademovieschallenge.R
import com.example.decademovieschallenge.inflate
import kotlinx.android.synthetic.main.photo_item.view.*
import javax.inject.Inject

class PhotosAdapter @Inject constructor():RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    private val imagesUrl = mutableListOf<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(parent.inflate(R.layout.photo_item))
    }

    override fun getItemCount(): Int = imagesUrl.size


    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val url = imagesUrl[position]
        holder.bind(url)
    }

    fun setImagesUrl(urls:List<String>){
        val previousDataSetSize = this.imagesUrl.size
        this.imagesUrl.addAll(urls)
        notifyItemChanged(previousDataSetSize, imagesUrl.size)
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(imageUrl: String) {
            with(itemView) {
                Glide.with(context).load(imageUrl).into(movie_photo)
            }
        }
    }
}