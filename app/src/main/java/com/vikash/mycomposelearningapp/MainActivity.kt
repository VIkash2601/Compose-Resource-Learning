package com.vikash.mycomposelearningapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vikash.mycomposelearningapp.ui.theme.MyComposeLearningAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeLearningAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(name = "Android")
                }
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun Greeting(modifier: Modifier = Modifier, name: String = "") {
    Row(
        modifier = Modifier.padding(all = 8.dp),
        verticalAlignment = CenterVertically
    ) {
        Surface(
            shadowElevation = 5.dp,
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "User Icon",
                Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.inversePrimary, CircleShape)
                    .padding(2.dp, 0.dp, 2.dp, 4.dp),
                alignment = Center
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Column(
            modifier = modifier
        ) {
            Text(
                text = "Hello $name!",
                modifier = modifier,
                color = Color.Green,
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "This text is justified.",
                modifier = modifier,
                color = MaterialTheme.colorScheme.inversePrimary,
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposeLearningAppTheme {
        Greeting(name = "Android")
    }
}