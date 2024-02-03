package com.vikash.mycomposelearningapp.navexample.screen

enum class Screen {
    SPLASH,
    HOME,
    LOGIN,
}
sealed class NavigationItem(val route: String) {
    object Splash : NavigationItem(Screen.SPLASH.name)
    object Home : NavigationItem("${Screen.HOME.name}/{email}/{password}") {
        fun sendCredentials(email: String, password: String) = "${Screen.HOME.name}/$email/$password"
    }
    object Login : NavigationItem(Screen.LOGIN.name)
}