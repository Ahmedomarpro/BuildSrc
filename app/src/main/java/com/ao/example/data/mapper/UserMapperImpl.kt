package com.ao.example.data.mapper

import com.ao.example.data.api.model.AlbumResponse
import com.ao.example.data.api.model.AlbumPhotoResponse
import com.ao.example.data.api.model.UserResponse
import com.ao.example.domain.entity.Album
import com.ao.example.domain.entity.AlbumPhoto
import com.ao.example.domain.entity.User
import javax.inject.Inject

class UserMapperImpl @Inject constructor() : UserMapper {

    override fun mapUserToViewState(userResponse: UserResponse): User {

        return User(
            userResponse.id,userResponse.name,userResponse.phone
         )
    }

    override fun mapAlbumToViewState(albumsResponse: List<AlbumResponse>): List<Album> {
        return albumsResponse.map {
            with(it) {
                Album(id, title)
            }
        }
    }

    override fun mapAlbumPhotosToViewState(albumPhotoResponse: List<AlbumPhotoResponse>): List<AlbumPhoto> {
        return albumPhotoResponse.map {
            with(it) {
                AlbumPhoto(id, url,title)
            }
        }
    }
}
