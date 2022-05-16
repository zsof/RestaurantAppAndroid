package hu.zsof.restaurantApp.ui.main

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import hu.zsof.restaurantApp.R

enum class NavItem(
    @StringRes val title: Int,
    val icon: ImageVector,
    var route: String?
) {
    HOME(R.string.menu_home, Icons.Outlined.Home, NavScreen.Home.route),
    MAP(R.string.menu_map, Icons.Outlined.Place, null),
    FAVOURITES(R.string.menu_fav, Icons.Outlined.Favorite, null),
    PROFILE(R.string.menu_profile, Icons.Outlined.Person, null),
    LOGOUT(R.string.menu_log_out, Icons.Outlined.ExitToApp, NavScreen.Login.route);
}

@Composable
fun BottomNavBar(
    navController: NavController
) {
    val tabs = NavItem.values()

    BottomNavigation(
        backgroundColor = colors.secondaryVariant,
        modifier = Modifier.height(56.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        tabs.forEach { tab ->
            BottomNavigationItem(
                icon = { Icon(imageVector = tab.icon, contentDescription = null) },
                label = {
                    Text(
                        text = stringResource(tab.title),
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                },
                selected = currentRoute == tab.route,
                onClick = {
                    tab.route?.let {
                        navController.navigate(it) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                alwaysShowLabel = true
            )
        }
    }
}


@Composable
fun AppBar() {
    TopAppBar(
        elevation = 8.dp,
        backgroundColor = colors.primary,
        modifier = Modifier.height(56.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = stringResource(R.string.app_bar_name),
            fontSize= 24.sp,
            color = Color.Black
        )
    }
}