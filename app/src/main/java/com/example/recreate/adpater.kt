package com.example.recreate

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load

class adpater(var listmmarsphotos: List<Any>) :RecyclerView.Adapter<adpater.marsviewholder> {
    class marsviewholder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var textview:TextView=itemView.findViewById(R.id.textView2)
        var marsimageview:ImageView=itemView.findViewById(R.id.imageView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): marsviewholder {
        var rowplank=LayoutInflater.from(parent.context).inflate(R.layout.rowlayout,parent,false)
        return  marsviewholder(rowplank)
    }

    override fun getItemCount(): Int {
        return listmmarsphotos.size
    }

    override fun onBindViewHolder(holder: marsviewholder, position: Int) {
        var url:String=listmmarsphotos.get(position).imgsrc
        holder.textview.setText(url)
        holder.marsimageview.load(url)
    }

}