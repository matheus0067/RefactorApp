package com.matheus.picpay.presentation.ui.common

import androidx.recyclerview.widget.DiffUtil
import com.matheus.picpay.domain.model.User

class UserDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id // Comparação por ID
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem // Usa equals() da data class
    }
}