package com.example.fa_android.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.example.fa_android.ui.screen.LoginScreenPreview
import com.example.fa_android.ui.theme.FaAndroidTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FaAndroidTheme {
                LoginScreenPreview {

                }
            }
        }
    }
}