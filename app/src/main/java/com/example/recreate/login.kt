package com.example.recreate

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        fun prin(){
        val message = intent.getStringExtra("mm")
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
        return message}
        prin()
    }
}