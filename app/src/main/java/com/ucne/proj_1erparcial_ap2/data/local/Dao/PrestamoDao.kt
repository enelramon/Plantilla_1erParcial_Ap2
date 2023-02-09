package com.ucne.proj_1erparcial_ap2.data.local.Dao

import androidx.room.*
import com.ucne.proj_1erparcial_ap2.data.local.Entity.PrestamosEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PrestamoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(prestamoEntity: PrestamosEntity)

    @Delete
    suspend fun delete(prestamoEntity: PrestamosEntity)

    @Query("""
        SELECT * 
        FROM Prestamos
        WHERE prestamoId= PrestamoId
        LIMIT 1
    """)
    suspend fun replace(prestamoId: Int): PrestamosEntity?
    @Query("Select * from Prestamos")
    fun GetList(): Flow<List<PrestamosEntity>>

}
