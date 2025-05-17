package com.example.framework.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "recordatorio_db")
data class RecordatorioDB(
    @ColumnInfo(name = "nombre")
    var nomr: String,
    @ColumnInfo(name = "fecha")
    var fecr: String,
    @ColumnInfo(name = "importancia")
    var impr: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}
