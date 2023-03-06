package com.ucne.proj_1erparcial_ap2.ui.theme.Prestamos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucne.proj_1erparcial_ap2.data.local.Entity.PrestamosEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrestamosList(viewModel: RegistroViewModel = hiltViewModel()) {

    Column(Modifier.fillMaxSize()) {
        PrestamoBody(viewModel)

        val uiState by viewModel.uiState.collectAsState()
        PrestamosList(uiState.PrestamoLista)
    }
}
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun PrestamoBody(
    viewModel: RegistroViewModel
) {
    Column(modifier = Modifier.fillMaxWidth()) {

        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = viewModel.deudor,
            onValueChange = {  viewModel.deudor = it },
            label = { Text("Deudor") },
            isError = viewModel.hasDeudorError,
            singleLine = true
        )

        if (viewModel.hasDeudorError) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "El campo Deudor es requerido",
                color = Color.Red
            )
        }
        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = viewModel.concepto,
            onValueChange = {  viewModel.concepto = it },
            label = { Text("Concepto") }
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = viewModel.monto,
            onValueChange = { viewModel.monto = it },
            label = { Text("Monto") }
        )

        ExtendedFloatingActionButton(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            text = { Text("Guardar") },
            icon = { Icon(imageVector = Icons.Filled.Save, contentDescription = "Save") },
            onClick = { viewModel.insertar() }
        )
    }
}

@Composable
private fun PrestamosList(PrestamosLista: List<PrestamosEntity>) {
    LazyColumn {
        items(PrestamosLista) { prestamo ->
            PrestamoRow(prestamo)
        }
    }
}
@Composable
private fun PrestamoRow(prestamo: PrestamosEntity) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = prestamo.deudor,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(3f)
            )
            Text(
                text = prestamo.concepto,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(3f)
            )
            Text(
                String.format("%.2f", prestamo.monto),
                textAlign = TextAlign.End,
                modifier = Modifier.weight(2f)
            )
        }
        Divider(Modifier.fillMaxWidth())
    }
}
