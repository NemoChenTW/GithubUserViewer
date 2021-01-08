package com.nemo.githubuserviewer.model

import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.model.data.ListedUser

interface UserRepository {

    suspend fun listUsers(since: Int, userPerPage: Int): List<ListedUser>
    suspend fun getUser(userName: String): DetailedUser?
}