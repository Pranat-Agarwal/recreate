package com.example.recreate

import android.os.Bundle
import android.provider.Settings.Global
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recreate.databinding.ActivityMainBinding
import com.example.recreate.kotlin.database
import com.example.recreate.kotlin.itemdao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var dao:itemdao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)
        var database=database.getdatabase(this)
        dao=database.itemdao()

        binding.button.setOnClickListener{
            insertdatadb()
        }
    }

    private fun insertdatadb(){
        GlobalScope.launch {
            var item=item(21,"fruits",11.11,11)
            dao.insert(item)
        }
    }
}