package com.app.examapp.data.repository

import com.app.examapp.data.remote.ApiClient
import com.app.examapp.data.remote.dto.ProdsDto
import com.app.examapp.domain.repository.ProductRepository

class ProductRepositoryImpl() : ProductRepository {

    private val api = ApiClient.api

    override suspend fun getProducts(): ProdsDto{
        return api.getProducts()
    }

    override suspend fun addProduct(
        title: String,
        image: String,
        desc: String,
        price: String,
        cantidad: String
    ) {
       // dao.addProduct(Product(title, image, desc, price, cantidad))
    }

}