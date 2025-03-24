package com.gangadhari.rsandroidtakehomechallenge.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gangadhari.rsandroidtakehomechallenge.domain.entities.Route
import com.gangadhari.rsandroidtakehomechallenge.presentation.viewmodels.RoutesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoutesScreen(viewModel: RoutesViewModel, driverId: Int, navController: NavController) {
    val routes = viewModel.routes.collectAsState().value

    LaunchedEffect(driverId) {
        viewModel.loadRoutes(driverId)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Routes") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(routes) { route ->
                RouteItem(route = route)
            }
        }
    }
}

@Composable
fun RouteItem(route: Route) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation( 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${route.name}")
            Text(text = "Type: ${route.type}")
        }
    }
}