import com.diffplug.gradle.spotless.SpotlessExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.serialization) apply false
    alias(libs.plugins.dokka)
    alias(libs.plugins.spotless)
}

buildscript {
    repositories {
        google()
        gradlePluginPortal()
    }
}

allprojects {
    group = "com.github.SpokeSugar.mastodonk"
    version = "0.2-alpha07"

    repositories {
        mavenCentral()
        google()
    }

    afterEvaluate {
        val projectName = name

        extensions.findByType<PublishingExtension>()?.apply {
            publications.withType<MavenPublication>().configureEach {
                pom {
                    name.set(projectName)
                    description.set("Kotlin/Multiplatform library for Mastodon")
                    url.set("https://github.com/outadoc/mastodonk")

                    issueManagement {
                        url.set("https://github.com/outadoc/mastodonk/issues")
                        system.set("GitHub Issues")
                    }

                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }

                    developers {
                        developer {
                            name.set("Baptiste Candellier")
                            email.set("baptiste@candellier.me")
                        }
                    }

                    scm {
                        connection.set("scm:git:git://github.com/outadoc/mastodonk.git")
                        developerConnection.set("scm:git:git://github.com/outadoc/mastodonk.git")
                        url.set("https://github.com/outadoc/mastodonk")
                    }
                }
            }

//            repositories {
//                maven {
//                    name = "nexus"
//                    url = uri("https://nexus.outadoc.fr/repository/public")
//                    credentials {
//                        username = System.getenv("NEXUS_USERNAME")
//                        password = System.getenv("NEXUS_PASSWORD")
//                    }
//                }
//            }
        }
    }

    tasks.withType<KotlinJvmCompile> {
        compilerOptions {
            optIn.add("kotlin.RequiresOptIn")
        }
    }
}

configure<SpotlessExtension> {
    format("misc") {
        target(
            "**/*.kt",
            "**/*.kts",
            "**/*.md",
            "**/.gitignore"
        )

        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
}
