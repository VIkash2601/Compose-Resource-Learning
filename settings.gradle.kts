pluginManagement {
    repositories {
        google()
        // jcenter() // For Kotlin DSL Legacy Support
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        // jcenter() // For Kotlin DSL Legacy Support
        mavenCentral()
    }
}

rootProject.name = "My Compose Learning App"
include(":app")
include(":weatherapp")
