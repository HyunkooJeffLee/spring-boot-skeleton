pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "spring-boot-skeleton"

include(
    "lib-common",
    "api-internal",
    "api-external",
    "api-backoffice",
)
