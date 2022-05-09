package hu.zsof.restaurantApp.ui.screens.register

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {
    val password = mutableStateOf("")
    val email = mutableStateOf("")
    val userName = mutableStateOf("")
    val passwordError = mutableStateOf(false)
    val passwordVisible = mutableStateOf(false)
    val emailError = mutableStateOf(false)
    val loading = mutableStateOf(false)

    fun validatePassword() {
        if (password.value.isEmpty()) {
            passwordError.value = true
        } else if (password.value.length < 6) {
            passwordError.value = true
        }
        passwordError.value = false
    }

    fun validateEmail() {
        if (email.value.isEmpty()) {
            passwordError.value = true
        }
        emailError.value != Patterns.EMAIL_ADDRESS.matcher(email.value).matches()
    }
}