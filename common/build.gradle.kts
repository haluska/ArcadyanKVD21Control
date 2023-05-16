plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    android()
    jvm("desktop") {
        jvmToolchain(11)
    }
    sourceSets {
        val ktorVersion = "2.3.0"

        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material3)

                api("dev.icerock.moko:resources:0.22.0")
                api("dev.icerock.moko:resources-compose:0.22.0")
                api("io.ktor:ktor-client-core:${ktorVersion}")
                api("io.ktor:ktor-client-auth:${ktorVersion}")
                api("io.ktor:ktor-client-content-negotiation:${ktorVersion}")
                api("io.ktor:ktor-serialization-kotlinx-json:${ktorVersion}")
                api("dev.icerock.moko:mvvm-compose:0.16.1")
                api("dev.icerock.moko:mvvm-flow-compose:0.16.1")
                api("org.jetbrains.kotlin:kotlin-reflect:${rootProject.extra["kotlin.version"]}")
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.6.1")
                api("com.google.android.material:material:1.9.0")
                api("com.google.accompanist:accompanist-themeadapter-material3:0.31.2-alpha")

                api("androidx.core:core-ktx:1.10.1")
                api("io.ktor:ktor-client-cio:${ktorVersion}")
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
                api("io.ktor:ktor-client-cio:${ktorVersion}")
                api("com.github.weisj:darklaf-core:3.0.2")
            }
        }
    }
}

android {
    compileSdk = rootProject.extra["compile_sdk"].toString().toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = rootProject.extra["min_sdk"].toString().toInt()
        targetSdk = rootProject.extra["target_sdk"].toString().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "dev.zwander.resources.common"
}
