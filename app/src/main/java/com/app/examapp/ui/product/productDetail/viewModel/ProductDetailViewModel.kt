package com.app.examapp.ui.product.productDetail.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.examapp.data.remote.dto.ProductDto
import com.app.examapp.data.repository.ProductDetailRepositoryImpl
import kotlinx.coroutines.launch

data class ProductDetailUiState(
    val cargando: Boolean = false,
    val product: ProductDto? = null,
    val error: String = ""
)

class ProductDetailViewModel(
    private val repository: ProductDetailRepositoryImpl = ProductDetailRepositoryImpl()
) : ViewModel(){

    var uistate by mutableStateOf(ProductDetailUiState(true))

//    init {
//        getDataService()
//    }

    public fun getDataService(id: Int) {
        viewModelScope.launch {
            uistate = uistate.copy(cargando = true, error = "")

            try {
                val product = repository.getProductDetail(id)

                uistate = uistate.copy(cargando = false, product = product, error = "")
            } catch (ex: Exception) {
                uistate =
                    uistate.copy(cargando = false, error = ex.message.toString())
            }

        }
    }
}