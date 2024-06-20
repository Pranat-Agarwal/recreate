package com.example.recreate

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.collections.EmptyIterator.next

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var name:String="pranat"
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            next()
    }
        private fun next() {
            val editText = findViewById<EditText>(R.id.editTextText)
            val message = editText.text.toString()
            val intent: Intent = Intent(this, login::class.java).also {
                it.putExtra("mm", message)
                startActivity(it)
            }
}