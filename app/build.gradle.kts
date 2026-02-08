// Emplacement : /SmsBackupApp/app/build.gradle.kts

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.smsLogger"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.smsLogger"
        minSdk = 21 
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true // Active l'optimisation (réduit la taille de l'APK)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        
        debug {
            isDebuggable = true 
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Dépendances minimales pour le système Android
    implementation("androidx.core:core-ktx:1.12.0")
    
    // Pour gérer les services d'arrière-plan modernes (WorkManager)
    // Utile si tu veux que la sauvegarde soit ultra-robuste
    implementation("androidx.work:work-runtime-ktx:2.9.0")

    // Note : On ne met pas "implementation(androidx.appcompat:appcompat)" 
    // car on ne veut aucune interface graphique.
}