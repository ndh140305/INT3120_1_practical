package com.example.dessertclicker.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun onDessertClicked() {
            _uiState.update { dessertUiState ->
                val dessertSold = dessertUiState.dessertsSold + 1
                val nextDessertId = getDessertIndex(dessertSold)
                dessertUiState.copy(
                    revenue = dessertUiState.revenue + dessertUiState.currentDessertPrice,
                    dessertsSold = dessertSold,
                    currentDessertIndex = nextDessertId,
                    currentDessertImageId = dessertList[nextDessertId].imageId,
                    currentDessertPrice = dessertList[nextDessertId].price
                )
            }
    }

    fun getDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertsSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                break
            }
        }
        return dessertIndex
    }
}