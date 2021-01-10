package com.nemo.githubuserviewer.model

import android.util.Log
import androidx.paging.*
import com.nemo.githubuserviewer.githubapi.GithubService
import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.model.data.ListedUser
import com.nemo.githubuserviewer.model.data.mapper.UserToDetailedUserMapper
import com.nemo.githubuserviewer.model.data.mapper.UserToListedUserMapper
import com.nemo.githubuserviewer.model.database.UserDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GithubUserRepository @Inject constructor(
    private val githubService: GithubService,
    private val userDao: UserDao
) :
    UserRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun fetchUserList(): Flow<PagingData<ListedUser>> {
        return Pager(
            config = pagingConfig,
            remoteMediator = GithubUserRemoteMediator(githubService, userDao)
        ) {
            userDao.queryAllData()
        }.flow.map { pagingData ->
            pagingData.map {
                UserToListedUserMapper().map(it)
            }
        }
    }

    override suspend fun getUser(userName: String): DetailedUser? {
        val user = userDao.findUserByName(userName)
        return try {
            if (user.hasDetailed == true) {
                UserToDetailedUserMapper().map(user)
            } else {
                val response = githubService.getUser(userName = userName)
                if (response.isSuccessful) {
                    val detailedUser = response.body()!!.apply {
                        this.hasDetailed = true
                    }
                    userDao.update(detailedUser)
                    detailedUser
                } else {
                    Log.w(TAG, "${response.code()}: ${response.message()}")
                    null
                }
            }
        } catch (ex: Exception) {
            Log.w(TAG, ex.message.orEmpty())
            null
        }
    }

    companion object {
        const val TAG = "GithubUserRepository"

        val pagingConfig = PagingConfig(
            pageSize = 15,
            prefetchDistance = 5,
            enablePlaceholders = false
        )
    }
}
