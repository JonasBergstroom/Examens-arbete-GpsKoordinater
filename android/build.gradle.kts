plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    id("androidx.navigation.safeargs")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "se.gpsapp.gpsappkmm.android"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("androidx.activity:activity-ktx:1.5.0-alpha02")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("com.android.databinding:viewbinding:7.1.2")
    implementation("androidx.core:core:1.7.0")
}