package com.nemo.githubuserviewer.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nemo.githubuserviewer.model.data.DetailedUser

class DetailedUserViewModelFactory(private val detailedUser: DetailedUser) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailedUserViewModel::class.java)) {
            return DetailedUserViewModel(detailedUser) as T
        }
        throw IllegalStateException("Unknown ViewModel class")
    }
}
