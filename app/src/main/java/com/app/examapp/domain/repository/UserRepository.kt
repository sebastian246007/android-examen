package com.app.examapp.domain.repository

import com.app.examapp.data.model.User

interface UserRepository {

     suspend fun login(email:String, pwd: String): User?

     suspend fun getUsers(): List<User>

     suspend fun addUsers(
          name: String,
          email: String,
          pwd: String
     )
}