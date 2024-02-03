package com.vikash.mycomposelearningapp.navexample

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vikash.mycomposelearningapp.navexample.screen.HomeScreen
import com.vikash.mycomposelearningapp.navexample.screen.LoginScreen
import com.vikash.mycomposelearningapp.navexample.screen.NavigationItem
import com.vikash.mycomposelearningapp.navexample.screen.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Splash.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Splash.route) {
            SplashScreen(navController)
        }
        composable(NavigationItem.Login.route) {
            LoginScreen(navController)
        }
        composable(NavigationItem.Home.route) {
            HomeScreen(
                navigation = navController,
                email = it.arguments?.getString(
                    "email",
                    ""
                ),
                password = it.arguments?.getString(
                    "password",
                    ""
                )
            )
        }
    }
}
