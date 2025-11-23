package com.app.examapp.domain.repository

import com.app.examapp.data.model.Cart
import com.app.examapp.data.model.Category

interface CartRepository {

    suspend fun getCarts(): List<Cart>

    suspend fun add(
       cart: Cart
    )

    suspend fun removeById(id: Long)
}