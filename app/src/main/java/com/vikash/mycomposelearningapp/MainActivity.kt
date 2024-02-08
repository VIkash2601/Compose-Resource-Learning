package com.vikash.mycomposelearningapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.vikash.mycomposelearningapp.data.Message
import com.vikash.mycomposelearningapp.screens.SetupNavGraph
import com.vikash.mycomposelearningapp.ui.theme.MyComposeLearningAppTheme
import com.vikash.mycomposelearningapp.utility.SampleData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeLearningAppTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
                /*// A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(name = "User")
                }*/
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, name: String = "") {

    // Local Composable Context
    val context = LocalContext.current

    Column {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .padding(all = 8.dp)
                .fillMaxWidth()
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
                    text = "Test",
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Spacer(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Transparent)
            )
            Button(
                modifier = Modifier.width(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                onClick = {}) {
                Text(
                    text = "Button",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
            Spacer(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Transparent)
            )
            Button(
                modifier = Modifier.width(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                onClick = {
                    // navigate to Login Activity
                    context.startActivity(Intent(context, LoginActivity::class.java))
                }) {
                Text(
                    text = "Login",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
        Column(
            modifier = Modifier.padding(all = 8.dp)
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) PreviewConversation()
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
fun GreetingPreview() {
    MyComposeLearningAppTheme {
        Greeting(name = "Android")
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewConversation() {
    MyComposeLearningAppTheme {
        Conversation(SampleData().conversationSample())
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MessageCard(msg: Message) {
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .padding(horizontal = 10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_user),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            label = "Background Color",
        )

        // We toggle the isExpanded variable when we click on this Column
        Column(
            modifier = Modifier
                .clickable { isExpanded = !isExpanded }
        ) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    textAlign = TextAlign.Justify,
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
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
fun CardMinimalExample() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {
            Text(
                text = "Hello, world!",
                modifier = Modifier
                    .padding(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            border = BorderStroke(2.dp, Color.Cyan)
        ) {
            Text(
                text = "Outlined Card",
                modifier = Modifier
                    .padding(20.dp)
            )
        }
    }
}