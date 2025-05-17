package com.example.recuperatorio.registroRecordatorio

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.domain.Recordatorio
import com.example.framework.mappers.toEntity
import com.example.usecases.SaveRecordatorio
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistroRecViewModel @Inject constructor(
    private val saveRecordatorio: SaveRecordatorio,
    @ApplicationContext private val context: Context
) : ViewModel() {
//    private val _nombreflow = MutableStateFlow<String>("")
//    val nombreflow : StateFlow<String> = _nombreflow
//
//    private val _fechaflow = MutableStateFlow<String>("")
//    val fechaflow : StateFlow<String> = _fechaflow
//
//    private val _impflow = MutableStateFlow<String>("")
//    val impflow : StateFlow<String> = _impflow

    fun guardarRec(nomRec: String, fecRec: String, impRec: String) {
        viewModelScope.launch {
            val rec = Recordatorio(nomRec, fecRec, impRec)
            saveRecordatorio.invoke(rec)
        }
    }
}
