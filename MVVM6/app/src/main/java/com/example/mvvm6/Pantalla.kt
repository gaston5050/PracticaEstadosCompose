package com.example.mvvm6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Principal (){
    PrincipalUi()
}

@Composable
fun PrincipalUi(usuariosViewModel: UsuariosViewModel = viewModel()) {

    val appEstado by usuariosViewModel.uiState.collectAsState()


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),          // padding interno de la tarjeta
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                   value = appEstado.inputNombre,
                    onValueChange = {usuariosViewModel.cambioNombre(it)},
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = appEstado.inputLegajo,
                    label = { Text("Legajo") },
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Aquí está el botón perfectamente centrado
                Button(
                    onClick = {usuariosViewModel.agregarUsuario(appEstado.inputNombre, appEstado.inputLegajo)
                    },
                    modifier = Modifier
                        .wrapContentWidth()           // o .width(IntrinsicSize.Max) si quieres que ocupe el ancho disponible
                ) {
                    Text("Guardar")
                }

            }
        }
        LazyColumn() {
            items(appEstado.listaUsuarios) {
                    UsuarioItem(usuario = it)

            }
        }
    }
}

@Composable
fun UsuarioItem(usuario: Usuario) {
    Card(){
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = usuario.nombre)
            Text(text = usuario.legajo)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {

        Principal()

}