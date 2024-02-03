package com.vikash.mycomposelearningapp.navexample.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SplashScreen(navigation: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Splash screen")
        Button(onClick = {
            navigation.navigate(NavigationItem.Login.route) {
                popUpTo(NavigationItem.Splash.route) {
                    inclusive = true
                }
            }
        }) {
            Text("Go to login screen")
        }
    }
}