package com.app.examapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    val title: String,
    val image : String,
    val desc : String,
    val price: String,
    val cantidad: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0

)
