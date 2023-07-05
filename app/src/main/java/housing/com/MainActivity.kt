package housing.com

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
// Intent - > switch bwt screen/activity
            startActivity(Intent(applicationContext,CalcPrac::class.java))
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.Yellow),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                var s1 by remember {
                    mutableStateOf("")
                }
                var s2 by remember {
                    mutableStateOf("")
                }
                var b by remember {
                    mutableStateOf(false)
                }

                Text(text = "Username", fontSize = 32.sp, color = Color.Green)

                TextField(value = s1, onValueChange = { s1 = it })

                Text(text = "Password", fontSize = 32.sp, color = Color.Green)
                TextField(value = s2, onValueChange = { s2 = it })

                Row() {


                    Button(onClick = {


                        Toast.makeText(
                            applicationContext,
                            s1,
                            Toast.LENGTH_LONG
                        ).show()

                        b = true


                    }) {
                        Text(text = "Sign Up")
                    }
                    Button(onClick = {
                        Toast.makeText(
                            applicationContext,
                            s2,
                            Toast.LENGTH_LONG
                        ).show()
                    }) {
                        Text(text = "Sign In")
                    }

                }

                if (b) {
                    Text(
                        text = s1,
                        fontSize = 32.sp, color = Color.Blue
                    )
                }

            }
        }
    }
}