package com.app.examapp.domain.repository

import com.app.examapp.data.remote.dto.ProdsDto

interface ProductRepository {

    suspend fun getProducts(): ProdsDto

    suspend fun addProduct(
        title: String,
        image: String,
        desc: String,
        price: String,
        cantidad: String
    )
}