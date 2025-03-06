package com.matheus.picpay.data.remote

import com.matheus.picpay.domain.model.User
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val picPayService: PicPayService
) {
    suspend fun getUsers() : List<User> {
        return picPayService.getUsers()
    }
}