// Emplacement : /SmsBackupApp/build.gradle.kts

plugins {
    // Plugin Android pour l'application
    id("com.android.application") version "8.2.0" apply false
    // Plugin Kotlin pour Android
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}