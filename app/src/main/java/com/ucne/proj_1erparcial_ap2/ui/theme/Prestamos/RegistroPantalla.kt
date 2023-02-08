package com.ucne.proj_1erparcial_ap2.ui.theme.Prestamos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ucne.proj_1erparcial_ap2.data.local.Entity.PrestamosEntity


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
            label = { Text("Monto") }
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
            PrestamoRow()
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
