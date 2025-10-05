plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.mustinfohub"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.mustinfohub"
        minSdk = 30
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //<!--- For modern networking -->
    // For modern networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // For modern image loading
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // For displaying lists
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // Add this for HTML parsing
    implementation("org.jsoup:jsoup:1.17.2")
}