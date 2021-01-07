package com.nemo.githubuserviewer.model.datasource

import androidx.paging.ItemKeyedDataSource
import androidx.paging.PageKeyedDataSource
import com.nemo.githubuserviewer.model.UserRepository
import com.nemo.githubuserviewer.model.data.ListedUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListedUserDataSource(
        private val coroutineScope: CoroutineScope,
        private val userRepository: UserRepository
) : ItemKeyedDataSource<Int, ListedUser>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<ListedUser>) {
        executeQuery(INITIAL_USER_ID, params.requestedLoadSize) {
            callback.onResult(it)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<ListedUser>) {
        executeQuery(params.key, params.requestedLoadSize) {
            callback.onResult(it)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<ListedUser>) {
        // Do nothing
    }

    override fun getKey(item: ListedUser): Int {
        return item.id
    }

    private fun executeQuery(since: Int, perPage: Int, callBack: (List<ListedUser>) -> Unit) {
        coroutineScope.launch(Dispatchers.IO) {
            callBack(userRepository.listUsers(since, perPage))
        }
    }

    companion object {
        const val INITIAL_USER_ID = 0
    }
}
