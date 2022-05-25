package hu.zsof.restaurantApp.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hu.zsof.restaurantApp.ui.screens.home.HomeList
import hu.zsof.restaurantApp.ui.screens.login.Login
import hu.zsof.restaurantApp.ui.screens.register.Register
import hu.zsof.restaurantApp.ui.screens.profile.Profile

@Composable
fun RestaurantMainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController = navController) }
    )
    {
        NavHost(
            navController = navController,
            startDestination = NavScreen.Home.route,
            modifier = Modifier.padding(bottom = it.calculateBottomPadding())
        )
        {
            composable(NavScreen.Home.route) {
                HomeList(navController = navController)
            }
            composable(NavScreen.Login.route) {
                Login(navController = navController)
            }
            composable(NavScreen.Register.route){
                Register(navController = navController)
            }
            composable(NavScreen.Profile.route) {
                Profile(navController = navController)
            }
        }
    }


}

sealed class NavScreen(val route: String) {

    object Home : NavScreen("Home")
    object Login : NavScreen("Login")
    object Register: NavScreen("Register")
    object Profile: NavScreen("Profile")

}