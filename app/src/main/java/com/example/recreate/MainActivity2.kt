package com.example.recreate

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity(), AdapterView.OnItemSelectedListener,
    AdapterView.OnItemClickListener {

    var tag = MainActivity2::class.java.simpleName
    lateinit var myspi : Spinner
    lateinit var myli: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        myspi = findViewById(R.id.spinner)
        myli =findViewById(R.id.listview)
        myli.isClickable=true
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myspi.onItemSelectedListener=this
        myli.setOnItemClickListener(this)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item:String= adpater?.getItemAtPosition(position.toString())
        Log.i(tag,item)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item:String= adapter?.getItemAtPosition(position.toString())
        Log.i(tag,item)
    }
}