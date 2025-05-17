package com.example.recuperatorio.registroRecordatorio

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recuperatorio.R

@Composable
fun registroScreen(viewModel: RegistroRecViewModel = hiltViewModel(), onSuccess : () -> Unit) {
    var nomRec by remember { mutableStateOf("") }
    var fecRec by remember { mutableStateOf("") }
    var impRec by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(0.dp, 10.dp, 0.dp, 10.dp),
            text = stringResource(id = R.string.text1),
            fontSize = 20.sp
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = nomRec,
            onValueChange = {
                nomRec = it
            },
            label = {
                Text(
                    text = stringResource(id = R.string.input1)
                )
            }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = fecRec,
            onValueChange = {
                fecRec = it
            },
            label = {
                Text(
                    text = stringResource(id = R.string.input2)
                )
            }
        )

        Column {
            Text(
                modifier = Modifier
                    .padding(0.dp, 10.dp, 0.dp, 10.dp),
                text = stringResource(id = R.string.sel1),
                fontSize = 20.sp
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = impRec == "Normal",
                    onClick = { impRec = "Normal" }
                )
                Text(
                    text = stringResource(id = R.string.op1),
                    fontSize = 18.sp
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = impRec == "Importante",
                    onClick = { impRec = "Importante" }
                )
                Text(
                    text = stringResource(id = R.string.op2),
                    fontSize = 18.sp
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = impRec == "Muy Importante",
                    onClick = { impRec = "Muy Importante" }
                )
                Text(
                    text = stringResource(id = R.string.op3),
                    fontSize = 18.sp
                )
            }
        }

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.guardarRec(nomRec, fecRec, impRec)

                nomRec = ""
                fecRec = ""
                impRec = ""
            }
        ) {
            Text(
                text = stringResource(id = R.string.btn1)
            )
        }

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onSuccess()
            }
        ) {
            Text(
                text = stringResource(id = R.string.btn2)
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun RegPreview() {
//    registroScreen()
//}