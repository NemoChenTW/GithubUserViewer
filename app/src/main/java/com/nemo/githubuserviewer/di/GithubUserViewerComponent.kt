package com.nemo.githubuserviewer.di

import com.nemo.githubuserviewer.ui.di.GithubUserViewerUIComponent
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RetrofitModule::class,
        SubComponentModule::class,
        UserRepositoryModule::class,
        ViewModelBuilderModule::class
    ]
)
interface GithubUserViewerComponent {
    @Component.Factory
    interface Factory {
        fun create(): GithubUserViewerComponent
    }

    fun githubUserViewerUIComponentFactory(): GithubUserViewerUIComponent.Factory
}

@Module(subcomponents = [GithubUserViewerUIComponent::class])
object SubComponentModule
