package com.example.recreate

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recreate.kotlin.AppDatabase
import com.example.recreate.kotlin.Student
import com.example.recreate.kotlin.StudentAdapter
import com.example.recreate.kotlin.StudentRepository
import com.example.recreate.kotlin.StudentViewModel
import com.example.recreate.kotlin.StudentViewModelFactory

class MainActivity : AppCompatActivity() {


    private lateinit var studentViewModel: StudentViewModel
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var gradeEditText: EditText
    private lateinit var insertButton: Button
    private lateinit var updateButton: Button
    private lateinit var deleteButton: Button
    private lateinit var searchButton: Button
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val studentDao = AppDatabase.getDatabase(applicationContext).studentDao()
        val repository = StudentRepository(studentDao)
        studentViewModel = ViewModelProvider(this, StudentViewModelFactory(repository)).get(StudentViewModel::class.java)

        nameEditText = findViewById(R.id.nameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        gradeEditText = findViewById(R.id.gradeEditText)
        insertButton = findViewById(R.id.insertButton)
        updateButton = findViewById(R.id.updateButton)
        deleteButton = findViewById(R.id.deleteButton)
        searchButton = findViewById(R.id.searchButton)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        insertButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString().toIntOrNull()
            val grade = gradeEditText.text.toString()
            if (name.isNotEmpty() && age != null && grade.isNotEmpty()) {
                val student = Student(name = name, age = age, grade = grade)
                studentViewModel.insert(student)
                loadAllStudents()
            }
        }

        updateButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString().toIntOrNull()
            val grade = gradeEditText.text.toString()
            val id = recyclerView.tag as? Int
            if (name.isNotEmpty() && age != null && grade.isNotEmpty() && id != null) {
                val student = Student(id = id, name = name, age = age, grade = grade)
                studentViewModel.update(student)
                loadAllStudents()
            }
        }

        deleteButton.setOnClickListener {
            val id = recyclerView.tag as? Int
            if (id != null) {
                studentViewModel.getStudentById(id) { student ->
                    student?.let {
                        studentViewModel.delete(it)
                        loadAllStudents()
                    }
                }
            }
        }

        searchButton.setOnClickListener {
            val name = nameEditText.text.toString()
            if (name.isNotEmpty()) {
                studentViewModel.searchStudentByName(name) { students ->
                    recyclerView.adapter = StudentAdapter(students)
                }
            }
        }

        loadAllStudents()
    }

    private fun loadAllStudents() {
        studentViewModel.getAllStudents { students ->
            recyclerView.adapter = StudentAdapter(students)
        }
    }
}