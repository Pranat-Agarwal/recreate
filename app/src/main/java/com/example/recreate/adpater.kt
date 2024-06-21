package com.example.recreate

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

class adpater(var listmmarsphotos: List<Any>) :RecyclerView.Adapter<adpater.marsviewholder> {
    class marsviewholder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var textview:TextView=itemView.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): marsviewholder {
        var rowplank=LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1,parent,false)
        return  marsviewholder(rowplank)
    }

    override fun getItemCount(): Int {
        return listmmarsphotos.size
    }

    override fun onBindViewHolder(holder: marsviewholder, position: Int) {
        holder.textview.setText((listmmarsphotos.get(position).imgsrc))
    }

}