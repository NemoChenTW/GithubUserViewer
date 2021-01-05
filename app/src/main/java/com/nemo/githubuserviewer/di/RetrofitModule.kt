package com.nemo.githubuserviewer.di

import com.nemo.githubuserviewer.githubapi.GithubService
import com.nemo.githubuserviewer.githubapi.RetrofitManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGithubService(): GithubService {
        return RetrofitManager.getGithubService()
    }
}
