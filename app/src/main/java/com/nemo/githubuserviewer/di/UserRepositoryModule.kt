package com.nemo.githubuserviewer.di

import com.nemo.githubuserviewer.model.GithubUserRepository
import com.nemo.githubuserviewer.model.UserRepository
import dagger.Binds
import dagger.Module

@Module
abstract class UserRepositoryModule {

    @Binds
    abstract fun bindUserRepository(githubUserRepository: GithubUserRepository): UserRepository
}
