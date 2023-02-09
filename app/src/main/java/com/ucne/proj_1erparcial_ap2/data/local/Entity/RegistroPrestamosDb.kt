package com.ucne.proj_1erparcial_ap2.data.local.Entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ucne.proj_1erparcial_ap2.data.local.Dao.PrestamoDao

@Database(
    entities = [
        PrestamosEntity::class
    ],
    version = 1
)
abstract class RegistroPrestamosDb: RoomDatabase() {
    abstract val PrestamoDao: PrestamoDao
}