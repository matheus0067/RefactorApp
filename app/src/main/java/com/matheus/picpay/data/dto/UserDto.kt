package com.matheus.picpay.data.dto

import com.google.gson.annotations.SerializedName
import com.matheus.picpay.domain.model.User

data class UserDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("img") val img: String
) {
    fun toDomain() = User(id, name, username, img)
}