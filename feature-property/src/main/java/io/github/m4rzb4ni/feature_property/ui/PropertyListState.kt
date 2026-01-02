package io.github.m4rzb4ni.feature_property.ui

import io.github.m4rzb4ni.domain.model.Property

data class PropertyListState(
    val isLoading: Boolean = false,
    val properties: List<Property> = emptyList(),
    val error: String? = null
)
