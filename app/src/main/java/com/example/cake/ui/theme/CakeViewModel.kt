package com.example.cake.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CakeViewModel : ViewModel() {
    val _uiState = MutableStateFlow(CakeUiState())
    val uiState: StateFlow<CakeUiState> = _uiState.asStateFlow()
    val calorie_1: Int = 500
    val calorie_2: Int = 720
    val calorie_4: Int = 450

    fun calculateCalories(): Int {

        return (calorie_1+calorie_2+calorie_4)
    }
}