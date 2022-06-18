import Deps.Google.material
import Deps.Other.napier
import Versions.compile_sdk
import Versions.version_code

plugins {
    id(Plugins.androidApp)
    kotlin(Plugins.androidPlugin)
    kotlin(Plugins.kapt)
    kotlin(Plugins.serialization) version Versions.kotlin
    id(Plugins.hilt)

}

android {
    compileSdk = compile_sdk
    defaultConfig {
        applicationId = "com.example.foodfor_kmm.android"
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
        versionCode = version_code
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion =
            Versions.compose_compiler_version
    }
}

dependencies {
    implementation(project(":shared"))
    //2
    with(Deps.Google) {
        implementation(material)
    }
    //Compose
    with(Deps.Compose) {
        implementation(compiler)
        implementation(runtime)
        implementation(runtime_livedata)
        implementation(ui)
        implementation(tooling)
        implementation(foundation)
        implementation(foundationLayout)
        implementation(material)
        implementation(material_icons)
        implementation(activity)
        implementation(uiUtil)
        implementation(constraintLayout)
        implementation(navigation)
        implementation(coil)
    }
    with(Deps.Hilt){
        implementation(hiltAndroid)
        implementation(hiltNavigation)
        kapt(hiltCompiler)
    }
    with(Deps.AndroidX) {
        implementation(appCompat)
    }
    with(Deps.Other) {
        implementation(datetime)
        debugImplementation(leakCanary)
        implementation(napier)

    }
    with(Deps.Ktor){
        implementation(android)
    }
    with(Deps.Coroutines){
        implementation(android)
    }

    with(Deps.Koin) {
        implementation(android)
        implementation(compose)
    }

}