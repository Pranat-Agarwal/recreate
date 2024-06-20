package com.example.cargo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var tag="main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.i(tag,"create")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(tag,"start")
    }

    override fun onStop() {
        super.onStop()
        Log.e(tag,"stop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"destroy")
    }

    override fun onPause() {
        super.onPause()
        Log.w(tag,"pause")
    }

    fun myclick (view: View){
        var h =Intent(this, homeactivity::class.java)
        h.putExtra("nkey","value")
        startActivity(h)
    }


    fun inf(){
        var un = EditText(this)
        un.setHint("enter")
        var p = EditText(this)
        p.setHint("enter")
        var b =Button(this)
        b.setText("log")

    }
}