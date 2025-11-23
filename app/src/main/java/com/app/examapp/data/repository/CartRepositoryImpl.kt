package com.app.examapp.data.repository

import com.app.examapp.data.local.CartDao
import com.app.examapp.data.model.Cart
import com.app.examapp.domain.repository.CartRepository

class CartRepositoryImpl(private val dao: CartDao) : CartRepository{
    override suspend fun getCarts(): List<Cart> {
        return dao.getAll()
    }

    override suspend fun add(cart: Cart) {
        dao.add(cart)
    }

    override suspend fun removeById(id: Long) {
        dao.removeById(id)
    }
}