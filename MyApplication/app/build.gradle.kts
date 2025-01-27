plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.juanfra.examenbimbo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.juanfra.examenbimbo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        true.also {
            viewBinding = it
            dataBinding = it
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.runtime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Design
    implementation(libs.lottie)
    implementation(libs.material)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)

    // navigation component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.runtime.ktx)


    // viewmodel livedata
    implementation(libs.androidx.lifecycle.livedata)
    implementation(libs.androidx.lifecycle.viewmodel)


    // Retrofit
    implementation(libs.bundles.retrofit)

    // Okhttp3
    implementation(libs.okhttp)
    implementation(libs.okhttp.tls)

    // Dagger Hilt
    implementation(libs.hilt.android)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.hilt.android.compiler)

    // RXJava 2
    /*implementation(libs.rxJava2)
    implementation(libs.androidx.room.rxj2)*/
    implementation(libs.glide)
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("androidx.room:room-rxjava2:2.6.1")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.4.0")
}