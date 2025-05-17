package com.example.recuperatorio.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recuperatorio.listaRecordatorios.listaScreen
import com.example.recuperatorio.registroRecordatorio.registroScreen
import com.example.recuperatorio.splashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(Screen.SplashScreen.route) {
            splashScreen(
                onSuccess = {
                    navController.navigate(Screen.RegistroScreen.route)
                }
            )
        }

        composable(Screen.RegistroScreen.route) {
            registroScreen(
                onSuccess = {
                    navController.navigate(Screen.ListaScreen.route)
                }
            )
        }

        composable(Screen.ListaScreen.route) {
            listaScreen(onBackPressed = { navController.popBackStack() })
        }
    }
}