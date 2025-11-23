package com.app.examapp.ui.product.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.examapp.data.remote.dto.ProductDto
import com.app.examapp.data.repository.ProductRepositoryImpl
import kotlinx.coroutines.launch

data class ProductListUiState(
    val cargando: Boolean = false,
    val listProduct: List<ProductDto> = emptyList(),
    val error: String = ""
)


class ProductViewModel(
    private val repository: ProductRepositoryImpl = ProductRepositoryImpl()
) : ViewModel() {

    var uistate by mutableStateOf(ProductListUiState(true))

    init {
        getDataService()
    }

    private fun getDataService() {
        viewModelScope.launch {
            uistate = uistate.copy(cargando = true, error = "")

            try {
                val products = repository.getProducts()

                uistate = uistate.copy(cargando = false, listProduct = products.data, error = "")
            } catch (ex: Exception) {
                uistate =
                    uistate.copy(cargando = false, error = ex.message.toString())
            }

        }
    }

}

