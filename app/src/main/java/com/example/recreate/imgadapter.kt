package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.recreate.R

class imgadapter(private val datalist : ArrayList<itemcar>): RecyclerView.Adapter<imgadapter.imgholder>()
{
    class imgholder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val img:ImageView = itemView.findViewById(R.id.imageView)
        //val checkb:CheckBox = itemView.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): imgadapter.imgholder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout,parent,false)
        return imgholder(itemview)
    }

    override fun onBindViewHolder(holder: imgadapter.imgholder, position: Int) {
        val currentimg = datalist[position]
        holder.img.setImageResource(currentimg.imgsrc)
        //holder.checkb.setText()
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

}