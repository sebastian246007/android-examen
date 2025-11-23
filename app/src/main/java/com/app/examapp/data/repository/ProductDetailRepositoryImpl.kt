package com.app.examapp.data.repository

import com.app.examapp.data.remote.ApiClient
import com.app.examapp.data.remote.dto.ProductDto
import com.app.examapp.domain.repository.ProductDetailRepository

class ProductDetailRepositoryImpl : ProductDetailRepository {

    private val api = ApiClient.api

    override suspend fun getProductDetail(id :Int): ProductDto {
       return api.getProductDetail(id)
    }
}