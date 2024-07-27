package com.example.clean_architecture

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.clean_architecture.ui.loginGraph
import com.example.clean_architecture.utils.Constants.LOGIN_GRAPH

@Composable
fun RootNavhost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = LOGIN_GRAPH, modifier = Modifier.fillMaxSize()) {
        loginGraph(navController)
    }
}