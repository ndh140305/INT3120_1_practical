package com.example.dessertclicker.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.dessertclicker.data.Datasource
data class GameUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    val currentDessertPrice: Int = Datasource.dessertList[0].price,
    val currentDessertImageId: Int = Datasource.dessertList[0].imageId
)