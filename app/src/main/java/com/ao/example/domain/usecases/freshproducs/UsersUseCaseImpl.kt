package com.ao.example.domain.usecases.freshproducs

import com.ao.example.domain.repo.UsersRepo
import com.ao.example.presentation.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class UsersUseCaseImpl @Inject constructor(
    private val repository: UsersRepo
) : UsersUseCase {

    override fun getUser(userId: Int): Flow<Resource<*>> {
        return repository.getUser(userId)
    }

    override fun getUserAlbums(userId: Int): Flow<Resource<*>> {
        return repository.getUserAlbums(userId)
    }

    override fun getAlbumPhotos(albumId: Int): Flow<Resource<*>> {
        return repository.getAlbumPhotos(albumId)
    }


}