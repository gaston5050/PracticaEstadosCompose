package com.example.mvvm6

import androidx.lifecycle.ViewModel
import com.example.mvvm6.ui.theme.ListadoUsuarios
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UsuariosViewModel: ViewModel() {

   private val _uiState = MutableStateFlow(PantallaEstado(
    listaUsuarios = ListadoUsuarios.listadoU.toList()
   ))
    val uiState: StateFlow<PantallaEstado> = _uiState.asStateFlow()


    fun agregarUsuario(nombre: String, legajo: String) {
        val nuevoUsuario = Usuario(nombre, legajo)
        ListadoUsuarios.listadoU.add(nuevoUsuario)

    }

    fun cambioNombre(nombre: String) {
        _uiState.value = _uiState.value.copy(inputNombre = nombre)
    }
}
