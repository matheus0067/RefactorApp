package com.matheus.picpay.domain.model

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val img: String
) {
    fun toEntity() {
        TODO("Not yet implemented")
    }

    fun toDomain() {
        TODO("Not yet implemented")
    }
}