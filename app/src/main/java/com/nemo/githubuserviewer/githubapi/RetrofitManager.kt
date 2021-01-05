package com.nemo.githubuserviewer.githubapi

import com.nemo.githubuserviewer.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {
    private val TAG = RetrofitManager::class.java.simpleName

    private val okHttpClient = OkHttpClient.Builder()
        // Http logger interceptor
        .also { builder ->
            if (BuildConfig.DEBUG) {
                builder.addInterceptor(
                    HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                        println("$TAG $it")
                    }).setLevel(HttpLoggingInterceptor.Level.BODY)
                )
            }
        }
        .build()

    private val githubService = createService<GithubService>("https://api.github.com")

    private inline fun <reified T> createService(url: String): T {
        val builder = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)

        return builder.build().create(T::class.java)
    }

    fun getGithubService(): GithubService {
        return githubService
    }
}
