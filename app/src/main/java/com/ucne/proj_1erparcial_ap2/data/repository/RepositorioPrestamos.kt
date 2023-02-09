package com.ucne.proj_1erparcial_ap2.data.repository

import com.ucne.proj_1erparcial_ap2.data.local.Dao.PrestamoDao
import com.ucne.proj_1erparcial_ap2.data.local.Entity.PrestamosEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class RepositorioPrestamos @Inject constructor(
    private  val prestamoDao: PrestamoDao
) {
    suspend fun insert(prestamo: PrestamosEntity) {
        return prestamoDao.insert(prestamo)
    }
    fun getList(): Flow<List<PrestamosEntity>> = prestamoDao.GetList()
}