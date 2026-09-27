package com.meray.aihelloworld.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ColorScreen(
    modifier: Modifier = Modifier,
    viewModel : ColorViewModel = hiltViewModel()
){
    val uiState by viewModel.uiState.collectAsState()

    val bgColor = Color(uiState.r / 255f, uiState.g / 255f, uiState.b / 255f)
    val textColor = if (uiState.probability > 0.5f) Color.White else Color.Black

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(bgColor),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(24.dp)

        ) {
            Text(
                text = "AI Hello World",
                color = textColor,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "AI Confidence: ${uiState.confidenceText}",
                color = textColor.copy(alpha = 0.7f),
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(60.dp))

            ColorPickerSlider("Red", uiState.r) { viewModel.onColorChange(it, uiState.g, uiState.b) }
            ColorPickerSlider("Green", uiState.g) { viewModel.onColorChange(uiState.r, it, uiState.b) }
            ColorPickerSlider("Blue", uiState.b) { viewModel.onColorChange(uiState.r, uiState.g, it) }
        }
    }
}
@Composable
fun ColorPickerSlider(label: String, value: Float, onValueChange: (Float) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Text(text = "$label: ${value.toInt()}", color = Color.Gray)
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = 0f..255f
        )
    }
}