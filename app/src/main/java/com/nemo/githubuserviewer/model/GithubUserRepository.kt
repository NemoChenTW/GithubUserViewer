package com.nemo.githubuserviewer.model

import android.util.Log
import com.nemo.githubuserviewer.githubapi.GithubService
import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.model.data.ListedUser
import javax.inject.Inject

class GithubUserRepository @Inject constructor(private val githubService: GithubService) :
    UserRepository {
    override suspend fun listUsers(since: Int, userPerPage: Int): List<ListedUser> {
        return try {
            val response = githubService.listUsers(since = since, perPage = userPerPage)
            if (response.isSuccessful) {
                response.body()!!
            } else {
                Log.w(TAG, "${response.code()}: ${response.message()}")
                emptyList()
            }
        } catch (ex: Exception) {
            Log.w(TAG, ex.message.orEmpty())
            emptyList()
        }
    }

    override suspend fun getUser(userName: String): DetailedUser? {
        return try {
            val response = githubService.getUser(userName = userName)
            if (response.isSuccessful) {
                response.body()!!
            } else {
                Log.w(TAG, "${response.code()}: ${response.message()}")
                null
            }
        } catch (ex: Exception) {
            Log.w(TAG, ex.message.orEmpty())
            null
        }
    }

    companion object {
        const val TAG = "GithubUserRepository"
    }
}
