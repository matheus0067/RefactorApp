package com.matheus.picpay.data.remote

import com.matheus.picpay.data.local.UserDao
import com.matheus.picpay.domain.model.User
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val userDao: UserDao
) {
    suspend fun getUsers(): List<Unit> {
        return userDao.getUsers().map { it.toDomain() }
    }

    suspend fun saveUsers(users: List<User>) {
        userDao.insertUsers(users.map { it.toEntity() })
    }
}
