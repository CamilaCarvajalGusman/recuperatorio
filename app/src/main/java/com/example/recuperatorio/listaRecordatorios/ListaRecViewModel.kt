package com.example.recuperatorio.listaRecordatorios

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Recordatorio
import com.example.usecases.RecuperarRecordatorios
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListaRecViewModel @Inject constructor(
    private val getRecordatorios: RecuperarRecordatorios,
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val _listaflow = MutableStateFlow<List<Recordatorio>>(emptyList())
    val listaflow : StateFlow<List<Recordatorio>> = _listaflow

    fun cargarRecordatorios() {
        viewModelScope.launch {
            _listaflow.value = getRecordatorios.invoke()
        }
    }
}