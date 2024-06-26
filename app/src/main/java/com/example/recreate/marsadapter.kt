package com.example.recreate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recreate.kotlin.marsphotos

class marsadapter(var listphotos : List<marsphotos>): RecyclerView.Adapter<marsadapter.marsholder>()
{
    class marsholder(itemview : View):RecyclerView.ViewHolder(itemview) {
        var textView : TextView = itemview.findViewById(R.id.tvUrl)
        var marsimg : ImageView = itemview.findViewById(R.id.iPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): marsadapter.marsholder {
        var row = LayoutInflater.from(parent.context).inflate(R.layout.layout,parent,false)
        return marsholder(row)
    }

    override fun onBindViewHolder(holder: marsadapter.marsholder, position: Int) {
        var  url : String = listphotos.get(position).imgsrc
        holder.textView.setText(url)
        holder.marsimg.load(url)
    }

    override fun getItemCount(): Int {
        return listphotos.size
    }
}