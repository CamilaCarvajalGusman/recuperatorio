package com.example.usecases

import com.example.data.RecordatoriosRepository
import com.example.domain.Recordatorio

class SaveRecordatorio(
    val repository: RecordatoriosRepository
) {
    suspend fun invoke(recordatorio: Recordatorio) {
        repository.save(recordatorio)
    }
}