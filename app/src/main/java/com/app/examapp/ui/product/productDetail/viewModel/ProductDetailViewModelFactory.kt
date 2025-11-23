package com.app.examapp.ui.product.productDetail.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.examapp.data.repository.ProductDetailRepositoryImpl
import com.app.examapp.data.repository.ProductRepositoryImpl
import com.app.examapp.ui.product.viewModel.ProductViewModel

class ProductDetailViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repo = ProductDetailRepositoryImpl()
        return ProductDetailViewModel(repo) as T
    }
}