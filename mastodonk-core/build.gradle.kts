import org.jetbrains.dokka.gradle.DokkaTaskPartial
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    kotlin("plugin.serialization")
    id("org.jetbrains.dokka")
    `maven-publish`
}

kotlin {
    explicitApi()

    jvm {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }

        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }

    js(IR) {
        browser()
        nodejs()
    }

    linuxX64()
    linuxArm64()
    macosX64()
    macosArm64()
    mingwX64()

    iosArm64()
    iosSimulatorArm64()
    iosX64()
    applyDefaultHierarchyTemplate()

    sourceSets {

        // Common source-sets

        commonMain {
            dependencies {
                implementation(libs.datetime)
                implementation(libs.serialization)
                implementation(libs.ktor.core)
                implementation(libs.ktor.contentNegociation)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.websockets)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        // JVM source-sets
        jvmMain {
            dependencies {
                implementation(libs.ktor.engine.java)
            }
        }

        jvmTest {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }

        // JS source-sets

        jsMain {
            dependencies {
                implementation(libs.ktor.engine.js)
            }
        }

        jsTest {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }

        // Desktop source-sets

        val desktopMain by creating {
            dependsOn(commonMain.get())
            dependencies {
                implementation(libs.ktor.engine.curl)
            }
        }
        val desktopTest by creating {
            dependsOn(commonTest.get())
        }

        linuxMain {
            dependsOn(desktopMain)
        }
        macosMain {
            dependsOn(desktopMain)
        }
        mingwMain {
            dependsOn(desktopMain)
        }

        linuxTest {
            dependsOn(desktopTest)
        }
        macosTest {
            dependsOn(desktopTest)
        }
        mingwTest {
            dependsOn(desktopTest)
        }


        // iOS source-sets
        iosMain {
            dependencies {
                implementation(libs.ktor.engine.ios)
            }
        }
    }
}

tasks.withType<DokkaTaskPartial>().configureEach {
    dokkaSourceSets {
        configureEach {
            includes.from("README.md")
        }
    }
}
