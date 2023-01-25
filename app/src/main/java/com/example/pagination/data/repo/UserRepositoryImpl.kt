package com.example.pagination.data.repo

import com.example.pagination.data.network.UsersApi
import com.example.pagination.data.network.UsersResponse

class UserRepositoryImpl(
    private val api:UsersApi
) :UserRepository{
    override suspend fun getUsers(page: Int, limit: Int): UsersResponse {
        return api.getUsers(page,limit)
    }
}