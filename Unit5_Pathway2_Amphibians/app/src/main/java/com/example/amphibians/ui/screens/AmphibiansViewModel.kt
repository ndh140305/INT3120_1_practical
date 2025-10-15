package com.example.amphibians.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch

import java.io.IOException
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.amphibians.AmphibiansPhotosApplication
import com.example.amphibians.data.AmphibiansPhotosRepository
import com.example.amphibians.network.AmphibiansPhoto
import kotlinx.coroutines.CoroutineExceptionHandler

class AmphibiansViewModel(private val amphibiansPhotosRepository: AmphibiansPhotosRepository) : ViewModel() {
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibiansPhotos()
    }

    fun getAmphibiansPhotos() {
        val handler = CoroutineExceptionHandler { _, exception ->
            Log.e("MarsApp", "Coroutine failed: $exception")
        }
        viewModelScope.launch(handler) {
            amphibiansUiState = try {
                AmphibiansUiState.Success(amphibiansPhotosRepository.getAmphibiansPhotos())
            } catch (e: IOException) {
                AmphibiansUiState.Error
                throw e
            } catch (e: Exception) {
                AmphibiansUiState.Error
                throw e
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansPhotosApplication)
                val amphibiansPhotosRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansPhotosRepository = amphibiansPhotosRepository)
            }
        }
    }
}
sealed interface AmphibiansUiState {
    data class Success(val photos: List<AmphibiansPhoto>) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}
