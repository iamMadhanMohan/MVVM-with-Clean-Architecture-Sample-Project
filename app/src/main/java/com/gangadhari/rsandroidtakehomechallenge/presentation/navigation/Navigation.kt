package com.gangadhari.rsandroidtakehomechallenge.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gangadhari.rsandroidtakehomechallenge.presentation.ui.screens.DriversScreen
import com.gangadhari.rsandroidtakehomechallenge.presentation.ui.screens.RoutesScreen
import com.gangadhari.rsandroidtakehomechallenge.presentation.viewmodels.DriversViewModel
import com.gangadhari.rsandroidtakehomechallenge.presentation.viewmodels.RoutesViewModel


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "drivers") {
        composable("drivers") {
            val viewModel: DriversViewModel = hiltViewModel()
            DriversScreen(viewModel = viewModel, navController = navController)
        }
        composable(
            "routes/{driverId}",
            arguments = listOf(navArgument("driverId") { type = NavType.IntType })
        ) { backStackEntry ->
            val driverId = backStackEntry.arguments?.getInt("driverId") ?: 0
            val viewModel: RoutesViewModel = hiltViewModel()
            RoutesScreen(viewModel = viewModel, driverId = driverId, navController = navController)
        }
    }
}