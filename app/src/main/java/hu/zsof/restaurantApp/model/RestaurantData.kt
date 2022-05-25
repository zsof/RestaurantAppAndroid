package hu.zsof.restaurantApp.model

import hu.zsof.restaurantApp.R

data class RestaurantData(
    val id: Long,
    val name: String,
    val address: String,
    val rate: Float,
    val price: Float,
    val image: Int
) {
    companion object {
        fun mock() = RestaurantData(
            id = 0,
            name = "Vági Cukrászda",
            address = "2120 Dunakeszi Fő út 63",
            rate = 3.0f,
            price = 2.0f,
            image = R.drawable.fagyizo
        )

    }
}
