package com.nemo.githubuserviewer.di

import com.nemo.githubuserviewer.GithubUserViewerContentProvider
import com.nemo.githubuserviewer.model.database.UserDao
import com.nemo.githubuserviewer.model.database.UserDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideUserDao(): UserDao {
        return UserDatabase.getInstance(GithubUserViewerContentProvider.appContext!!).userDao()
    }
}
