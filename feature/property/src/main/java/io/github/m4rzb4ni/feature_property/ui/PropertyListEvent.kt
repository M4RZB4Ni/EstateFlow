package io.github.m4rzb4ni.feature_property.ui

sealed class PropertyListEvent {
    data class NavigationToDetail(val propertyId: String) : PropertyListEvent()
    data class ShowToast(val message: String) : PropertyListEvent()
}