buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Deps.Build.kotlin_gradle_plugin)
        classpath(Deps.Build.android_gradle_plugin)
        classpath(Deps.Build.hiltGradlePlugin)
        classpath(Deps.Build.sqlDelightGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}