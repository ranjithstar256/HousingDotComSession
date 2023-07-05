package housing.com

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import housing.com.ui.theme.HousingSessionTheme

@Composable
fun BoxExample() {
    Column{
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.cap),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "Background Image",
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Good Noon",
                style = TextStyle(color= Color.Red,fontSize = 24.sp)
            )
        }
    }
}

class CalcPrac : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HousingSessionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Greeting(applicationContext )
                        BoxExample()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(applicationContext: Context) {
    var s1 by remember { mutableStateOf("") }
    var s2 by remember { mutableStateOf("") }
    var b by remember { mutableStateOf(false) }
    var c by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.cap)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

      

            Image(painterResource(id = R.drawable.abc),
                contentDescription = "",Modifier.width(50.dp))
            Image(painterResource(id = R.drawable.valthreetwo)  ,
                contentDescription = "")

            TextField(value = s1, onValueChange = { s1 = it }, label = { Text(text = "Enter value 1") })
            TextField(value = s2, onValueChange = { s2 = it }, label = { Text(text = "Enter value 2") })
            Row() {
                Button(onClick = {
                    c = (s1.toInt() + s2.toInt()).toString()
                    b = true
                }) {
                    Text(text = "Add")
                }
                Button(onClick = {
                    c = (s1.toInt() - s2.toInt()).toString()
                    b = true
                }) {
                    Text(text = "Sub")
                }
                Button(onClick = {
                    c = (s1.toInt() * s2.toInt()).toString()
                    b = true
                }) {
                    Text(text = "Mul")
                }
                Button(onClick = {
                    c = (s1.toDouble() / s2.toDouble()).toString()
                    b = true
                }) {
                    Text(text = "Dv")
                }
            }
            if (b) {
                Text(
                    text = c,
                    fontSize = 32.sp, color = Color.Blue
                )
            }
        

    }
}