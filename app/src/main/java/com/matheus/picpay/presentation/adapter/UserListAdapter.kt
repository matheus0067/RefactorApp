package com.matheus.picpay.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.matheus.picpay.domain.model.User
import com.matheus.picpay.presentation.ui.common.UserDiffCallback
import com.matheus.picpay.presentation.viewmodel.UserListViewModel


class UserListAdapter : ListAdapter<User, UserListViewModel>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewModel {
        val binding = ListItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false

        )
        return UserListViewModel(binding)
    }

    override fun onBindViewHolder(holder: UserListViewModel, position: Int) {
        holder.bind(getItem(position))
    }
}