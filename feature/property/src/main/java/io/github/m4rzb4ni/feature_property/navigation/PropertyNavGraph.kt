package io.github.m4rzb4ni.feature_property.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import io.github.m4rzb4ni.feature_property.ui.property_list.PropertyListScreen
import io.github.m4rzb4ni.feature_property.ui.propety_detail.PropertyDetailScreen

sealed class PropertyDestinations(val route: String) {
    object List : PropertyDestinations("property_list")
    object Detail : PropertyDestinations("property_detail/{propertyId}") {
        fun createRoute(propertyId: String) = "property_detail/$propertyId"
    }
}

fun NavGraphBuilder.propertyGraph(navController: NavHostController) {
    composable(PropertyDestinations.List.route) {
        PropertyListScreen(
            onNavigateToDetails = { propertyId ->
                navController.navigate(PropertyDestinations.Detail.createRoute(propertyId = propertyId))
            }
        )
    }
    composable(
        route = PropertyDestinations.Detail.route,
        arguments = listOf(
            navArgument("propertyId") { type = NavType.StringType }
        )
    ) {
        PropertyDetailScreen()
    }
}