package com.nemo.githubuserviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nemo.githubuserviewer.di.DaggerGithubUserViewerComponent
import com.nemo.githubuserviewer.di.GithubUserViewerComponent
import com.nemo.githubuserviewer.di.GithubUserViewerComponentProvider
import com.nemo.githubuserviewer.ui.main.MainFragment

class MainActivity : AppCompatActivity(), GithubUserViewerComponentProvider {

    lateinit var githubUserViewerComponent: GithubUserViewerComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        githubUserViewerComponent = DaggerGithubUserViewerComponent.factory().create()

        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun provideGithubUserViewerComponent(): GithubUserViewerComponent {
        return githubUserViewerComponent
    }
}
