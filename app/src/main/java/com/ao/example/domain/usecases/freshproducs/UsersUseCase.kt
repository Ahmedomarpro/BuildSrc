package com.ao.example.domain.usecases.freshproducs

import com.ao.example.presentation.utils.Resource
import kotlinx.coroutines.flow.Flow


interface UsersUseCase {

    fun getUser(userId: Int): Flow<Resource<*>>
    fun getUserAlbums(userId: Int): Flow<Resource<*>>
    fun getAlbumPhotos(albumId: Int): Flow<Resource<*>>

}