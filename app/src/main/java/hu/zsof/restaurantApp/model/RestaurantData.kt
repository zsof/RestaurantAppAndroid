package hu.zsof.restaurantApp.model

data class RestaurantData(
    val id: Long,
    val name: String,
    val address: String,
    val rate: Float,
    val price: Float,
    val image: String
) {
    companion object {
        fun mock() = RestaurantData(
            id=0,
            name = "Vági Cukrászda",
            address = "2120 Dunakeszi Fő út 63",
            rate = 3.0f,
            price = 2.0f,
            image ="https://www.google.com/search?q=ice+cream&sxsrf=APq-WBuaZJwmIWkG_joa8ZLG2pllh-sC_w:1650811462040&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiIw6T296z3AhUn6LsIHT1gAXYQ_AUoAXoECAIQAw&biw=1422&bih=589&dpr=1.35#imgrc=8FLhzR3Rcet8pM"
        )

    }
}
