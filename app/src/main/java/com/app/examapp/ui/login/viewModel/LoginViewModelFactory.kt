package com.app.examapp.ui.login.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.examapp.data.local.AppDatabase
import com.app.examapp.data.repository.UserRepositoryImpl

class LoginViewModelFactory (private val application: Application) :
    ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>):T{
        val db= AppDatabase.getInstance(application)
        val repo= UserRepositoryImpl(db.login())
        return LoginViewModel(repo) as T
    }
}