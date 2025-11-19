plugins {
    kotlin("jvm")
    application
}

kotlin {
    compilerOptions {
        optIn.add("kotlin.time.ExperimentalTime")
    }
}

dependencies {
    implementation(projects.mastodonkCore)
    implementation(projects.mastodonkPaging)
    implementation(libs.coroutines.core)
}

application {
    mainClass.set("fr.outadoc.mastodonk.sample.SampleKt")
}
