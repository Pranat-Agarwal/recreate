package com.example.recreate

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
    fun phone(view: View){
        var intent:Intent=Intent(Intent.ACTION_DIAL,Uri.parse("tel:7302708153"))
        startActivity(intent)
    }

    fun web(view: View){
        var intent:Intent=Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com"))
    }

    fun cal(view: View){
        var intent:Intent=Intent(Intent.ACTION_DATE_CHANGED)
    }

    fun alarm(view: View){
        var intent:Intent=Intent(Intent.ACTION_QUICK_CLOCK)
    }

}