package com.app.examapp.data.repository

import com.app.examapp.data.local.UserDao
import com.app.examapp.data.model.User
import com.app.examapp.domain.repository.UserRepository

class UserRepositoryImpl(private val dao: UserDao): UserRepository {

    suspend override fun login(
        email: String,
        pwd: String
    ): User {
       return dao.login(email, pwd)
    }

    suspend override fun addUsers(
        name: String,
        email: String,
        pwd: String
    ) {
        dao.addUser(User(name = name, email = email, password = pwd))
    }
    suspend override fun getUsers(): List<User> = dao.getAll()
}