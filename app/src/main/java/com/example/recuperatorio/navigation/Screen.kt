package com.example.recuperatorio.navigation

sealed class Screen (val route: String) {
    object SplashScreen : Screen("splash")
    object RegistroScreen : Screen("registroRec")
    object ListaScreen : Screen("listaRec")
}