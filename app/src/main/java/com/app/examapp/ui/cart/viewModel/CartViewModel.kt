package com.app.examapp.ui.cart.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.examapp.data.model.Cart
import com.app.examapp.domain.repository.CartRepository
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: CartRepository
) : ViewModel() {

    var cartList by mutableStateOf<List<Cart>>(emptyList())
        private set

    fun load() {
        viewModelScope.launch {
            cartList = repository.getCarts()
        }
    }

    fun addToCart(cart: Cart){
        viewModelScope.launch{
            repository.add(cart)
            load()
        }
    }
    fun removeById(id : Long){
        viewModelScope.launch {
            repository.removeById(id)
            load()
        }
    }

}