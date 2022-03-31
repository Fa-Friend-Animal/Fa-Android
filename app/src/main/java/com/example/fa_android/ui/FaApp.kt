package com.example.fa_android.ui

import android.app.Application
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fa_android.di.loginModule
import com.example.fa_android.feature.login.screen.Login
//import com.example.fa_android.feature.main.Main
import com.example.fa_android.util.Screen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


@OptIn(
    ExperimentalAnimationApi::class,
    androidx.compose.foundation.ExperimentalFoundationApi::class,
    androidx.compose.material.ExperimentalMaterialApi::class,
    kotlinx.coroutines.ExperimentalCoroutinesApi::class
)
@Composable
fun FaApp() {
    val navController = rememberNavController()
//    val systemUiController = rememberSystemUiController()
//    val scaffoldState = rememberScaffoldState()
//
//    if (isSystemInDarkTheme()) {
//        systemUiController.setSystemBarsColor(
//            color = Color.Black
//        )
//        systemUiController.setNavigationBarColor(
//            color = Color.Black,
//            darkIcons = false
//        )
//    } else {
//        systemUiController.setSystemBarsColor(
//            color = Teal900
//        )
//        systemUiController.setNavigationBarColor(
//            color = Color.White,
//            darkIcons = true
//        )
//    }
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(Screen.LoginScreen.route) { Login(navController = navController) }
//        composable(route = Screen.MainScreen.route,) { Main(navController = navController) }

    }
}
class FaApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FaApplication)
            modules(loginModule)
        }

    }

}