package com.example.framework.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RecordatorioDB::class], version = 1, exportSchema = false)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun recordatorioDao(): IRecordatorioDAO

    companion object {
        @Volatile
        var Instance: AppRoomDatabase? = null

        fun getDatabase(context: Context): AppRoomDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext, AppRoomDatabase::class.java, "recordatorio_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}