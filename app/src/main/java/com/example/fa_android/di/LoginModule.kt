package com.example.fa_android.di

import com.example.fa_android.feature.login.LoginViewModel
import org.koin.dsl.module

val loginModule=module{
    single { LoginViewModel() }
}