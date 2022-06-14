import Plugins.composePlugin

plugins {
    kotlin(Plugins.serialization) version Versions.kotlin
    id(Plugins.androidLib)
    kotlin(Plugins.multiplatform)
}
version = "1.0.0"

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Deps.Other.datetime)
                implementation(Deps.Ktor.core)
                implementation(Deps.Ktor.clientSerialization)
                implementation(Deps.Ktor.clientSerializationKotlin)
                implementation(Deps.Ktor.clientNegotiation)
                implementation(Deps.Ktor.clientLogging)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting{
            dependencies {
                implementation(Deps.Ktor.android)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
            dependencies {
                implementation(Deps.Ktor.ios)
//                implementation("io.ktor:ktor-client-darwin:${Versions.ktorVersion}")
            }
        }
    }
}

android {
    compileSdk = Versions.compile_sdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
    }
}