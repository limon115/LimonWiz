// Author: Khalid Hasan Limon
package com.limon.classwiz.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.limon.classwiz.presentation.viewmodel.CalculatorViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: CalculatorViewModel = koinViewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onAppSelected = { appName ->
                    // In a full implementation, we would set the mode in ModeManager here
                    navController.navigate("calculator")
                }
            )
        }
        composable("calculator") {
            CalculatorScreen(viewModel = viewModel)
        }
    }
}
