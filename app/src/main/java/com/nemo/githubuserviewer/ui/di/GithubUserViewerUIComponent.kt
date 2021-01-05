package com.nemo.githubuserviewer.ui.di

import com.nemo.githubuserviewer.ui.main.MainFragment
import dagger.Subcomponent

@Subcomponent(modules = [GithubUserViewerUIModule::class])
interface GithubUserViewerUIComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): GithubUserViewerUIComponent
    }

    fun inject(fragment: MainFragment)
}
