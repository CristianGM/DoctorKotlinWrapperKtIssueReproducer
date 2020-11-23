buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.osacky.doctor:doctor-plugin:0.6.3")
    }
}

gradle.rootProject {
    apply(plugin = "com.osacky.doctor")
}

include(":app")
rootProject.name = "DoctorKotlinWrapperKtIssueReproducer"
