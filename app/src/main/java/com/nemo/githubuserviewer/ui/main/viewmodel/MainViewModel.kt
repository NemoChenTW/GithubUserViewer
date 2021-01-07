package com.nemo.githubuserviewer.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nemo.githubuserviewer.model.UserRepository
import com.nemo.githubuserviewer.model.data.ListedUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    var usersList = MutableLiveData<MutableList<ListedUser>>()

    fun listUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = userRepository.listUsers()
            if (result.isNotEmpty()) {
                usersList.postValue(result as MutableList<ListedUser>)
            }
        }
    }
}
