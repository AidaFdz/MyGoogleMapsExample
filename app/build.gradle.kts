plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.myapplicationmaps"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.myapplicationmaps"
        minSdk = 22
        targetSdk = 33
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
}

dependencies {

    classpath ("com.android.tools.build:gradle:7.0.0")
    classpath ("com.google.gms:google-services:4.3.10")
    implementation ("com.google.android.gms:play-services-maps:18.0.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation ("com.google.firebase:firebase-auth:22.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-location:18.0.0")
    implementation("com.google.android.libraries.places:places:2.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //Task#dependsOn (":app:processDebugGoogleServices" from ":app:mergeDebugResources")
    //Task#mustRunAfter (":app:processDebugGoogleServices" from ":app:mergeDebugResources")

}
    fun DependencyHandlerScope.classpath(s: String) {

}
