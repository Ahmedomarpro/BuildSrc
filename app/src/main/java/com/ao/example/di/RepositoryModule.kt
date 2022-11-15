package com.ao.example.di


import com.ao.example.data.repo.UsersRepoImpl
import com.ao.example.domain.repo.UsersRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun getUsersRepo(repo: UsersRepoImpl): UsersRepo


}