package com.nemo.githubuserviewer.model.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nemo.githubuserviewer.model.UserRepository
import com.nemo.githubuserviewer.model.data.ListedUser
import kotlinx.coroutines.CoroutineScope

class ListedUserDataSourceFactory(
        private val coroutineScope: CoroutineScope,
        private val userRepository: UserRepository
) : DataSource.Factory<Int, ListedUser>() {

    private val listedUserDataSource = MutableLiveData<ListedUserDataSource>()

    override fun create(): DataSource<Int, ListedUser> {
        val source = ListedUserDataSource(coroutineScope, userRepository)
        listedUserDataSource.postValue(source)
        return source
    }
}
