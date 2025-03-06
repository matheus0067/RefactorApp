package com.matheus.picpay.data.repository

import com.matheus.picpay.data.remote.UserLocalDataSource
import com.matheus.picpay.data.remote.UserRemoteDataSource
import com.matheus.picpay.domain.repository.UserRepository
import com.matheus.picpay.presentation.ui.UiState
import com.matheus.picpay.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
    private val localDataSource: UserLocalDataSource
) : UserRepository {

    override suspend fun getUsers(): Flow<UiState<List<User>>> = flow {
        emit(UiState.Loading)
        try {
            val remoteUsers = remoteDataSource.getUsers()
            localDataSource.saveUsers(remoteUsers)
            emit(UiState.Success(remoteUsers))
        } catch (e: IOException) {
            val cachedUsers = localDataSource.getUsers()
            if (cachedUsers.isNotEmpty()) {
                emit(UiState.Success(cachedUsers))
            } else {
                emit(UiState.Error("Sem conexão e sem dados locais"))
            }
        }
    }
}
