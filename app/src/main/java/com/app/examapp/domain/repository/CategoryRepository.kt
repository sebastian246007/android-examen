package com.app.examapp.domain.repository

import com.app.examapp.data.local.CategoryDao
import com.app.examapp.data.model.Category
import com.app.examapp.data.model.User

interface CategoryRepository {

    suspend fun getCategories(): List<Category>

    suspend fun addCategory(
        title: String,
        image: String,
        desc: String
    )
}