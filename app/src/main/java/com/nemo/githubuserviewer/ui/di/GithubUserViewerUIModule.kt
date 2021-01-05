package com.nemo.githubuserviewer.ui.di

import androidx.lifecycle.ViewModel
import com.nemo.githubuserviewer.di.ViewModelKey
import com.nemo.githubuserviewer.ui.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class GithubUserViewerUIModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
