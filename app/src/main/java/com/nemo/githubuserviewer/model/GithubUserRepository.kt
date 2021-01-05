package com.nemo.githubuserviewer.model

import com.nemo.githubuserviewer.githubapi.GithubService
import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.model.data.ListedUser
import javax.inject.Inject

class GithubUserRepository @Inject constructor(private val githubService: GithubService) :
    UserRepository {
    override suspend fun listUsers(): List<ListedUser> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(userName: String): DetailedUser {
        TODO("Not yet implemented")
    }
}
