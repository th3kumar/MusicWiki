package com.example.assignment.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment.R
import com.example.assignment.model.Artist
import com.example.assignment.model.ArtistX
import kotlinx.android.synthetic.main.artist_layout.view.*

class ArtistAdapter(
     val list: MutableList<Artist>
): RecyclerView.Adapter<ArtistAdapter.ViewHolder>() {

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.artist_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artist=list[position]
        holder.itemView.name.text=artist.name
        val i = artist.image.size
        Glide.with(holder.itemView.image).load(artist.image[i-1].text).into(holder.itemView.image)

    }

    override fun getItemCount(): Int {
        return  list.size
    }
}