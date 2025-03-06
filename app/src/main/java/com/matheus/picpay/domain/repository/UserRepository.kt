package com.matheus.picpay.domain.repository

import com.matheus.picpay.domain.model.User
import com.matheus.picpay.presentation.ui.UiState
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUsers(): Flow<UiState<List<User>>>
}