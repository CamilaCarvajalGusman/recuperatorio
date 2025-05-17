package com.example.framework.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IRecordatorioDAO {
    @Query("SELECT * FROM recordatorio_db")
    suspend fun getRecordatorios(): List<RecordatorioDB>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(rec: RecordatorioDB)
}