package io.github.m4rzb4ni.feature_property.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.m4rzb4ni.domain.model.Property

@Composable
fun PropertyItem(
    property: Property,
    onItemClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
            .clickable(onClick = onItemClick)
    ) {
        Text(text = property.name, style = MaterialTheme.typography.bodyLarge)
        Text(text = "${property.type} • ${property.numberOfRooms} rooms • ${property.sizeInSqm} sqm",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
    }
}