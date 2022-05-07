package hu.zsof.restaurantApp.ui.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import hu.zsof.restaurantApp.ui.screens.home.HomeList
import hu.zsof.restaurantApp.ui.screens.login.Login

@Composable
fun RestaurantMainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController = navController) }
    )
    {
        NavHost(
            navController = navController,
            startDestination = NavScreen.Home.route
        )
        {
            composable(NavScreen.Home.route) {
                HomeList(navController = navController)
            }
            composable(NavScreen.Login.route) {
                Login(navController = navController)
            }
        }
    }


}

sealed class NavScreen(val route: String) {

    object Home : NavScreen("Home")
    object Login : NavScreen("Login")

}