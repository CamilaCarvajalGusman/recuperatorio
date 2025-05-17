package com.example.recuperatorio.listaRecordatorios

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.recuperatorio.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listaScreen(viewModel: ListaRecViewModel = hiltViewModel(), onBackPressed: () -> Unit) {
    LaunchedEffect(Unit) {
        viewModel.cargarRecordatorios()
    }

    val recordatorios by viewModel.listaflow.collectAsState()
//    var n = 0

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.text2))
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackPressed,
                        content = {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    )

                }
            )
        },
        content = {
                paddingValues ->  Column(
            modifier = Modifier.padding(paddingValues).padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                LazyColumn {
                    items(recordatorios) { rec ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
//                                Text("Recordatorio: "+(n+1).toString(), fontSize = 18.sp)
                                Text("Nombre: ${rec.nombre}", fontSize = 18.sp)
                                Text("Fecha: ${rec.fecha}")
                                Text("Importancia: ${rec.importancia}")
                            }
                        }
//                        n += 1
                    }
                }
            }
        }
        }
    )

//    Column(modifier = Modifier.padding(16.dp)) {
//        Text(
//            text = "Lista de Recordatorios",
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//        LazyColumn {
//            items(recordatorios) { rec ->
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 4.dp),
//                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//                ) {
//                    Column(modifier = Modifier.padding(12.dp)) {
//                        Text("Recordatorio: "+(n+1).toString(), fontSize = 18.sp)
//                        Text("Nombre: ${rec.nombre}", fontSize = 18.sp)
//                        Text("Fecha: ${rec.fecha}")
//                        Text("Importancia: ${rec.importancia}")
//                    }
//                }
//                n += 1
//            }
//        }
//    }
}

//@Preview(showBackground = true)
//@Composable
//fun ListaPreview() {
//    listaScreen()
//}