package io.github.m4rzb4ni.estateflow

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import io.github.m4rzb4ni.feature_property.navigation.PropertyDestinations
import io.github.m4rzb4ni.feature_property.navigation.propertyGraph

@Composable
fun EstateFlowNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = PropertyDestinations.List.route
    ) {
        propertyGraph(navController)
    }
}