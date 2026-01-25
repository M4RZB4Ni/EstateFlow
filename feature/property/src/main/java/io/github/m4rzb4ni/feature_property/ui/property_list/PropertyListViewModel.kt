package io.github.m4rzb4ni.feature_property.ui.property_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.m4rzb4ni.domain.model.Property
import io.github.m4rzb4ni.domain.usecase.GetPropertiesUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PropertyListViewModel @Inject constructor(
    private val getPropertiesUseCase: GetPropertiesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(PropertyListState())
    val uiState: StateFlow<PropertyListState> = _uiState

    private val _eventFlow = MutableSharedFlow<PropertyListEvent>()
    val eventFlow: SharedFlow<PropertyListEvent> = _eventFlow


    init {
        loadProperties()
    }

    private fun loadProperties() {
        viewModelScope.launch {
            updateState(isLoading = true)
            val properties = getPropertiesUseCase()
            properties.fold(
                onSuccess = { properties ->
                    updateState(properties = properties)
                },
                onFailure = { exception ->
                    updateState(error = exception.message)
                }
            )

        }
    }

    private fun updateState(
        isLoading: Boolean = false,
        properties: List<Property> = emptyList(),
        error: String? = null
    ) {
        _uiState.value = _uiState.value.copy(
            isLoading = isLoading,
            properties = properties,
            error = error
        )
    }

    fun onPropertyClick(propertyId: String) {
        viewModelScope.launch {
            _eventFlow.emit(PropertyListEvent.NavigationToDetail(propertyId))
        }
    }
}
