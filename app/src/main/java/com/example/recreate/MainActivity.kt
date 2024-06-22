package com.example.recreate

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recreate.databinding.ActivityMainBinding
import com.example.recreate.network.marsapi
import com.example.recreate.network.marsphoto
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    val photomarsdatabinding=marsphoto("007","moonimg.com")

    //lateinit var marsrecyclerview:RecyclerView
    lateinit var marsadpater:adpater
    lateinit var photos:List<marsphoto>
    lateinit var imageview:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        val  binding:ActivityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.marsphotos=photomarsdatabinding
        //binding= ActivityMainBinding.inflate(layoutInflater)
       // val view = binding.root
       // setContentView(view)
       // imageview=findViewById(R.id.imageView)
        //marsrecyclerview=findViewById(R.id.recyclerview)
        binding.recyclerview.layoutManager=LinearLayoutManager(this)
        photos=ArrayList()
        marsadpater=adpater(photos)
        binding.recyclerview.adapter=marsadpater
        //marsadpater=adpater(photos)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun getweather(cityname:String):String{
        return "{ temp:32 , windspeed:40 }"
    }

    fun gettemp(city:String):Int{
        return 25
    }

    private fun getmarsphotos(){
        GlobalScope.launch {
            var listmmarsphotos = marsapi.retrofitservice.getPhotos()
            marsadpater.listmmarsphotos=listmmarsphotos
           // imageview.load(listmmarsphotos.get(0).imgsrc )
            marsadpater.notifyDataSetChanged()
            Log.i("MainActivity",listmmarsphotos.size.toString())
            Log.i("MainActivity-url",listmmarsphotos.get(1).imgsrc)

        }
    }

    fun getjson(view: View){
        getmarsphotos()
    }
}