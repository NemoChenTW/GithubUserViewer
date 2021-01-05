plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId = "com.nemo.githubuserviewer"
        minSdkVersion(29)
        targetSdkVersion(30)
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }

}

dependencies {
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.cardview)
    implementation(Dependencies.AndroidX.recyclerview)
    implementation(Dependencies.AndroidX.pagingRuntime)
    implementation(Dependencies.AndroidX.constraintlayout)
    implementation(Dependencies.AndroidX.activityKtx)
    implementation(Dependencies.AndroidX.fragmentKtx)
    implementation(Dependencies.AndroidX.Lifecycle.livedataKtx)
    implementation(Dependencies.AndroidX.Lifecycle.viewmodelKtx)
    implementation(Dependencies.Google.material)

    implementation(Dependencies.Glide.glide)
    kapt(Dependencies.Glide.Kapt.glideCompiler)

    implementation(Dependencies.Retrofit.converterGson)
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.Okhttp3.loggingInterceptor)

    implementation(Dependencies.Dagger2.dagger)
    implementation(Dependencies.Dagger2.daggerAndroidSupport)
    kapt(Dependencies.Dagger2.Kapt.daggerAndroidProcessor)
    kapt(Dependencies.Dagger2.Kapt.daggerCompiler)

    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.pagingCommon)

    androidTestImplementation(Dependencies.Test.extJunit)
    androidTestImplementation(Dependencies.Test.espressoCore)
}
