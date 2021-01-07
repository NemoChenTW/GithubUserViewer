package com.nemo.githubuserviewer.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.nemo.githubuserviewer.model.UserRepository
import com.nemo.githubuserviewer.model.datasource.ListedUserDataSourceFactory
import javax.inject.Inject

class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val listedUserDataSourceFactory = ListedUserDataSourceFactory(viewModelScope, userRepository)
    val usersList = LivePagedListBuilder(listedUserDataSourceFactory, pagedListConfig()).build()

    private fun pagedListConfig() = PagedList.Config.Builder()
            .setPageSize(10)
            .setInitialLoadSizeHint(10)
            .setPrefetchDistance(5)
            .setEnablePlaceholders(false)
            .build()
}
