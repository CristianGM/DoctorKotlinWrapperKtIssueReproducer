# Doctor KotlinWrapperKt Issue Reproducer

## Context
I want to apply the doctor plugin on all the company projects.
We have internally a setings plugins (for artifactory and gradle enterprise configuration) and a project plugin (for static analysis and conventions)

I tried to apply the doctor using the project plugin but it fails because... it checks it's applied on the root and precompiled scripts generation use a "sample" project that doens't apply it into the root projects...

Then I thought we could use the settings plugin. It works unless a subproject is using kapt.

## Issue
When a subproject use kapt and the doctor plugin is applied through settings.gradle.kts the build fails with:
> java.lang.ClassNotFoundException: org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapperKt
>  at com.osacky.doctor.DoctorPlugin$apply$2$3.invoke(DoctorPlugin.kt:93)

You can see the scan: https://scans.gradle.com/s/i6w5wqolnkiu2


## Another tries and a weirder issue
Adding to the settings.gradle.kts buildscript
`classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")`
just because it didn't find the kotlinPluginWrapperKt I found another issue

> * What went wrong:
>  com/android/build/gradle/BaseExtension

Here is the scan: https://scans.gradle.com/s/lwkzdlgwjlpym
