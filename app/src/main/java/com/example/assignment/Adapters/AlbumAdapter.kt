package com.example.assignment.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment.R
import com.example.assignment.model.Album
import kotlinx.android.synthetic.main.album_layout.view.*

class AlbumAdapter(
    val list: MutableList<Album>
) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.album_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val album=list[position]
        holder.itemView.title.text=album.name
        holder.itemView.artist.text=album.artist.name
        val i = album.image.size
        Glide.with(holder.itemView.image).load(album.image[i-1].text).into(holder.itemView.image)

    }

    override fun getItemCount(): Int {
        return  list.size
    }
}