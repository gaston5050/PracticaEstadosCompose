package com.example.mvvm6

import androidx.lifecycle.ViewModel
import com.example.mvvm6.ui.theme.ListadoUsuarios
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UsuariosViewModel: ViewModel() {

   private val _uiState = MutableStateFlow(PantallaEstado(
    listaUsuarios = ListadoUsuarios.listadoU.toList(),
       contadorRegistros = ListadoUsuarios.listadoU.size
   ))
    val uiState: StateFlow<PantallaEstado> = _uiState.asStateFlow()


    fun agregarUsuario(nombre: String, legajo: String) {
        val nuevoUsuario = Usuario(nombre, legajo)
        ListadoUsuarios.listadoU.add(nuevoUsuario)
        _uiState.value = _uiState.value.copy(
            inputNombre = "",
            inputLegajo = "",
        listaUsuarios = ListadoUsuarios.listadoU.toList())
        contador()

    }
    fun contador(){
        _uiState.value = _uiState.value.copy(
            contadorRegistros = ListadoUsuarios.listadoU.size
        )
    }

    fun cambioNombre(nombre: String) {
        _uiState.value = _uiState.value.copy(inputNombre = nombre)
    }

    fun cambioLegajo(legajo: String) {
        _uiState.value = _uiState.value.copy(inputLegajo = legajo)
    }
}

