package com.example.clean_architecture.ui.login.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.clean_architecture.ui.components.LastPasswordVisibleCustomTextField
import com.example.clean_architecture.ui.login.LoginViewModel

@Composable
fun LoginIdPasswdScreen(loginViewModel: LoginViewModel = hiltViewModel()) {
    Log.d("daeyoung", "LoginIdPasswdScreen, loginViewModel: $loginViewModel")

    val loginIdPasswordUiState = loginViewModel.loginIdPasswordUiState.collectAsStateWithLifecycle()


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "phone")
        PhoneNumberField(
            phoneNumber = loginIdPasswordUiState.value.phoneNumber.number,
            updatePhoneNumber = { loginViewModel.updatePhoneNumber(it) },

        )
        Text(text = "password")
        PasswordTextField(password = loginIdPasswordUiState.value.password, updatePassword = { loginViewModel.updatePassword(it) }) {

        }
    }
}

@Composable
fun PhoneNumberField(phoneNumber: String, updatePhoneNumber: (String) -> Unit) {
    OutlinedTextField(
        value = phoneNumber,
        onValueChange = updatePhoneNumber,
    )
}


@Composable
fun PasswordTextField(password: String, updatePassword: (String) -> Unit, onDone: () -> Unit) {
//    OutlinedTextField(
//        value = password,
//        onValueChange = { updatePassword(it) },
//        label = { Text(text = "Password") }
//    )
    LastPasswordVisibleCustomTextField(
        value = password, onvalueChanged = updatePassword,
        modifier = Modifier
            .fillMaxWidth(),
        placeholderText = "비밀번호 입력",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onDone()
        }),
        onErrorState = false
    )
}