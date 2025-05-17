package com.example.usecases

import com.example.data.RecordatoriosRepository
import com.example.domain.Recordatorio

class RecuperarRecordatorios(
    val repository: RecordatoriosRepository
) {
    suspend fun invoke() : List<Recordatorio> {
        return repository.getAllRecordatorios()
    }
}