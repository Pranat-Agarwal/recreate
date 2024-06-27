package com.example.recreate.kotlin

import androidx.room.Dao
import androidx.room.Insert
import kotlinx.coroutines.flow.Flow

@Dao
interface itemdao {

    @Insert (onconflict = OnConflictStrategy.REPLACE)
    suspend fun insert(groceryitem: item)

    @Update
    suspend fun update(item: item)

    @Delete
    suspend fun delete(item: item)

    @Quary("SELECT *from item WHERE id= :itemId")

    fun getItem(itemId : Int):Flow<Item>

    @Quary("SELECT *from item ORDER BY name ASC")

    fun getItems():Flow<List<Item>>
}