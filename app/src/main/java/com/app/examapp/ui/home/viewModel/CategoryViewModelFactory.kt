package com.app.examapp.ui.home.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.examapp.data.local.AppDatabase
import com.app.examapp.data.repository.CategoryRepositoryImpl
import com.app.examapp.data.repository.UserRepositoryImpl
import com.app.examapp.domain.repository.CategoryRepository
import com.app.examapp.ui.login.viewModel.LoginViewModel

class CategoryViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val db = AppDatabase.getInstance(application)
        val repo = CategoryRepositoryImpl (db.categories())
        return CategoryVewModel(repo) as T
    }

}