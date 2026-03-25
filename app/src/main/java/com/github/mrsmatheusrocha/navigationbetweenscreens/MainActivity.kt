package com.github.mrsmatheusrocha.navigationbetweenscreens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.mrsmatheusrocha.navigationbetweenscreens.screens.LoginScreen
import com.github.mrsmatheusrocha.navigationbetweenscreens.screens.MenuScreen
import com.github.mrsmatheusrocha.navigationbetweenscreens.screens.PedidosScreen
import com.github.mrsmatheusrocha.navigationbetweenscreens.screens.PerfilScreen
import com.github.mrsmatheusrocha.navigationbetweenscreens.ui.theme.NavigationBetweenScreensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationBetweenScreensTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(route = "login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "pedidos") {
                            PedidosScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "perfil/{nome}") {
                            val nome: String = it.arguments?.getString("Nome", "Usuário Genérico")
                            PerfilScreen(modifier = Modifier.padding(innerPadding), navController, nome!!)
                        }
                    }
                }
            }
        }
    }
}