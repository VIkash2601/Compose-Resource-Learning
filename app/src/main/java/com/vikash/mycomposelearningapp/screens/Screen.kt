package com.vikash.mycomposelearningapp.screens

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
}
