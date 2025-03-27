package com.example.randomphotoapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.randomphotoapp.viewmodel.RandomViewModel


@Composable
fun RandomApp() {
    Scaffold { contentPadding ->
        Surface(modifier = Modifier.fillMaxSize()) {
            val randomViewModel: RandomViewModel = viewModel()
            HomeScreen(
                randomUiState = randomViewModel.randomUiState.value,
                jsonResult = randomViewModel.jsonResult.value,
                modifier = Modifier.padding(contentPadding)
            )
        }
    }
}