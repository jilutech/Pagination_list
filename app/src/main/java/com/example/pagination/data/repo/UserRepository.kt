package com.example.pagination.data.repo

import com.example.pagination.data.network.UsersResponse

interface UserRepository {
    suspend fun getUsers(page:Int,limit:Int) :UsersResponse
}