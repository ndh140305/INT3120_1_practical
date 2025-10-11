package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        MyCityUiState(
            categoryList = LocalRecommendationsDataProvider.getCategories(),
            currentCategory = LocalRecommendationsDataProvider.getCategories().getOrElse(0) {
                LocalRecommendationsDataProvider.defaultCategory
            },
            recommendationList = LocalRecommendationsDataProvider.getRecommendationsForCategory(
                LocalRecommendationsDataProvider.defaultCategory.id
            ),
            currentRecommendation = LocalRecommendationsDataProvider.defaultRecommendation
        )
    )
    val uiState: StateFlow<MyCityUiState> = _uiState

    fun updateCurrentCategory(selected: Category) {
        _uiState.update {
            it.copy(
                currentCategory = selected,
                recommendationList = LocalRecommendationsDataProvider.getRecommendationsForCategory(selected.id),
                isShowingCategoryList = false,
                isShowingRecommendationList = true,
                isShowingRecommendationDetail = false
            )
        }
    }

    fun updateCurrentRecommendation(selected: Recommendation) {
        _uiState.update {
            it.copy(
                currentRecommendation = selected,
                isShowingCategoryList = false,
                isShowingRecommendationList = false,
                isShowingRecommendationDetail = true
            )
        }
    }

    fun navigateToRecommendationList() {
        _uiState.update {
            it.copy(
                isShowingCategoryList = false,
                isShowingRecommendationList = true,
                isShowingRecommendationDetail = false
            )
        }
    }

    fun navigateToCategoryList() {
        _uiState.update {
            it.copy(
                isShowingCategoryList = true,
                isShowingRecommendationList = false,
                isShowingRecommendationDetail = false
            )
        }
    }
}

data class MyCityUiState(
    val categoryList: List<Category> = emptyList(),
    val currentCategory: Category = LocalRecommendationsDataProvider.defaultCategory,
    val recommendationList: List<Recommendation> = emptyList(),
    val currentRecommendation: Recommendation = LocalRecommendationsDataProvider.defaultRecommendation,
    val isShowingCategoryList: Boolean = true,
    val isShowingRecommendationList: Boolean = false,
    val isShowingRecommendationDetail: Boolean = false
)