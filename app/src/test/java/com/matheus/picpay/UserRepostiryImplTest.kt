package com.matheus.picpay

import com.matheus.picpay.data.local.entity.UserEntity
import com.matheus.picpay.presentation.ui.UiState
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.io.IOException

class UserRepositoryImplTest {

    @Test
    fun `getUsers should return cached data on network error`() = runTest {
        // Configurar mocks
        coEvery { remoteDataSource.getUsers() } throws IOException()
        coEvery { localDataSource.getUsers() } returns listOf(UserEntity(...))

        // Executar e validar
        repository.getUsers().collect { state ->
            assertTrue(state is UiState.Success)
        }
    }
}