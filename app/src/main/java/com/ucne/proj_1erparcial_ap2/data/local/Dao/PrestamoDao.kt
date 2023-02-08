package com.ucne.proj_1erparcial_ap2.data.local.Dao

import androidx.room.*
import com.ucne.proj_1erparcial_ap2.data.local.Entity.PrestamosEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PrestamoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(PrestamoEntity: PrestamosEntity)

    @Delete
    suspend fun delete(PrestamoEntity: PrestamosEntity)

    @Query("""
        SELECT * 
        FROM Prestamos
        WHERE deudor=:Deudor
        LIMIT 1
    """)
    suspend fun find(Deudor: Int): PrestamosEntity?

    @Query("""SELECT * 
        FROM Prestamos
        ORDER BY Deudor desc
    """)
    fun GetList(): Flow<List<PrestamosEntity>>

}
class dao{
    fun save():Boolean{
        return true
    }
}