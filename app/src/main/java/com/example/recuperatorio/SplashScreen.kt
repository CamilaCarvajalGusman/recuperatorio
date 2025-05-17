package com.example.recuperatorio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recuperatorio.ui.theme.RecuperatorioTheme
import kotlinx.coroutines.delay

@Composable
fun splashScreen( onSuccess : () -> Unit ) {
    val azul = Color(red = 12, green = 144, blue = 217)

    LaunchedEffect (Unit) {
        delay(5000)
        onSuccess()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = azul),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(200.dp),
            painter = painterResource(id = R.drawable.calendario),
            contentDescription = "Logo"
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SplashPreview() {
//    splashScreen()
//}