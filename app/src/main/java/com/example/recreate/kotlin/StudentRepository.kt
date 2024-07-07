package com.example.recreate.kotlin

class StudentRepository(private val studentDao: StudentDao) {

    suspend fun insert(student: Student) {
        studentDao.insert(student)
    }

    suspend fun update(student: Student) {
        studentDao.update(student)
    }

    suspend fun delete(student: Student) {
        studentDao.delete(student)
    }

    suspend fun getStudentById(id: Int): Student? {
        return studentDao.getStudentById(id)
    }

    suspend fun searchStudentByName(name: String): List<Student> {
        return studentDao.searchStudentByName(name)
    }

    suspend fun getAllStudents(): List<Student> {
        return studentDao.getAllStudents()
    }
}
