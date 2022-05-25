package hu.zsof.restaurantApp.ui.screens.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import hu.zsof.restaurantApp.HorizontalDottedProgressBar
import hu.zsof.restaurantApp.R
import hu.zsof.restaurantApp.model.UserData
import hu.zsof.restaurantApp.ui.main.AppBar
import hu.zsof.restaurantApp.ui.main.NavScreen

@Composable
fun Profile(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val user = UserData.mock()
    Scaffold(topBar = { AppBar() }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Profile Settings",
                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.ExtraBold),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally),

                )

            Image(
                painter = painterResource(R.drawable.profile_image),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)

            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp, end = 8.dp)
                    .align(Alignment.CenterHorizontally),
                text = user.name,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 20.sp
            )

            Row(
                modifier = Modifier
                    .padding(vertical = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Email, contentDescription = null
                )
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp),
                    text = user.email,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.Filled.Edit, contentDescription = null
                )
            }
            Row(
                modifier = Modifier
                    .padding(vertical = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Lock, contentDescription = null
                )
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp),
                    text = "*******",
                    fontSize = 20.sp
                )
                Icon(
                    imageVector = Icons.Filled.Edit, contentDescription = null
                )
            }

            Box(modifier = Modifier.padding(vertical = 16.dp)) {
                Spacer(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray)
                )
            }

            Text(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 4.dp, end = 8.dp),
                text = "Theme:",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Column() {
                viewModel.mItemsList.forEach { items ->
                    Row(
                    ) {
                        val isChecked = remember { mutableStateOf(false) }

                        Checkbox(
                            checked = isChecked.value,
                            onCheckedChange = { isChecked.value = it },
                            enabled = true
                        )
                        Text(text = items, modifier = Modifier.padding(top = 8.dp))
                    }
                }
            }
            Button(
                onClick = {
                },
                modifier = Modifier
                    .height(50.dp)
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Save")
            }
        }
    }
}
