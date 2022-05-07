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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import hu.zsof.restaurantApp.model.RestaurantData
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import hu.zsof.restaurantApp.R
import hu.zsof.restaurantApp.ui.theme.RestaurantAppTheme

@Composable
fun HomeList(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val restaurants = viewModel.restaurants

    val listState = rememberLazyListState()
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
            val (name, address) = createRefs()

            /*Image(
                painter = painterResource(id = androidx.core.R.drawable.notification_template_icon_bg),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        end.linkTo(name.start)
                        centerVerticallyTo(parent)
                    }

            )*/

            Text(
                modifier = Modifier
                    .constrainAs(name) {
                        start.linkTo(parent.start)
                    }
                    .padding(8.dp),
                text = restaurant.name,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier
                    .constrainAs(address) {
                        start.linkTo(parent.start)
                        top.linkTo(name.bottom)
                    }
                    .padding(8.dp),
                text = restaurant.address,
                textAlign = TextAlign.Center
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
