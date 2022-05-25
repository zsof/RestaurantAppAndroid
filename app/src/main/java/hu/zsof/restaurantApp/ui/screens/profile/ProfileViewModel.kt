package hu.zsof.restaurantApp.ui.screens.profile

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ProfileViewModel @Inject constructor() : ViewModel() {
    val mItemsList = listOf(
    "Light",
    "Dark",
    )
}