package com.example.recreate

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recreate.network.marsapi
import com.example.recreate.network.marsphoto
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var marsrecyclerview:RecyclerView
    lateinit var marsadpater:adpater
    lateinit var photos:List<marsphoto>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        marsrecyclerview=findViewById(R.id.recyclerview)
        marsrecyclerview.layoutManager=LinearLayoutManager(this)
        photos=ArrayList()
        marsadpater=adpater(photos)
        marsrecyclerview.adapter=marsadpater
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
            marsadpater.notifyDataSetChanged()
            Log.i("MainActivity",listmmarsphotos.size.toString())
            Log.i("MainActivity-url",listmmarsphotos.get(1).imgsrc)

        }
    }

    fun getjson(view: View){
        getmarsphotos()
    }
}