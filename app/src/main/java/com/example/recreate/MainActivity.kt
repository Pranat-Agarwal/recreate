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
import com.example.recreate.kotlin.mainviewmodalclass
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    lateinit var dao:itemdao
    lateinit var viewmodal : mainviewmodalclass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

            binding=ActivityMainBinding.inflate(layoutInflater)
            var view=binding.root
            setContentView(view)
            var database=database.getdatabase(this)
            dao=database.itemdao()
        viewmodal = ViewModelProvider(this)[mainviewmodalclass::class.java]

        binding.textView.setText(""+viewmodal.count)
            binding.button.setOnClickListener{
                insertdatadb()
            }

        binding.buttonfind.setOnClickListener{
            finditemid(21)
        }

        binding.button2.setOnClickListener{
            viewmodal.increamentcount()
            binding.textView.setText(viewmodal.count)
        }
    }

    private fun finditemid(id : Int){
        GlobalScope.launch {
            var item = dao.getItem(id).first()
            binding.textView.setText(item.itemname)
        }
    }


            private fun insertdatadb(){
                GlobalScope.launch {

                    var item=item(21,"fruits",11.11,11)
                    dao.insert(item)
                }
            }

        }