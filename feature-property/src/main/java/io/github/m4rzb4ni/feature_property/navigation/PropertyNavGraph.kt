package io.github.m4rzb4ni.feature_property.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

sealed class PropertyDestinations(val route: String) {
    object List : PropertyDestinations("property_list")
    object Detail : PropertyDestinations("property_detail/{propertyId}") {
        fun createRoute(propertyId: String) = "property_detail/$propertyId"
    }
}

fun NavGraphBuilder.propertyGraph(navController: NavHostController) {
    composable(PropertyDestinations.List.route) {

    }
}