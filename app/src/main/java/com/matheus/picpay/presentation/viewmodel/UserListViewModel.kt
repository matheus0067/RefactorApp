package com.matheus.picpay.presentation.viewmodel

import androidx.recyclerview.widget.RecyclerView
import com.matheus.picpay.R
import com.matheus.picpay.data.mock.MockUsers
import com.matheus.picpay.domain.model.User
import com.matheus.picpay.presentation.ui.UiState

class UserListViewModel(
    private val binding: ListItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.user = user
        binding.executePendingBindings()

        // Carregamento de imagem com Coil (opcional)
        binding.picture.load(user.img) {
            crossfade(true)
            placeholder(R.drawable.placeholder)
        }
    }
    fun loadUsers() {
        viewModelScope.launch {
            // Substituir por chamada real quando API estiver online
            _usersState.value = UiState.Success(MockUsers.getMockUsers())
        }
    }
}