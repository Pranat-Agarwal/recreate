package com.example.recreate.kotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StudentViewModel(private val repository: StudentRepository) : ViewModel() {

    fun insert(student: Student) = viewModelScope.launch {
        repository.insert(student)
    }

    fun update(student: Student) = viewModelScope.launch {
        repository.update(student)
    }

    fun delete(student: Student) = viewModelScope.launch {
        repository.delete(student)
    }

    fun getStudentById(id: Int, callback: (Student?) -> Unit) = viewModelScope.launch {
        callback(repository.getStudentById(id))
    }

    fun searchStudentByName(name: String, callback: (List<Student>) -> Unit) = viewModelScope.launch {
        callback(repository.searchStudentByName(name))
    }

    fun getAllStudents(callback: (List<Student>) -> Unit) = viewModelScope.launch {
        callback(repository.getAllStudents())
    }
}

class StudentViewModelFactory(private val repository: StudentRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
