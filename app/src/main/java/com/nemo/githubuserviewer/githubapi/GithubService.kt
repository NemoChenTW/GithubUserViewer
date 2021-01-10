package com.nemo.githubuserviewer.githubapi

import com.nemo.githubuserviewer.model.data.ListedUser
import com.nemo.githubuserviewer.model.data.DetailedUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    companion object {
        const val ACCEPT_HEADER = "application/vnd.github.v3+json"
    }

    @GET("/users")
    suspend fun listUsers(
        @Header("accept") accept: String = ACCEPT_HEADER,
        @Query("since") since: Int? = null,
        @Query("per_page") perPage: Int? = null
    ): List<ListedUser>

    @GET("/users/{username}")
    suspend fun getUser(
        @Header("accept") accept: String = ACCEPT_HEADER,
        @Path("username") userName: String
    ): Response<DetailedUser>


    @GET("/users/{username}/followers")
    suspend fun getUserFollowers(
        @Header("accept") accept: String = ACCEPT_HEADER,
        @Path("username") userName: String,
        @Query("per_page") perPage: Int? = null,
        @Query("page") page: Int? = null
    ): Response<List<ListedUser>>

    @GET("/users/{username}/following")
    suspend fun getUserFollowing(
        @Header("accept") accept: String = ACCEPT_HEADER,
        @Path("username") userName: String,
        @Query("per_page") perPage: Int? = null,
        @Query("page") page: Int? = null
    ): Response<List<ListedUser>>
}
