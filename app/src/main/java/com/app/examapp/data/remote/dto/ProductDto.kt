package com.app.examapp.data.remote.dto

data class ProductDto(
    val _id: Int,
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

