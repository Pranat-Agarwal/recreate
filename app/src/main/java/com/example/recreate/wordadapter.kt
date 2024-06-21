package com.example.recreate

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class wordadapter(var data: Array<String>) :RecyclerView.Adapter<wordadapter.wordsviewholder>() {

    var tag = wordsviewholder::class.java.simpleName
    class wordsviewholder (itemView: RecyclerView) :ViewHolder(itemView){
        init {
            Log.i("wordadpater","find textview")
        }
            var tvrowitem = itemView.findViewById<TextView>(R.id.tvrow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): wordsviewholder {
        Log.i(tag,"item add")
        var rowpl=LayoutInflater.from(parent.context).inflate(R.layout.row_layout_item,parent,false)
        return wordsviewholder(rowpl)
    }

    override fun getItemCount(): Int {
        Log.i(tag,"count"+data.size)
        return data.size
    }

    override fun onBindViewHolder(holder: wordsviewholder, position: Int) {
        Log.i(tag,"writing"+data[position])
        holder.tvrowitem.setText((data[position]))
    }
}
