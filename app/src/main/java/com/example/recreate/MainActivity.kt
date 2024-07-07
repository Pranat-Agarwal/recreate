package com.example.recreate

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.recreate.kotlin.AppDatabase
import com.example.recreate.kotlin.UserAdapter
import com.example.recreate.kotlin.UserDao

class MainActivity : AppCompatActivity() {

    fun add(a:Int,b:Int):Int{
        return a+b
    }

    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app_database").build()
        userDao = database.userDao()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecyxcleScope.launch {
            val users = userDao.getAllUsers()
            val adapter = UserAdapter(users)
            recyclerView.adapter = adapter
        }

    }
}