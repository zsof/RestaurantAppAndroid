package hu.zsof.restaurantApp.ui.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Games
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import hu.zsof.restaurantApp.HorizontalDottedProgressBar
import hu.zsof.restaurantApp.ui.main.NavScreen
import hu.zsof.restaurantApp.ui.screens.home.HomeViewModel
import hu.zsof.restaurantApp.ui.theme.Shapes

@Composable
fun Login(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val email = viewModel.email
    val password = viewModel.password
    val userName = viewModel.userName

    val loading = viewModel.loading
    val passwordVisible = viewModel.passwordVisible

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Welcome in RestaurantApp",
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.ExtraBold),
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally),

            )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email.value,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email, contentDescription = null
                )
            },
            maxLines = 1,
            isError = viewModel.emailError.value,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            textStyle = TextStyle(color = Color.Black),
            label = { Text(text = "Email address") },
            placeholder = { Text(text = "abc@gmail.com") },
            onValueChange = {
                email.value = it
                viewModel.validateEmail()
            },
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = userName.value,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Face, contentDescription = null
                )
            },
            maxLines = 1,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            ),
            textStyle = TextStyle(color = Color.Black),
            shape = MaterialTheme.shapes.large,
            label = { Text("User name") },
            onValueChange = {
                userName.value = it
            },
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password.value,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Password, contentDescription = null
                )
            },
            /*trailingIcon = {
            Icon(
                imageVector = Icons.Filled.RemoveRedEye,
                contentDescription = null,
                modifier = Modifier.clickable(onClick = {
                    passwordVisualTransformation =
                        if (passwordVisible.value != VisualTransformation.None) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        }
                })
            )
        },*/
            maxLines = 1,
            isError = viewModel.passwordError.value,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            textStyle = TextStyle(color = Color.Black),
            shape = MaterialTheme.shapes.large,
            label = { Text(text = "Password") },
            onValueChange = {
                password.value = it
                viewModel.validatePassword()
            },
        )

        Button(
            onClick = {
                navController.navigate(NavScreen.Home.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(50.dp)
                .clip(CircleShape)
        ) {
            if (loading.value) {
                HorizontalDottedProgressBar()
            } else {
                Text(text = "Log In")
            }
        }


        Box(modifier = Modifier.padding(vertical = 16.dp)) {
            Spacer(
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
            )
            Text(
                text = "Or use",
                color = Color.LightGray,
                modifier = Modifier
                    .align(Alignment.Center)
                    .background(MaterialTheme.colors.background)
                    .padding(horizontal = 16.dp)
            )

        }

        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Facebook,
                contentDescription = null
            )
            Text(
                text = "Sign in with Facebook",
                style = MaterialTheme.typography.h5.copy(fontSize = 14.sp),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Games,
                contentDescription = null
            )
            Text(
                text = "Sign in with Google",
                style = MaterialTheme.typography.h5.copy(fontSize = 14.sp),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        ) {
            Text(
                text = "Don't have an account?",
                modifier = Modifier
                    .padding(vertical = 16.dp),
            )
            Text(
                text = "Register",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 4.dp)
                    .clickable(onClick = {}),
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )
        }
    }
}