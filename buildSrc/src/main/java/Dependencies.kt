object Dependencies {

    const val gradlePlugin = "com.android.tools.build:gradle:4.1.0"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val activityKtx = "androidx.activity:activity-ktx:1.1.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.2.5"
        const val cardview = "androidx.cardview:cardview:1.0.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0"
        const val pagingRuntime = "androidx.paging:paging-runtime-ktx:${Versions.paging}"

        object Room {
            const val room = "androidx.room:room-runtime:${Versions.room}"
            const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

            object Kapt {
                const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
            }
        }

        object Lifecycle {
            const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
            const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
        }
    }

    object Dagger2 {
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val daggerAndroidSupport =
                "com.google.dagger:dagger-android-support:${Versions.dagger}"

        object Kapt {
            const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
            const val daggerAndroidProcessor =
                    "com.google.dagger:dagger-android-processor:${Versions.dagger}"
        }
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

        object Kapt {
            const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:1.2.1"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    }

    object Retrofit {
        object Okhttp3 {
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:3.12.0"
        }

        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object Test {
        const val junit = "junit:junit:4.+"
        const val extJunit = "androidx.test.ext:junit:1.1.2"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        const val pagingCommon = "androidx.paging:paging-common-ktx:${Versions.paging}"
        const val room = "androidx.room:room-testing:${Versions.room}"
    }


}
