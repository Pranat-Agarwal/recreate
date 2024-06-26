package com.example.recreate

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recreate.kotlin.marsphotos
import com.example.vitbatch1.network.api
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {

    var tag = MainActivity::class.java.simpleName

    lateinit var marsrecv : RecyclerView
    lateinit var marsad : marsadapter
    lateinit var photo : List<marsphotos>
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
        marsrecv  = findViewById(R.id.recyclerViewUrl)
        marsrecv.layoutManager=LinearLayoutManager(this)
        photo=ArrayList()
        marsad=marsadapter(photo)
        marsrecv.adapter=marsad

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private  fun photos(){
        GlobalScope.launch (Dispatchers.Main) {

            var listphotos = api.retrofitService.getPhotos()
            marsad.listphotos=listphotos
            marsad.notifyDataSetChanged()
        }
    }

    fun getjson(view : View){
        photos()
    }
}