package com.example.recreate.kotlin

import androidx.room.*

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

    @Update
    suspend fun update(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("SELECT * FROM student_table WHERE id = :id")
    suspend fun getStudentById(id: Int): Student?

    @Query("SELECT * FROM student_table WHERE name LIKE :name")
    suspend fun searchStudentByName(name: String): List<Student>

    @Query("SELECT * FROM student_table")
    suspend fun getAllStudents(): List<Student>
}
