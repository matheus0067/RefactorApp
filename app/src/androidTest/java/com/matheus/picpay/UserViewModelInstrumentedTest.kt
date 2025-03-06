package com.matheus.picpay

import com.matheus.picpay.domain.repository.UserRepository
import com.matheus.picpay.presentation.ui.UiState
import com.matheus.picpay.domain.model.User
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class UserViewModelInstrumentedTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var userRepository: UserRepository

    private lateinit var viewModel: UserViewModel

    @Before
    fun setup() {
        hiltRule.inject()
        viewModel = UserViewModel(GetUsersUseCase(userRepository))
    }

    @Test
    fun loadUsers_ShouldUpdateUIState() {
        // Simular resposta
        val testUsers = listOf(User(1, "Test", "@test", ""))

        runBlocking {
            // Executar
            viewModel.loadUsers()

            // Verificar estados
            val states = viewModel.usersState.toList()
            assertTrue(states[0] is UiState.Loading)
            assertTrue(states[1] is UiState.Success)
        }
    }
}