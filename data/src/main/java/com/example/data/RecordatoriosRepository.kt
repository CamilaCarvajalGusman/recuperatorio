package com.example.data

import com.example.data.recordatorios.ILocalDataSource
import com.example.domain.Recordatorio

class RecordatoriosRepository(private val localDataSource: ILocalDataSource) {
    suspend fun save(rec: Recordatorio): Boolean {
        this.localDataSource.save(rec)
        return true
    }
    suspend fun getAllRecordatorios(): List<Recordatorio> {
        return this.localDataSource.getAllRecordatorios()
    }
}