package com.app.examapp.ui.product.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.examapp.data.repository.ProductRepositoryImpl
import com.app.examapp.domain.repository.ProductRepository

class ProductViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repo = ProductRepositoryImpl()
        return ProductViewModel(repo) as T
    }
}