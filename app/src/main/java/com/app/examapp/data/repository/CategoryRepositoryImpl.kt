package com.app.examapp.data.repository

import com.app.examapp.data.local.CategoryDao
import com.app.examapp.data.local.UserDao
import com.app.examapp.data.model.Category
import com.app.examapp.domain.repository.CategoryRepository
import com.app.examapp.domain.repository.UserRepository

class CategoryRepositoryImpl(private val dao: CategoryDao) : CategoryRepository {
    override suspend fun getCategories(): List<Category> {
        return dao.getAll();
    }

    override suspend fun addCategory(
        title: String,
        image: String,
        desc: String
    ) {
        dao.addCategory(Category(title = title, image = image, desc = desc));
    }
}