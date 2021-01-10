package com.nemo.githubuserviewer.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nemo.githubuserviewer.model.UserRepository
import com.nemo.githubuserviewer.model.data.DetailedUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailedUserViewModel(val detailedUser: DetailedUser, private val userRepository: UserRepository) : ViewModel() {

    val isFavorite = MutableLiveData(detailedUser.isFavorite ?: false)

    fun favoriteUser() {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.favoriteUser(detailedUser.id, isFavorite.value!!)
        }
    }
}
