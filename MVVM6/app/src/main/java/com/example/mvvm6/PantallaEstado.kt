package com.example.mvvm6

data class PantallaEstado(
    val inputNombre: String  = "",
    val inputLegajo: String = "",
    val listaUsuarios: List<Usuario> = emptyList()
)