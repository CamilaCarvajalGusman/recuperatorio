package com.example.recuperatorio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recuperatorio.ui.theme.RecuperatorioTheme
import kotlinx.coroutines.delay

@Composable
fun splashScreen(onSuccess: () -> Unit) {
    val rosaSuave = Color(0xFFFFE4E1) // Color rosa suave

    LaunchedEffect(Unit) {
        delay(5000)
        onSuccess()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = rosaSuave),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "RecordatoriosApp",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000)
            )
        }
    }
}