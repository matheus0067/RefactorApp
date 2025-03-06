package com.matheus.picpay.data.mock

import com.matheus.picpay.domain.model.User

object MockUsers {
    fun getMockUsers(): List<User> = listOf(
        User(
            id = 1,
            name = "Eduardo Santos",
            username = "@eduardo.santos",
            img = "https://example.com/avatar1.jpg"
        ),
        User(
            id = 2,
            name = "Maria Silva",
            username = "@maria.silva",
            img = "https://example.com/avatar2.jpg"
        )
    )
}