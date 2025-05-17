package com.example.recuperatorio.registroRecordatorio

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recuperatorio.R

@Composable
fun registroScreen(viewModel: RegistroRecViewModel = hiltViewModel(), onSuccess: () -> Unit) {
    var nomRec by remember { mutableStateOf("") }
    var fecRec by remember { mutableStateOf("") }
    var impRec by remember { mutableStateOf(setOf<String>()) }
    var expanded by remember { mutableStateOf(false) }

    val opcionesImportancia = listOf("Normal", "Importante", "Muy Importante")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .background(Color(0xFFFFE4E1)), // Fondo rosa suave
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
            text = stringResource(id = R.string.text1),
            fontSize = 22.sp // Aumenté el tamaño de la letra
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = nomRec,
            onValueChange = { nomRec = it },
            label = { Text(text = stringResource(id = R.string.input1)) }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = fecRec,
            onValueChange = { fecRec = it },
            label = { Text(text = stringResource(id = R.string.input2)) }
        )

        Column {
            Text(
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
                text = stringResource(id = R.string.sel1),
                fontSize = 22.sp
            )

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { expanded = true }
            ) {
                Text(text = "Selecciona importancia")
            }

            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                opcionesImportancia.forEach { opcion ->
                    DropdownMenuItem(
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = impRec.contains(opcion),
                                    onCheckedChange = { isChecked ->
                                        impRec = if (isChecked) impRec + opcion else impRec - opcion
                                    }
                                )
                                Text(text = opcion, fontSize = 18.sp)
                            }
                        },
                        onClick = {}
                    )
                }
            }
        }

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.guardarRec(nomRec, fecRec, impRec.joinToString(", ")) // Guarda múltiples selecciones
                nomRec = ""
                fecRec = ""
                impRec = emptySet()
            }
        ) {
            Text(text = stringResource(id = R.string.btn1))
        }

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onSuccess() }
        ) {
            Text(text = stringResource(id = R.string.btn2))
        }
    }
}