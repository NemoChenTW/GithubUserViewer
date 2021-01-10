package com.nemo.githubuserviewer.model

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.nemo.githubuserviewer.githubapi.GithubService
import com.nemo.githubuserviewer.model.database.UserDao
import com.nemo.githubuserviewer.model.database.entity.User

@OptIn(ExperimentalPagingApi::class)
class GithubUserRemoteMediator(
    private val githubService: GithubService,
    private val userDao: UserDao
) : RemoteMediator<Int, User>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, User>
    ): MediatorResult {

        try {
            val pageKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                        ?: return MediatorResult.Success(endOfPaginationReached = true)
                    lastItem.id
                }
            }

            val page = pageKey ?: 0
            val listedUserList =
                githubService.listUsers(since = page, perPage = state.config.pageSize)
            val endOfPaginationReached = listedUserList.isEmpty()
            if (!endOfPaginationReached) {
                userDao.insert(listedUserList)
            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (ex: Exception) {
            return MediatorResult.Error(ex)
        }
    }
}