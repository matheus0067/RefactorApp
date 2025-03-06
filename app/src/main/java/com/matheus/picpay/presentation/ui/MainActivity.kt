package com.matheus.picpay.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.matheus.picpay.R
import com.matheus.picpay.presentation.viewmodel.MainViewModel
import com.matheus.picpay.presentation.adapter.UserListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        observeViewModel()
        viewModel.loadUsers()
    }

    private fun setupRecyclerView() {
        adapter = UserListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.users.collect { state ->
                    when (state) {
                        is UiState.Loading -> showProgressBar()
                        is UiState.Success -> {
                            hideProgressBar()
                            adapter.submitList(state.data)
                        }
                        is UiState.Error -> {
                            showErrorSnackbar(state.message) {
                                viewModel.loadUsers() // Recarregar ao clicar
                            }
                        }
                    }
                }
            }
        }
    }
}