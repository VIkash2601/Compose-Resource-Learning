package com.vikash.mycomposelearningapp.navexample.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vikash.mycomposelearningapp.R
import com.vikash.mycomposelearningapp.viewmodel.SignInViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navigation: NavController) {

    val signInViewModel = remember { SignInViewModel() }
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .width(IntrinsicSize.Min)
            .padding(all = 5.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login screen")

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = signInViewModel.email,
            onValueChange = { signInViewModel.updateEmail(it) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 30.dp, vertical = 0.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = signInViewModel.password,
            onValueChange = { signInViewModel.updatePassword(it) },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 30.dp, vertical = 0.dp),
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = painterResource(
                            if (passwordVisibility) R.drawable.ic_visibility_24
                            else R.drawable.ic_visibility_off_24
                        ),
                        contentDescription = "toggle_password"
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 30.dp, vertical = 0.dp),
            onClick = {
                signInViewModel.signIn(navigation)
            }) {
            Text(text = "Login")
        }
    }
}