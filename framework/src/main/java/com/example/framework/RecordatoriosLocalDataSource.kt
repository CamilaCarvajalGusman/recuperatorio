package com.example.framework

import android.content.Context
import com.example.data.recordatorios.ILocalDataSource
import com.example.domain.Recordatorio
import com.example.framework.mappers.listaMap
import com.example.framework.mappers.toEntity
import com.example.framework.persistence.AppRoomDatabase
import com.example.framework.persistence.IRecordatorioDAO

class RecordatoriosLocalDataSource(val context: Context) : ILocalDataSource {
    val recordatorioDAO: IRecordatorioDAO = AppRoomDatabase.getDatabase(context).recordatorioDao()
    override suspend fun save(rec: Recordatorio): Boolean {
        recordatorioDAO.insert(rec.toEntity())
        return true
    }

    override suspend fun getAllRecordatorios(): List<Recordatorio> {
        val listaRec = recordatorioDAO.getRecordatorios()
        return listaRec.listaMap()
    }
}