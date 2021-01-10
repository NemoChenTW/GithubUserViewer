package com.nemo.githubuserviewer.ui.main.viewmodel

import androidx.lifecycle.*
import androidx.paging.PagedList
import androidx.paging.cachedIn
import com.nemo.githubuserviewer.model.UserRepository
import com.nemo.githubuserviewer.model.data.DetailedUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val usersList = userRepository.fetchUserList().cachedIn(viewModelScope).asLiveData()
    val detailedUser = MutableLiveData<DetailedUser?>()

    fun userDetail(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            detailedUser.postValue(userRepository.getUser(userName))
        }
    }
}
