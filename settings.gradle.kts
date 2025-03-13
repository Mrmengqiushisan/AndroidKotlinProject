pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidKotlinProject"
include(":app")
include(":activitylifecycletest")
include(":listviewtest")
include(":recyclerviewtest")
include(":uibestpractice")
include(":animationtest")
include(":viewpager")
include(":popupwindow")
include(":fragmenttest")
include(":fragmentbestpractice")
include(":viewpager2")
include(":wechatpage")
