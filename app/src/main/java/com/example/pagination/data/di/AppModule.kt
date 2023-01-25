package com.example.pagination.data.di

import com.example.pagination.data.network.UsersApi
import com.example.pagination.data.repo.UserRepository
import com.example.pagination.data.repo.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideUsrApi():UsersApi =UsersApi()

    @Provides
    fun provideUserRepo(api:UsersApi):UserRepository=UserRepositoryImpl(api)
}