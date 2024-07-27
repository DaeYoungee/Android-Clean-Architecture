package com.example.clean_architecture.ui

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.clean_architecture.ui.login.view.LoginBaseScreen
import com.example.clean_architecture.ui.login.view.LoginIdPasswdScreen
import com.example.clean_architecture.utils.Constants.LOGIN_BASE_ROUTE
import com.example.clean_architecture.utils.Constants.LOGIN_GRAPH
import com.example.clean_architecture.utils.Constants.LOGIN_ID_PW_ROUTE


fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(startDestination = LOGIN_BASE_ROUTE, route = LOGIN_GRAPH) {
        composable(LOGIN_BASE_ROUTE) { entry ->
            val backStackEntry = remember(entry) {
                navController.getBackStackEntry(LOGIN_GRAPH)
            }
//            val backStackEntry = rememberNavControllerBackEntry(entry, appState, LOGIN_GRAPH)
//            LoginBaseScreen(hiltViewModel(entry))
            LoginBaseScreen(navController = navController, loginViewModel = hiltViewModel(backStackEntry))

        }
        composable(LOGIN_ID_PW_ROUTE) { entry ->
            val backStackEntry = remember(entry) {
                navController.getBackStackEntry(LOGIN_GRAPH)
            }
            LoginIdPasswdScreen(loginViewModel = hiltViewModel(backStackEntry))
        }
    }
}