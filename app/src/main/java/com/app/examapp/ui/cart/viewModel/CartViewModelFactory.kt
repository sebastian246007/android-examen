package com.app.examapp.ui.cart.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.examapp.data.local.AppDatabase
import com.app.examapp.data.repository.CartRepositoryImpl

class CartViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val db = AppDatabase.getInstance(application)
        val repo = CartRepositoryImpl (db.carts())
        return CartViewModel(repo) as T
    }
}