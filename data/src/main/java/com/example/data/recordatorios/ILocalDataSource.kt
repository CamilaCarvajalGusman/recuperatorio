package com.example.data.recordatorios

import com.example.domain.Recordatorio

interface ILocalDataSource {
    suspend fun save(rec: Recordatorio): Boolean
    suspend fun getAllRecordatorios(): List<Recordatorio>
}