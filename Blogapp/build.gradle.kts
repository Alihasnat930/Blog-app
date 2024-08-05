// Define Kotlin version
val kotlin_version = "1.5.21"

// Build script configuration
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.gradle)
        classpath(libs.kotlin.gradle.plugin)
    }
}

// All projects configuration
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

// Clean task configuration
tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}
