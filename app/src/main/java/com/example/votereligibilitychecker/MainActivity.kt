package com.example.votereligibilitychecker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.* // Import Material3 components if using other Material3 components
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ... (rest of your code)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VoterEligibilityCheckerApp()
        }
    }
}

@Composable
fun VoterEligibilityCheckerApp() {
    val context = LocalContext.current
    var ageText by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }
    var resultColor by remember { mutableStateOf(Color.Black) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF87CEFA), // Light blue
                        Color(0xFFB0C4DE)  // Dark blue
                    )
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to Voter Eligibility Checker",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = ageText,
            onValueChange = { ageText = it },
            label = { Text("Enter your age") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(onClick = {
            val age = ageText.toIntOrNull()
            if (age != null) {
                if (age >= 18) {
                    resultText = "Congratulations, you are eligible to vote!"
                    resultColor = Color.Green
                } else {
                    resultText = "You are under 18 and not eligible to vote."
                    resultColor = Color.Red
                }
            } else {
                resultText = "Please enter a valid number for your age."
                resultColor = Color.Red
            }
        }) {
            Text("Check Eligibility")
        }

        Text(
            text = resultText,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = resultColor,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

