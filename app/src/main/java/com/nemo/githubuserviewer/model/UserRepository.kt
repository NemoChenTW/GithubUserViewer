package com.nemo.githubuserviewer.model

import androidx.paging.PagingData
import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.model.data.ListedUser
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun fetchUserList(): Flow<PagingData<ListedUser>>
    suspend fun getUser(userName: String): DetailedUser?
    suspend fun getBiFollowing(userName: String): List<ListedUser>

    fun favoriteUser(id: Int, isFavorite: Boolean)

}
