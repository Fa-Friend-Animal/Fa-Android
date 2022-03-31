package com.example.fa_android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.fa_android.ui.theme.FaAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FaAndroidTheme {
              Surface(color= MaterialTheme.colors.background) {
                FaApp()
                }
            }
        }
    }
}