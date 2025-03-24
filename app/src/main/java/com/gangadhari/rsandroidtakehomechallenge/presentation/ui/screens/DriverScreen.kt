package com.gangadhari.rsandroidtakehomechallenge.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gangadhari.rsandroidtakehomechallenge.domain.entities.Driver
import com.gangadhari.rsandroidtakehomechallenge.presentation.viewmodels.DriversViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DriversScreen(viewModel: DriversViewModel, navController: NavController) {
    val drivers = viewModel.drivers.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Drivers") },
                actions = {
                    IconButton(onClick = { viewModel.sortDrivers() }) {
                        Icon(Icons.Filled.Edit, contentDescription = "Sort")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(drivers) { driver ->
                DriverItem(driver = driver) {
                    navController.navigate("routes/${driver.id}")
                }
            }
        }
    }
}

@Composable
fun DriverItem(driver: Driver, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClick() },
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = driver.name)
        }
    }
}

