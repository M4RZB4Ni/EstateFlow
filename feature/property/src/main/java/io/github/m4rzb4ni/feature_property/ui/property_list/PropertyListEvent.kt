package io.github.m4rzb4ni.feature_property.ui.property_list

sealed class PropertyListEvent {
    data class NavigationToDetail(val propertyId: String) : PropertyListEvent()
    data class ShowToast(val message: String) : PropertyListEvent()
}