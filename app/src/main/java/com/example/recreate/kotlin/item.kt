package com.example.recreate.kotlin

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
@Entity
data class item (
    @PrimaryKey(autoGenerate=true)
    val id :Int=0,
    @ColumnInfo(name="name")
    val itemname:String,
    @ColumnInfo(name="price")
    val itemprice:Double,
    @ColumnInfo(name="quantity")
    val quantityinstock:Int

)