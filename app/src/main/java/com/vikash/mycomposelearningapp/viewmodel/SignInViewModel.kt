package com.vikash.mycomposelearningapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.vikash.mycomposelearningapp.navexample.screen.NavigationItem

class SignInViewModel : ViewModel() {

    private val TAG = "SignInViewModel"

    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    fun updateEmail(input: String) {
        Log.e(TAG, "Updating email: $input")
        email = input
    }

    fun updatePassword(input: String) {
        Log.e(TAG, "Updating password: $input")
        password = input
    }

    fun signIn(navigation: NavController? = null) {
        Log.e(TAG, "signIn: $email & $password")
        // navigation?.navigate("${NavigationItem.Home.route}/${email}/${password}")
        navigation?.navigate(NavigationItem.Home.sendCredentials(email, password))
    }
}