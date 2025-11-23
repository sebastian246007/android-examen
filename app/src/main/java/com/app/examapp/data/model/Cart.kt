package com.app.examapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "carts")
data class Cart(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val productId: Int,
    val quantity: Int,
    val title: String,
    val isNew: Boolean,
    val oldPrice: String,
    val price: Double,
    val discountedPrice: Double,
    val description: String,
    val category: String,
    val type: String,
    val stock: Int,
    val brand: String,
    val image: String,
    val rating: Int
)


