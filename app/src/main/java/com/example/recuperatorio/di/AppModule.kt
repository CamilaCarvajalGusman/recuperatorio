package com.example.recuperatorio.di

import android.content.Context
import com.example.data.RecordatoriosRepository
import com.example.data.recordatorios.ILocalDataSource
import com.example.framework.RecordatoriosLocalDataSource
import com.example.usecases.RecuperarRecordatorios
import com.example.usecases.SaveRecordatorio
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalDataSource(@ApplicationContext context: Context): ILocalDataSource {
        return RecordatoriosLocalDataSource(context)
    }

    @Provides
    @Singleton
    fun recRepository( localDataSource: ILocalDataSource): RecordatoriosRepository {
        return RecordatoriosRepository(localDataSource)
    }

    @Provides
    @Singleton
    fun provideSaveRec(repository: RecordatoriosRepository): SaveRecordatorio {
        return SaveRecordatorio(repository)
    }

    @Provides
    @Singleton
    fun provideRecuperarRec(repository: RecordatoriosRepository): RecuperarRecordatorios {
        return RecuperarRecordatorios(repository)
    }
}