package hu.zsof.restaurantApp.ui.screens.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.zsof.restaurantApp.model.RestaurantData
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    val restaurants = mutableListOf<RestaurantData>()

    init {
        loadData()
    }

    fun loadData() {

        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
        restaurants.add(RestaurantData.mock())
    }
}