package com.example.pagination.ux

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pagination.data.UsersDataSource
import com.example.pagination.data.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
):ViewModel() {
    val usersPager = Pager(
        PagingConfig(pageSize = 10)
    ) {
        UsersDataSource(userRepository)
    }.flow.cachedIn(viewModelScope)
}