package com.app.examapp.ui.home.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.examapp.data.model.Category
import com.app.examapp.domain.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryVewModel(
    private val repository: CategoryRepository
) : ViewModel() {

    var categoryList by mutableStateOf<List<Category>>(emptyList())
        private set

    init {
        registerData()
    }

    private fun registerData() {
        viewModelScope.launch {
            val categories = repository.getCategories()

            if (categories.isEmpty()) {
                repository.addCategory(
                    "Ropa de vestir",
                    "https://images.pexels.com/photos/1043474/pexels-photo-1043474.jpeg",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Donec sollicitudin, ligula et venenatis convallis, justo arcu pharetra lorem, quis placerat orci lorem vel ligula."
                )
                repository.addCategory(
                    "Busos",
                    "https://images.pexels.com/photos/6311314/pexels-photo-6311314.jpeg",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Donec sollicitudin, ligula et venenatis convallis, justo arcu pharetra lorem, quis placerat orci lorem vel ligula."
                )
                repository.addCategory(
                    "Jeans",
                    "https://images.pexels.com/photos/1485031/pexels-photo-1485031.jpeg",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Donec sollicitudin, ligula et venenatis convallis, justo arcu pharetra lorem, quis placerat orci lorem vel ligula."
                )
                repository.addCategory(
                    "Jacket",
                    "https://images.pexels.com/photos/983497/pexels-photo-983497.jpeg",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Donec sollicitudin, ligula et venenatis convallis, justo arcu pharetra lorem, quis placerat orci lorem vel ligula.  "
                )
            }

            load()
        }
    }

    fun load() {
        viewModelScope.launch {
            categoryList = repository.getCategories()
        }
    }

}