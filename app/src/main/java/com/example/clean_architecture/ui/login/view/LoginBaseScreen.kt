package com.example.clean_architecture.ui.login.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.clean_architecture.ui.login.LoginViewModel
import com.example.clean_architecture.utils.Constants

@Composable
fun LoginBaseScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    Log.d("daeyoung", "LoginBaseScreen, loginViewModel: $loginViewModel")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate(Constants.LOGIN_ID_PW_ROUTE) }) {
            Text(text = "다음 화면으로 이동")
        }
    }
}