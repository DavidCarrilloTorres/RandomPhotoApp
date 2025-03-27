package com.example.randomphotoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.randomphotoapp.ui.RandomApp
import com.example.randomphotoapp.ui.theme.RandomPhotoAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomPhotoAppTheme {
                RandomApp()
            }
        }
    }
}