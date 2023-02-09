package com.ucne.proj_1erparcial_ap2.data.local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Prestamos")
data class PrestamosEntity(
    @PrimaryKey(autoGenerate = true)
    val deudor: Int?= null,
    val concepto: String,
    val monto: Double
)