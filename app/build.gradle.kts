plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.egsystem.unikosheba"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.egsystem.unikosheba"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.activity)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.vectordrawable)


// Retrofit + RxJava
    implementation(libs.rxjava)
    implementation(libs.rxandroid)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit.converter.scalars)
    implementation(libs.gson)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit.rxjava2.adapter)

// Image loader
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)
    implementation(libs.apache.commons)

// Lottie animation
    implementation(libs.lottie)

// Circle ImageView
    implementation(libs.circleimageview)

// Google Location
    implementation(libs.play.services.location)

// Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    annotationProcessor(libs.androidx.room.compiler)
//dialog
    implementation(libs.material.dialog)

    //imageSlider
    implementation(libs.image.slider)

//    implementation(libs.retrofit.rxjava2.adapter2)
//    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")
//    implementation("com.afollestad.material-dialogs:core:0.9.6.0")
}