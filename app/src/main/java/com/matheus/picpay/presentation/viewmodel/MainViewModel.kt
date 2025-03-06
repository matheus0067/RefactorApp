package com.matheus.picpay.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.picpay.domain.model.User
import com.matheus.picpay.domain.repository.UserRepository
import com.matheus.picpay.presentation.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository // Deve ser uma interface/abstração
) : ViewModel() {

    private val _users = MutableStateFlow<UiState<List<User>>>(UiState.Loading)
    val users: StateFlow<UiState<List<User>>> = _users.asStateFlow()

    fun loadUsers() {
        viewModelScope.launch {
            _users.value = UiState.Loading

            try {
                val users = userRepository.getUsers()
                _users.value = UiState.Success(users) // Usando o estado Success
            } catch (e: Exception) {
                _users.value = UiState.Error(e.message ?: "Erro desconhecido")
            }
        }
    }
}