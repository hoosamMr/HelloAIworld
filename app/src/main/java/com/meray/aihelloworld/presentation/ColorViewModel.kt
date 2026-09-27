package com.meray.aihelloworld.presentation

import androidx.lifecycle.ViewModel
import com.meray.aihelloworld.domain.repository.ColorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


data class ColorUiState(
    val r: Float = 0f,
    val g: Float = 0f,
    val b: Float = 0f,
    val probability: Float = 0.5744f,
    val confidenceText: String = "",
    val isLightBackground : Boolean = false
    )

@HiltViewModel
class ColorViewModel @Inject constructor(
    private val repository: ColorRepository
) : ViewModel(){
    private val _uiState = MutableStateFlow(ColorUiState())
    val uiState : StateFlow<ColorUiState> = _uiState.asStateFlow()
    init {
        val initialState = _uiState.value
        calculateAndUpdateState(initialState.r, initialState.g, initialState.b)
    }

    fun onColorChange(r: Float, g: Float, b: Float){
       //val prob = repository.getPrediction(r.toInt(),g.toInt(), b.toInt())
       // _uiState.update { it.copy(r = r, g = g, b= b, probability = prob) }
        calculateAndUpdateState(r, g, b)
    }
    private fun calculateAndUpdateState(r: Float, g: Float, b: Float){
        val prob = repository.getPrediction(r.toInt(), g.toInt(), b.toInt())

        val confidencePercentage = (prob * 100).toInt()
        val confidenceString = "$confidencePercentage%"
        val isLight = prob > 0.5f

        _uiState.update {
            it.copy(
                r= r,
                g = g,
                b = b,
                probability = prob,
                confidenceText = confidenceString,
                isLightBackground = isLight
            )
        }
    }
}