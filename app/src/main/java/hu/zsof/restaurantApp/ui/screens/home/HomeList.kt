package hu.zsof.restaurantApp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarPurple500
import androidx.compose.material.icons.outlined.Games
import androidx.compose.material.icons.outlined.Pin
import androidx.compose.material.icons.outlined.PushPin
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import hu.zsof.restaurantApp.model.RestaurantData
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import hu.zsof.restaurantApp.R
import hu.zsof.restaurantApp.ui.main.AppBar
import hu.zsof.restaurantApp.ui.theme.RestaurantAppTheme

@Composable
fun HomeList(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val restaurants = viewModel.restaurants

    val listState = rememberLazyListState()
    Scaffold(
        topBar = { AppBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {

            }

        },
        isFloatingActionButtonDocked = true,

    ) {
        Column(

            modifier = Modifier
                .background(MaterialTheme.colors.background)
        ) {
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(8.dp)
            ) {
                items(
                    items = restaurants
                )
                { restaurant ->
                    HomeListData(restaurant = restaurant)
                }
            }
        }
    }
}

@Composable
private fun HomeListData(
    restaurant: RestaurantData,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        /*.clickable(onClick = { selectRestaurant(restaurant.id) }
        ),*/
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(8.dp)
        ) {
            val (image,name, address, pinIcon, rate, starIcon) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.fagyizo),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(name.start)
                        centerVerticallyTo(parent)

                    }
                    .size(100.dp, 100.dp)

            )

            Text(
                modifier = Modifier
                    .constrainAs(name) {
                        start.linkTo(image.end)
                    }
                    .padding(start = 8.dp, top = 8.dp, end = 8.dp),
                text = restaurant.name,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 20.sp
            )

            Text(
                text = restaurant.rate.toString(),
                style = TextStyle(fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .constrainAs(rate) {
                        start.linkTo(image.end)
                        top.linkTo(name.bottom)
                        bottom.linkTo(pinIcon.top)
                    }
                    .padding(8.dp),
                fontSize = 16.sp
            )
            Icon(
                imageVector = Icons.Filled.Star,

                contentDescription = null,
                modifier = Modifier
                    .constrainAs(starIcon) {
                        top.linkTo(name.bottom)
                        start.linkTo(rate.end)
                        bottom.linkTo(pinIcon.top)
                    }
                    .size(30.dp),
                tint = Color(0xFFFFC107),

            )

            Icon(
                imageVector = Icons.Filled.PushPin,
                contentDescription = null,
                modifier = Modifier.constrainAs(pinIcon) {
                    start.linkTo(image.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(
                        rate.bottom

                    )
                },
                tint = Color(0xFFF44336)

            )
            Text(
                modifier = Modifier
                    .constrainAs(address) {
                        start.linkTo(pinIcon.end)
                        top.linkTo(rate.bottom)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(8.dp),
                text = restaurant.address,
                style = TextStyle(fontStyle = FontStyle.Italic),
                fontSize = 18.sp,
                maxLines = 3,
            )
        }
        

    }
}

@Composable
@Preview(name = "RestaurantList Light")
private fun RestaurantListPreviewLight() {
    RestaurantAppTheme(darkTheme = false) {
        HomeListData(
            restaurant = RestaurantData.mock(),
        )
    }
}
