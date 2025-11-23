package com.app.examapp.data.remote

import com.app.examapp.data.remote.dto.ProdsDto
import com.app.examapp.data.remote.dto.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): ProdsDto

    @GET("products/{id}")
    suspend fun getProductDetail(@Path("id") id: Int): ProductDto
}