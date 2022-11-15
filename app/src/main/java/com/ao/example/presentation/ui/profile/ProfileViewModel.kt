package com.ao.example.presentation.ui.profile

import androidx.lifecycle.*
import com.ao.example.domain.entity.Album
import com.ao.example.domain.entity.User
import com.ao.example.domain.usecases.freshproducs.UsersUseCase
import com.ao.example.presentation.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val usersUseCase: UsersUseCase
) : ViewModel() {

    private val _users = MutableLiveData<Resource<User>>()
    val users = _users as LiveData<Resource<User>>

    private val _usersAlbums = MutableLiveData<Resource<List<Album>>>()
    val usersAlbums = _usersAlbums as LiveData<Resource<List<Album>>>

    private val _randomUser = (1..10).random()


    fun getUserDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            _users.postValue(Resource.loading())
            val userInfoAsync = async { usersUseCase.getUser(_randomUser).first() }
          //  val userAlbumsAsync = async { usersUseCase.getUserAlbums(_randomUser).first() }
            _users.postValue(userInfoAsync.await() as Resource<User>)
          //  _usersAlbums.postValue(userAlbumsAsync.await() as Resource<List<Album>>)
        }
    }
}