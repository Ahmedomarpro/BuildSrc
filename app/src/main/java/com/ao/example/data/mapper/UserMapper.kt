package com.ao.example.data.mapper

import com.ao.example.data.api.model.AlbumResponse
import com.ao.example.data.api.model.AlbumPhotoResponse
import com.ao.example.data.api.model.UserResponse
import com.ao.example.domain.entity.Album
import com.ao.example.domain.entity.AlbumPhoto
import com.ao.example.domain.entity.User

interface UserMapper {

    fun mapUserToViewState(userResponse: UserResponse): User
    fun mapAlbumToViewState(albumsResponse: List<AlbumResponse>): List<Album>
    fun mapAlbumPhotosToViewState(albumPhotoResponse: List<AlbumPhotoResponse>): List<AlbumPhoto>

}