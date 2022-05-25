package hu.zsof.restaurantApp.model

data class UserData(
    val id: Long,
    val name: String,
    val email: String
) {
    companion object {
        fun mock() = UserData(
            id = 0,
            name = "Test Jancsi",
            email = "test.jancsi@gmail.com"
        )
    }
}
