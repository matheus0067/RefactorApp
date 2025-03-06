package com.matheus.picpay.data.remote

import com.matheus.picpay.domain.model.User
import retrofit2.http.GET


interface PicPayService {

    @GET("users")
    fun getUsers(): List<User>
}