package com.example.recreate

import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
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
            var jasonString = MarsApi.retrofitService.getPhotos()
            Log.i("MainActivity",jasonString)
        }
    }

    fun getjson(view: View){
        getmarsphotos()
    }
}