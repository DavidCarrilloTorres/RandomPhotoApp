package com.example.randomphotoapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.randomphotoapp.R
import com.example.randomphotoapp.viewmodel.RandomUiState


@Composable
fun HomeScreen(
    randomUiState: RandomUiState,
    jsonResult: String,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Box(modifier = modifier) {
        when (randomUiState) {
            is RandomUiState.Loading -> LoadingScreen()
            is RandomUiState.Success -> Column {
                ResultScreen(jsonResult)
            }
            is RandomUiState.Error -> ErrorScreen()
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.loader),
            contentDescription = "Cargando datos..."
        )
    }
}

@Composable
fun ErrorScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription = "Error al cargar datos"
        )
    }
}

@Composable
fun ResultScreen(photosJson: String) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        if (photosJson.isNotEmpty()) {
            Text(text = photosJson, style = MaterialTheme.typography.bodyLarge)
        } else {
            Image(
                painter = painterResource(id = R.drawable.error_404),
                contentDescription = "Error al mostrar JSON"
            )
        }
    }
}

