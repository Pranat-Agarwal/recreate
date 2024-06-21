package com.example.recreate

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    fun show(view : View)
    {
        var et:EditText= findViewById(R.id.editTextText)
        var ch=et.text.toString()
        var st:TextView=findViewById(R.id.textView)
        st.setText(ch)
    }
}