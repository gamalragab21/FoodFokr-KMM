import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
// 1
plugins {
    kotlin(Plugins.multiplatform)
    id(Plugins.composePlugin) version Versions.desktop_compose_plugin
}
// 2
group = "com.example.foodfor_kmm"

version = "1.0.0"
// 3
kotlin {
// 1
    jvm {
        withJava()
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
// 2
    sourceSets {
        val jvmMain by getting {
// 3
            kotlin.srcDirs("src/jvmMain/kotlin")
            dependencies {

                implementation(compose.desktop.currentOs)
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(compose.ui)
                api(compose.materialIconsExtended)

                implementation(Deps.Other.napier)
                // Coroutines
                implementation(Deps.Coroutines.common)
                implementation(project(":shared"))
// implementation(project(":shared-ui"))
            }
        }
    }
}
// 1
compose.desktop {
// 2
    application {
// 3
        mainClass = "MainKt"
// 4
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi,
                TargetFormat.Deb)
            packageName = "FoodFor_Kmm"
            macOS {
                bundleID = "com.example.foodFor_Kmm"
            }
        }
    }
}