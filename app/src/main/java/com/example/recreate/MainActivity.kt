package com.example.recreate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            next()
        }
    }

    private fun next() {
        val editText = findViewById<EditText>(R.id.editTextText)
        val message = editText.text.toString()
        val intent: Intent = Intent(this, loginpage::class.java).also {
            it.putExtra("mm", message)
            startActivity(it)
        }
    }
}