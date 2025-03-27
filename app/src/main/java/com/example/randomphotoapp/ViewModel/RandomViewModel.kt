package com.example.randomphotoapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomphotoapp.model.RandomPhoto
import com.example.randomphotoapp.network.RandomApi
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface RandomUiState {
    data class Success(val photos: List<RandomPhoto>) : RandomUiState
    object Error : RandomUiState
    object Loading : RandomUiState
}

class RandomViewModel : ViewModel() {
    var randomUiState = mutableStateOf<RandomUiState>(RandomUiState.Loading)
        private set

    var jsonResult = mutableStateOf<String>("")
        private set

    init {
        getRandomPhotos()
    }

    fun getRandomPhotos() {
        viewModelScope.launch {
            randomUiState.value = try {
                val photos = RandomApi.retrofitService.getRandomImages()
                val gson = Gson()
                val json = gson.toJson(photos)
                jsonResult.value = json

                RandomUiState.Success(photos)
            } catch (e: IOException) {
                RandomUiState.Error
            }
        }
    }
}