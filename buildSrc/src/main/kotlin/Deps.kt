import Versions.appCompatVersion
import Versions.hiltNavigationVersion
import Versions.hilt_version
import Versions.koinVersion
import Versions.kotlinxDatetimeVersion
import Versions.leakCanaryVersion

//TODO:Add Deps
object Deps {
    object Build {
        const val android_gradle_plugin =
            "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
        const val kotlin_gradle_plugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_gradle_plugin}"
        const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${hilt_version}"
        const val sqlDelightGradlePlugin =
            "com.squareup.sqldelight:gradle-plugin:${Versions.SqlDelightVersion}"
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.material}"
    }


    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
    }

    //TODO:Add Compose
    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose_version}"
        const val uiUtil = "androidx.compose.ui:ui-util:${Versions.compose_version}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose_version}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.compose_version}"
        const val material = "androidx.compose.material:material:${Versions.compose_version}"
        const val material_icons =
            "androidx.compose.material:material-icons-extended:${Versions.compose_version}"
        const val runtime = "androidx.compose.runtime:runtime:${Versions.compose_version}"
        const val compiler = "androidx.compose.compiler:compiler:${Versions.compose_version}"
        const val runtime_livedata =
            "androidx.compose.runtime:runtime-livedata:${Versions.compose_version}"
        const val foundationLayout =
            "androidx.compose.foundation:foundation-layout:${Versions.compose_version}"
        const val activity = "androidx.activity:activity-compose:${Versions.activity_compose}"

        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayoutComposeVersion}"
        const val navigation =
            "androidx.navigation:navigation-compose:${Versions.composeNavigationVerson}"
        const val coil = "io.coil-kt:coil-compose:${Versions.coilVersion}"

    }

    object Hilt {
        const val hiltAndroid = "com.google.dagger:hilt-android:$hilt_version"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$hilt_version"
        const val hiltNavigation = "androidx.hilt:hilt-navigation:$hiltNavigationVersion"
    }

    object SQLDelight {
        const val runTime = "com.squareup.sqldelight:runtime:${Versions.SqlDelightVersion}"
        const val androidDriver = "com.squareup.sqldelight:android-driver:${Versions.SqlDelightVersion}"
        const val nativeDriver = "com.squareup.sqldelight:native-driver:${Versions.SqlDelightVersion}"
    }

    //TODO:Add Coroutines
    object Coroutines {
        const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object Ktor {
        const val core = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktorVersion}"
        const val clientSerializationKotlin =
            "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktorVersion}"
        const val clientNegotiation =
            "io.ktor:ktor-client-content-negotiation:${Versions.ktorVersion}"
        const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktorVersion}"

        const val android = "io.ktor:ktor-client-android:${Versions.ktorVersion}"
        const val ios = "io.ktor:ktor-client-ios:${Versions.ktorVersion}"
    }

    //TODO:Add JetBrains
    object JetBrains {
        const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDateTime}"
        const val uiDesktop =
            "org.jetbrains.compose.ui:ui-desktop:${Versions.desktop_compose_plugin}"
        const val uiUtil = "org.jetbrains.compose.ui:ui-util:${Versions.desktop_compose_plugin}"
    }

    object Koin {
        const val common = "io.insert-koin:koin-core:$koinVersion"
        const val test = "io.insert-koin:koin-test:$koinVersion"
        const val android = "io.insert-koin:koin-android:$koinVersion"
        const val compose = "io.insert-koin:koin-androidx-compose:$koinVersion"
        const val desktop = "io.insert-koin:koin-core:$koinVersion"
    }

    object LiveCycle {
        const val android =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelLifeCycle}"
    }

    object Other {
        const val napier = "io.github.aakira:napier:${Versions.napier}"
        const val junit = "junit:junit:${Versions.junit}"
        const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${kotlinxDatetimeVersion}"
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:$leakCanaryVersion"

    }
}