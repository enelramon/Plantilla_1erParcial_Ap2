package com.ucne.proj_1erparcial_ap2.data.repository

import com.ucne.proj_1erparcial_ap2.data.local.Dao.PrestamoDao
import com.ucne.proj_1erparcial_ap2.data.local.Entity.PrestamosEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class RepositorioPrestamos @Inject constructor(
    private  val PrestamoDao: PrestamoDao
) {
    suspend fun insert(prestamo: PrestamosEntity) {
        return PrestamoDao.insert(prestamo)
    }
    suspend fun delete(prestamo: PrestamosEntity) = PrestamoDao.delete(prestamo)
    suspend fun find(Deudor:Int) = PrestamoDao.find(Deudor)

    fun getList(): Flow<List<PrestamosEntity>> = PrestamoDao.GetList()

}