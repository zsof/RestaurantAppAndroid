package hu.zsof.restaurantApp.ui.screens.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.zsof.restaurantApp.R
import hu.zsof.restaurantApp.model.RestaurantData
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    val restaurants = mutableListOf<RestaurantData>()

    init {
        loadData()
    }

    fun loadData() {

        restaurants.add(RestaurantData (id=1, name = "Stefánia étterem", address = "1146 Budapest Stefánia út", rate = 4.0f, price=3.0f, image = R.drawable.stefania))
        restaurants.add(RestaurantData(id=2, name = "Frei Café", address = "Budapest Örs vezér tere 25", rate = 4.5f, price=3.0f, image = R.drawable.cafefrei))
        restaurants.add(RestaurantData(id=3, name = "Vapiano", address = "Budapest Vörösmarty tér 3", rate = 3.0f, price=3.0f, image = R.drawable.vapiano))
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