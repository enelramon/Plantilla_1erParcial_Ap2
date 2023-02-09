package com.ucne.proj_1erparcial_ap2.ui.theme.Prestamos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.proj_1erparcial_ap2.data.local.Entity.PrestamosEntity
import com.ucne.proj_1erparcial_ap2.data.repository.RepositorioPrestamos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


data class PrestamoUiState(
    val PrestamoLista: List<PrestamosEntity> = emptyList()
)

@HiltViewModel
class RegistroViewModel @Inject constructor(
    private val Repositorioprestamos: RepositorioPrestamos
) : ViewModel() {
    var deudor by mutableStateOf("")
    var concepto by mutableStateOf("")
    var monto by mutableStateOf("")

    var uiState = MutableStateFlow(PrestamoUiState())
        private set

    init {
        GetLista()
    }
    fun GetLista() {
        viewModelScope.launch(Dispatchers.IO) {
            Repositorioprestamos.getList().collect { lista ->
                uiState.update {
                    it.copy(PrestamoLista = lista)
                }
            }
        }
    }

    fun insertar() {
        val prestamos = PrestamosEntity(

            deudor = deudor.toInt(),
            concepto = concepto,
            monto = monto .toDoubleOrNull() ?: 0.0
        )
        viewModelScope.launch(Dispatchers.IO) {
            Repositorioprestamos.insert(prestamos)
            Limpiar()
        }
    }


    private fun Limpiar(){
        deudor = ""
        concepto = ""
        monto = ""
    }

}