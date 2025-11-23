package com.app.examapp.domain.repository

import com.app.examapp.data.remote.dto.ProdsDto
import com.app.examapp.data.remote.dto.ProductDto

interface ProductDetailRepository {

    suspend fun getProductDetail(id: Int): ProductDto
}