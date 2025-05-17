package com.example.framework.mappers

import com.example.domain.Recordatorio
import com.example.framework.persistence.RecordatorioDB

fun Recordatorio.toEntity(): RecordatorioDB {
    return RecordatorioDB(nombre, fecha, importancia)
}

fun RecordatorioDB.toModel(): Recordatorio {
    return Recordatorio(nomr, fecr, impr)
}

fun List<RecordatorioDB>.listaMap(): List<Recordatorio> {
    return this.map { it.toModel() }
}