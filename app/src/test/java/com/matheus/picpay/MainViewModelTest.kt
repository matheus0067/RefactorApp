package com.matheus.picpay

import com.matheus.picpay.domain.repository.UserRepository
import com.matheus.picpay.presentation.ui.UiState
import com.matheus.picpay.presentation.viewmodel.MainViewModel
import com.matheus.picpay.domain.model.User
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.whenever
import javax.inject.Inject

@HiltAndroidTest
class MainViewModelTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var userRepository: UserRepository

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        hiltRule.inject()
        viewModel = MainViewModel(userRepository)
    }

    @Test
    fun `loadUsers should emit Success state`() = runTest {
        // Mockar resposta do repositório
        val mockUsers = listOf(User(...))
        whenever(userRepository.getUsers()).thenReturn(mockUsers)

        viewModel.loadUsers()

        val state = viewModel.users.value
        assertTrue(state is UiState.Success<*>)
        assertEquals(mockUsers, (state as UiState.Success<*>).data)
    }
}