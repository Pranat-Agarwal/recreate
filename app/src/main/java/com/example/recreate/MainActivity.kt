package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recreate.R

class MainActivity : AppCompatActivity() {

    private lateinit var recv:RecyclerView
    private lateinit var datalist:ArrayList<itemcar>
    lateinit var imagelist:Array<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        imagelist= arrayOf(
            R.drawable.car1,
            R.drawable.car2,
            R.drawable.car3,
            R.drawable.car4,
            R.drawable.car5,
            R.drawable.car6,
            R.drawable.car7,
            R.drawable.car8,
            R.drawable.car9,
            R.drawable.car10,
            R.drawable.car11,
            R.drawable.car12,
            R.drawable.car13,
            R.drawable.car14,
            R.drawable.car15,
        )

        recv = findViewById(R.id.recyclerview)
        recv.layoutManager = LinearLayoutManager(this)
        recv.setHasFixedSize(true)

        datalist= arrayListOf<itemcar>()
        getdata()

    }

    private fun getdata(){
        for(i in imagelist.indices){
            val dataclass = itemcar(imagelist[i])
            datalist.add(dataclass)
        }

        recv.adapter = imgadapter(datalist)
    }
}