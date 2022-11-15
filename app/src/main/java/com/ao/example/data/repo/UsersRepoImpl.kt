package com.ao.example.data.repo

import com.ao.example.data.api.model.AlbumPhotoResponse
import com.ao.example.data.api.model.AlbumResponse
import com.ao.example.data.api.model.UserResponse
import com.ao.example.data.api.retrofit.WebService
import com.ao.example.data.repo.base.BaseRepo
import com.ao.example.domain.repo.UsersRepo
import com.ao.example.data.mapper.UserMapper
import com.ao.example.presentation.utils.Resource
import com.ao.example.presentation.utils.Status
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepoImpl @Inject constructor(
    private val webService: WebService,
    private val userMapper: UserMapper
) : BaseRepo(),
    UsersRepo {

    override fun getUser(userId: Int) = loadFromApi {
        (webService::getUser)(userId)
    }.map {
        if (it.status.get() == Status.SUCCESS) {
            Resource.success(userMapper.mapUserToViewState(it.data as UserResponse))
        } else it
    }


    override fun getUserAlbums(userId: Int) = loadFromApi {
        (webService::getUserAlbums)(userId)
    }.map {
        if (it.status.get() == Status.SUCCESS) {
            Resource.success(userMapper.mapAlbumToViewState(it.data as List<AlbumResponse>))
        } else it
    }

    override fun getAlbumPhotos(albumId: Int) = loadFromApi {
        (webService::getAlbumPhotos)(albumId)
    }.map {
        if (it.status.get() == Status.SUCCESS) {
            Resource.success(userMapper.mapAlbumPhotosToViewState(it.data as List<AlbumPhotoResponse>))
        } else it
    }

}